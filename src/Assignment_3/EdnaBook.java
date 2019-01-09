package Assignment_3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class EdnaBook {
	
	EdnaBook() {};

	EdnaBook(BufferedReader reader)
	{
		readSelf(reader);
	}
	
	void readSelf(BufferedReader reader)
	{
		String line = new String(); 
		try {
			line = reader.readLine();
			bookId = Integer.parseInt(line);
			name = reader.readLine();
			author = reader.readLine();
			line = reader.readLine();
			checkedOutByClientId = Integer.parseInt(line);
		} catch (IOException e) {
		    System.err.println("Caught IOException: " + e.getMessage());
		}
	}
	
	void dump()
	{
		System.out.println("bookid: "+bookId);
		System.out.println("name: "+name);
		System.out.println("authur: "+author);
		System.out.print("checked out by: ");
		if (checkedOutByClientId == 0)
		{
			System.out.println("No-one");
		}
		else
		{
			System.out.println("Client:"+checkedOutByClientId);
		}
	}
	
	void writeSelf(BufferedWriter writer)
	{
		try {
			writer.write(Integer.toString(bookId));
			writer.newLine();
			writer.write(name);
			writer.newLine();
			writer.write(author);
			writer.newLine();
			writer.write(Integer.toString(checkedOutByClientId));
			writer.newLine();
		} catch (IOException e) {
		    System.err.println("Caught IOException: " + e.getMessage());
		}
	}
	
	Integer bookId;
	String name;
	String author;
	Integer checkedOutByClientId; // 0 indicates no-one
}
