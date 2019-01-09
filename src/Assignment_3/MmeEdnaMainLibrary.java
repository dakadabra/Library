package Assignment_3;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class MmeEdnaMainLibrary {
	
	static String FILE_NAME = "LibraryDataMmeEdna.txt";
	
	static Vector<Client> clients = new Vector<Client>(); 
	static Vector<Book> books = new Vector<Book>();
	
	static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		
		readInDatabase();
		
		System.out.println("Welcome to the Ottawa not-so-public library.");
		System.out.println();
		
		while (true)
		{
			topMenu();
			System.out.println("Anything else to do (y/n)?");	
			input.reset();
			String response = input.next();
			if (!response.equalsIgnoreCase("y"))
			{
				System.out.println("Ok, bye!");
				break;
			}
		}
		
		input.close();
		
		writeOutDatabase();
	}  
	
	// the top most menu of the program
	static void topMenu()
	{
		try
		{
			System.out.println("You want to:");
			System.out.println("  (s)earch for a book?");
			System.out.println("  (p)rint out all books?");
			System.out.println("  (d)onate a book?");
			System.out.println("  (l)ogin?");
			System.out.println("  (c)reate a client account?");
			
			String response = input.next();
			input.nextLine(); // consume the newline
			switch(response)
			{
			case("s"):
				bookSearch();
			break;
			case("p"):
				printAllBooks();
			break;
			case("d"):
				addBook();
			break;
			case("l"):
				processNextUser();
			break;
			case("c"):
				processNewUser();
			break;
			default:
				System.out.println("That's not an option");
			}
			
		} catch (Exception e) {
		    System.err.println("I don't understand your response");
		}
		
	}
	
	// look up a library user, and if found call to process their request
	static void processNextUser()
	{
		System.out.println("What's your client id?");
		
		int clientId = input.nextInt();
		int foundIndex = -1;
		for (int index=0; index<clients.size(); index++)
		{
			if (clients.elementAt(index).clientId == clientId)
			{
				// found you
				foundIndex = index; 
			}
		}
		if (foundIndex >= 0)
		{
			processUserRequest(foundIndex);
		}
		else
		{
			System.out.println("Can't find you in our records.  Try again.");
		}
	}
	
	static boolean readInDatabase()
	{
		// if the database exists, read it in
	    Path path = Paths.get(FILE_NAME);
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			//try (BufferedReader reader = Files.newBufferedReader(path)) {

			String line = null;
		    
			// first entry is the number of clients
		    line = reader.readLine();
		    if (line == null)
		    {
		    	System.out.println("Database exists but is empty!");
		    	return false;
		    }
		    int numClients = 0;
		    try {
		    	numClients = Integer.parseInt(line);
		    } catch (Exception e)
		    {
		    	System.out.println("Database exists but is corrupt!");
		    	return false;
		    }
		   
		    // next entry is the number of books
		    line = reader.readLine();
		    if (line == null)
		    {
		    	System.out.println("Database exists but is corrupt!");
		    	return false;
		    }
		    int numBooks = Integer.parseInt(line);
		    
		    // read them in
		    for (int clientNum=0; clientNum<numClients; clientNum++)
		    {
		    	clients.add(new Client(reader));
		    	clients.elementAt(clients.size()-1).dump();
		    }
		    for (int bookNum=0; bookNum<numBooks; bookNum++)
		    {
		    	books.add(new Book(reader));
		    	books.elementAt(books.size()-1).dump();
		    }
		    
		    reader.close();

		} catch (IOException e) {
		    System.err.println("No library database, starting new one: " + e.getMessage());
		}
		
		return true;
	}
	
	static void writeOutDatabase()
	{
		Path path = Paths.get(FILE_NAME);
	//	try (BufferedWriter writer = Files.newBufferedWriter(path)) 
				try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
		    
			BufferedWriter writer = null;//added line
			// first entry is the number of clients
			writer.write(Integer.toString(clients.size()));
			writer.newLine();
			// next entry is the number of books
			writer.write(Integer.toString(books.size()));
			writer.newLine();
			
			// write them out
		    for (int clientNum=0; clientNum<clients.size(); clientNum++)
		    {
		    	clients.elementAt(clientNum).writeSelf(writer);
		    }
		    for (int bookNum=0; bookNum<books.size(); bookNum++)
		    {
		    	books.elementAt(bookNum).writeSelf(writer);
		    }
		    writer.close();

		} catch (IOException e) {
		    System.err.println("Caught IOException: " + e.getMessage());
		}
	}

	// ask the user what they'd like to do, and then try to do it
	static void processUserRequest(int clientIndex)
	{
		System.out.println("OK, you're in.  What do you want to do?");
		System.out.println("  (b)orrow for a book?");
		System.out.println("  (r)eturn a book?");
		System.out.println("  (l)ist checked out books?");
		
		try {
			String response = input.next();
			switch(response)
			{
			case("b"):
			case("r"):
				break;
			case("l"):
				if (clients.elementAt(clientIndex).booksCheckedOut.size() == 0)
				{
					System.out.println("You don't currently have any checked out books.");
				}
				else
				{
					System.out.println("Here's your list of currently checked out books:");
					for (int bookNum=0; bookNum<clients.elementAt(clientIndex).booksCheckedOut.size(); bookNum++)
					{
						clients.elementAt(clientIndex).booksCheckedOut.elementAt(bookNum).dump();
					}
				}
				return;
			default:
				System.err.println("I don't understand your response");
				return;
			}
	
			int bookIndex = bookSearch();
			if (bookIndex == -1)
			{
				return;
			}
			switch(response)
			{
			case("b"):
				// first check if anyone has it out already
				for (int i=0; i<clients.size(); i++)
				{
					if (clients.elementAt(clientIndex).booksCheckedOut.contains(books.elementAt(bookIndex)))
					{
						// someone else already has the book out
						System.out.println("Sorry.  That book has already been loaned out.");
						return;
					}
				}
				clients.elementAt(clientIndex).booksCheckedOut.add(books.elementAt(bookIndex));
				books.elementAt(bookIndex).checkedOutByClientId = clients.elementAt(clientIndex).clientId;
				System.out.println("It's all yours");
				System.out.println("Here's your list of currently checked out books:");
				for (int bookNum=0; bookNum<clients.elementAt(clientIndex).booksCheckedOut.size(); bookNum++)
				{
					clients.elementAt(clientIndex).booksCheckedOut.elementAt(bookNum).dump();
				}
				break;
			case("r"):
				if (clients.elementAt(clientIndex).booksCheckedOut.contains(books.elementAt(bookIndex)))
				{
					books.elementAt(bookIndex).checkedOutByClientId = 0;
					clients.elementAt(clientIndex).booksCheckedOut.remove(books.elementAt(bookIndex));
					System.out.println("OK, it's returned.  Thank you.");
				}
				else
				{
					System.out.println("You don't have it out.");
				}
				if (clients.elementAt(clientIndex).booksCheckedOut.size() == 0)
				{
					System.out.println("You don't currently have any checked out books.");
				}
				else
				{
					System.out.println("Here's your list of currently checked out books:");
					for (int bookNum=0; bookNum<clients.elementAt(clientIndex).booksCheckedOut.size(); bookNum++)
					{
						clients.elementAt(clientIndex).booksCheckedOut.elementAt(bookNum).dump();
					}
				}
				break;
			}
		} catch (Exception e) {
		    System.err.println("I don't understand your response");
		}
		
	}
	
	// add a book to the library
	static void addBook()
	{
		Book newBook = new Book();
		newBook.bookId = books.size();
		System.out.println("That's great!  I'll just need some info on the book.  Can you tell me it's name:");
		newBook.name = input.nextLine();
		System.out.println("Can you tell me the author:");
		newBook.author = input.nextLine();
		newBook.checkedOutByClientId = new Integer(0);
		books.add(newBook);
		System.out.println("Thank you!  Leave the book in the slot please.");
	}
	
	// add a client to the library
	static void processNewUser()
	{
		System.out.println("OK.  Let's get you setup.");
		Client newClient = new Client();
		newClient.clientId = clients.size()+1;
		newClient.fines = 0;
		System.out.println("I'll just need some info about you.  Can you tell me your first name:");
		newClient.firstName = input.next();
		System.out.println("Can you tell me your last name:");
		newClient.lastName = input.next();
		System.out.println("Can you tell me your address:");
		newClient.address = input.nextLine();
		clients.add(newClient);
		System.out.println("Thank you!  You're all setup.  Your client id is:");
		System.out.println(newClient.clientId);
	}
	
	// look for a book based on a string that may be either the author or title field
	static int bookSearch()
	{
		System.out.println("OK.  What is the name of the book/authur?");
		String searchString = input.next();
		
		for (int i = 0; i<books.size(); i++)
		{
			if ((books.elementAt(i).name.contains(searchString)) ||
				(books.elementAt(i).author.contains(searchString)))
			{
				System.out.println("Ok.  Found it:");
				books.elementAt(i).dump();
				return i;
			}
		}
		System.out.println("Can't find that book:");
		return -1;
	}
	
	// print out all library books
	static void printAllBooks()
	{
		for (int bookNum=0; bookNum<books.size(); bookNum++)
		{
			books.elementAt(bookNum).dump();
		}
	}
}
	