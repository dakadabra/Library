import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/*
Sites used:

¥ (To append) http://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java

 */

/*To do:
		
		(Later) Add return a book
	
	Bugs:
	Sometimes doesn't let enter title (Document given shows how to skip empty lines?) (console.next()?)
*/

public class David_Main {
	public static void main (String[] args) {
		Scanner console = new Scanner (System.in);
		
		int numberOfBooks = 0;
		int chooseBookInt = 0;
		String ClientFile = "/Users/khazzamAir/Dropbox/David - Coding (1)/Emma_Eclipse_Nov18/Temp/LibraryClientInfoDavid1.txt";
		String BookFile = "/Users/khazzamAir/Dropbox/David - Coding (1)/Emma_Eclipse_Nov18/Temp/LibraryBookInfoDavid1.txt";
		int currentUser = 0;
		
		
		//Create client and book lists
		Vector<David_Client> listClients = new Vector<David_Client>();
		Vector<David_Book> listBooks = new Vector<David_Book>();

		boolean notdone1 = true;
		boolean notdone2 = true;
		
		//Welcome message
		System.out.println("                                     Welcome to our library!"
			+ "\n                       If it's out there, it is almost certainly not in here.");
		
		
		//Client
		//file does not have a value.
		   BufferedReader file = null;

			try
			{
				//file = new BufferedReader(new FileReader("\\Sample1.txt"));
				
				//file is now a BufferedReader and reads Sample1 which in in Temp folder
				file = new BufferedReader(new FileReader(ClientFile));
				String line;
				String emptySpace1 = " ";
				
				
				for(int readClient = 0; (line = file.readLine()) != null; readClient++)
					{	
						David_Client client0 = new David_Client();
						listClients.add(client0);
					
						listClients.get(readClient).firstName = line;
						line = file.readLine();
						listClients.get(readClient).lastName = line;
						line = file.readLine();
						listClients.get(readClient).userName = line;
						line = file.readLine();
						listClients.get(readClient).password = line;
						line = file.readLine();
						listClients.get(readClient).accountID = (line);
						line = file.readLine();
						listClients.get(readClient).booksOut = Integer.parseInt(line);
						line = file.readLine();
						for(int bookstaken = 0; bookstaken < 5; bookstaken++) {
							listClients.get(readClient).booksArray[bookstaken] = Integer.parseInt(line);
							line = file.readLine();
						}
						emptySpace1 = line;
					}
					
			}
			//If file is not found
	      catch (FileNotFoundException e)
	      {
	         System.err.println("Cannot open file");
	      }
			//Exits program if there is an error
	      catch (IOException e)
	      {
	         System.exit(0);
	      }
	      finally
	      {
	    	  
	    	 //?
	         try
	         {
	            if (file != null) file.close();
	         }
	         catch (IOException e)
	         {
	            System.err.println(e);
	         }
	      }
		
			
			
			//Book
			//file does not have a value.
			   BufferedReader file2 = null;

				try
				{
					//file = new BufferedReader(new FileReader("\\Sample1.txt"));
					
					//file is now a BufferedReader and reads Sample1 which in in Temp folder
					file2 = new BufferedReader(new FileReader(BookFile));
					String line2;
					String emptySpace2 = " ";
					
					//While there is still information in the files, continue reading
					for(int readBook = 0; (line2 = file2.readLine()) != null; readBook++)
						{	
							
							//Create a new book with temporary information, so I can assign it
							//The book information on the file
							David_Book book01 = new David_Book("Temp_title1", "Temp_first1", "Temp_last1", "400", false, "4-631", "7", false, 0);
							listBooks.add(book01);
							numberOfBooks ++;
							
							//Read the lines and assign the information to the book01
							listBooks.get(readBook).title = line2;
							line2 = file2.readLine();
							listBooks.get(readBook).authorFirst = line2;
							line2 = file2.readLine();
							listBooks.get(readBook).authorLast = line2;
							line2 = file2.readLine();
							listBooks.get(readBook).pages = line2;
							line2 = file2.readLine();
							listBooks.get(readBook).virtual = Boolean.parseBoolean(line2);
							line2 = file2.readLine();
							listBooks.get(readBook).ISBN = line2;
							line2 = file2.readLine();
							listBooks.get(readBook).numberCopies = line2;
							line2 = file2.readLine();
							listBooks.get(readBook).borrowed = Boolean.parseBoolean(line2);
							line2 = file2.readLine();
							listBooks.get(readBook).bookNumber = Integer.parseInt(line2);
							line2 = file2.readLine();
							//There is an empty space on the files so it's more user friendly
							emptySpace2 = line2;
						}
						
				}
				//If file is not found
		      catch (FileNotFoundException e)
		      {
		         System.err.println("Cannot open file");
		      }
				//Exits program if there is an error
		      catch (IOException e)
		      {
		         System.exit(0);
		      }
		      finally
		      {
		    	  
		    	 //When done, close file so doesn't become corrupted for next time
		         try
		         {
		            if (file2 != null) file2.close();
		         }
		         catch (IOException e)
		         {
		            System.err.println(e);
		         }
		      }
			
		
		
			while (notdone2){
			
				System.out.println("\n\nWould you like to create and account (type a and press ENTER)"
							+ "\nor login with a previous account (type l and press ENTER)");
				
				//Reads what the user wrote
				Scanner input1 = new Scanner(System.in);
		    	String choice1 = input1.nextLine().toUpperCase();
		    	char accountQ1 = choice1.charAt(0);
				
				switch (accountQ1) {
					
					//If the user wants to create an account
					case 'A': {
						
						//Creates a client object	
						David_Client client1 = new David_Client();
						//Adds a client to the listClients vector
						listClients.add(client1);
						
						  
						//Adds first name
						System.out.println("What is your first name?");
						client1.firstName = console.nextLine();
						
						//Adds last name
						System.out.println("What is your last name?");
						client1.lastName = console.nextLine();
						
						//Adds username
						System.out.println("Please create a username.");
						client1.userName = console.nextLine();
						
						//Adds password
						System.out.println("Please create a password.");
						client1.password = console.nextLine();
						
						//Gives the client an ID
						int tempAccountID = listClients.size();
						client1.accountID = Integer.toString(tempAccountID);
						
						//To account for the fact that the first thing in a Vector is equal to 0
						currentUser = tempAccountID - 1;
						
						int START = 1000;
					    int END = 10000;
					    
					    //Uses randInt method
					    int tempRandInt1 = randInt(START, END);  
					    int tempRandInt2 = randInt(START, END);
					    int tempRandInt3 = randInt(START, END);
					      
					    //Adds the three random numbers generated in randInt to the end
					    //of accountID
					    client1.accountID = client1.accountID + " " + tempRandInt1 + " " + tempRandInt2 + " " + tempRandInt3;
						
						
						System.out.print("Welcome " + client1.userName + "!"
								+ "\nYour ID number is " + client1.accountID);
						
						
						System.out.println("\nYou have sucessfully created and account and are now logged in.");
						
						notdone2 = false;
						break;
					}
					
					//If the user wants to login
					case 'L': {
						System.out.println("What is your username?");
						String enteredUserName = console.nextLine();
						
						for (int lookForUsername = 0; lookForUsername < listClients.size(); lookForUsername++) {
							if (enteredUserName.equals(listClients.get(lookForUsername).userName)){
								
								System.out.println("What is your password?");
								String enteredPassword = console.nextLine();
								
								
									if (enteredPassword.equals(listClients.get(lookForUsername).password)){
										notdone2 = false;
										currentUser = lookForUsername;
										break;
									}
							}
						}
						
						if (notdone2 == true) {
							System.out.println("The username or password you entered is not valid.");
						}
						
						break;
					}
					
					//If the user does not enter either a, or l.
					default: {
						System.out.println("Please enter either a or l.");
						break;
					}
				}
			}
			
			while (notdone1) {
			
				System.out.println("\n\n                      MAIN MENU"
						+ "\nDo you want to borrow a book? (type b and press ENTER)"
						+ "\nor donate a book? (type d and press ENTER)"
						+ "\nor look at your account information? (type i and press ENTER)"
						+ "\nor Exit the library and save your information? (type x then press ENTER)?");
				
				//Reads input from user
				Scanner input2 = new Scanner(System.in);
		    	String choice2 = input2.nextLine().toUpperCase();
		    	char accountQ2 = choice2.charAt(0);
				
						
				switch (accountQ2) {
					
					//If the user wants to borrow a book
					case 'B': {
						
						//If there are no books in the library
						if (numberOfBooks == 0) {
							System.out.println("Sorry, we do not have any books at the moment."
									+ "\nIf you would like to take one out, please donate it first.");
							
							break;
						}
						
						//If there are books in the library
						else
						System.out.println("We currently have " + numberOfBooks + " books in our library."
								+ "\nHere are their titles:");
						
						boolean bookChosen = false;
								
						do {
						
						//Prints the book titles
						for (int bookCounter = 0; bookCounter < listBooks.size(); bookCounter++) {
							System.out.println("\n" + (bookCounter+1) + ". " + listBooks.get(bookCounter).title);
						}
						
						System.out.println("\nTo see more information about a book, type its number.");
					
						//Reads the number entered
						chooseBookInt = console.nextInt();
						
						//If they do not enter a number equivalent to a book
						if (chooseBookInt > listBooks.size() || chooseBookInt < 1) {
							System.out.println("Please enter a number equivalent to a book.");
							bookChosen = true;
						}
						
						else {
							/*Accounts for the order of numbers in arrays
							(Because the first number in an array is 0, we need to change the number entered).
							*/
							chooseBookInt --;
							
							//Prints information about the book
							System.out.println("\n" + listBooks.get(chooseBookInt).title +
									" was written by " + listBooks.get(chooseBookInt).authorFirst +
									" " + listBooks.get(chooseBookInt).authorLast + ".");
							bookChosen = false;
						}
						
						} while(bookChosen);
						
						boolean notdone3 = false;
						
						do {
						
							notdone3 = false;
							
							System.out.println("Would you like to borrow this book? (y)es or (n)o");
							
							//Reads the input
							Scanner inputBorrow = new Scanner(System.in);
					    	String choiceBorrow = inputBorrow.nextLine().toUpperCase();
					    	char borrowQ = choiceBorrow.charAt(0);
							
							switch (borrowQ) {
								
								
								case 'Y': {
									
									//If the book has not been taken out
									if (listBooks.get(chooseBookInt).borrowed == false && listClients.get(currentUser).booksOut < 5) {
										listBooks.get(chooseBookInt).borrowed = true;
										System.out.println("You have sucessfully borrowed " + listBooks.get(chooseBookInt).title + "!");
										listClients.get(currentUser).booksOut ++;
										
										if (listClients.get(currentUser).booksArray[0] == 0) {
											listClients.get(currentUser).booksArray[0] = listBooks.get(chooseBookInt).bookNumber;
										}
										
										else {
											
											if (listClients.get(currentUser).booksArray[1] == 0) {
												listClients.get(currentUser).booksArray[1] = listBooks.get(chooseBookInt).bookNumber;
											}
											
											else {
												if (listClients.get(currentUser).booksArray[2] == 0) {
													listClients.get(currentUser).booksArray[2] = listBooks.get(chooseBookInt).bookNumber;
												}
												
												else {
													if (listClients.get(currentUser).booksArray[3] == 0) {
														listClients.get(currentUser).booksArray[3] = listBooks.get(chooseBookInt).bookNumber;
													}
													
													else {
														if (listClients.get(currentUser).booksArray[4] == 0) {
															listClients.get(currentUser).booksArray[4] = listBooks.get(chooseBookInt).bookNumber;
														}
													}
												}
											}
										}
									}
									
									//If the book has been taken out
									else if (listBooks.get(chooseBookInt).borrowed == true) {
										System.out.println("Sorry, this book has already been taken out.");
									}
									
									else if (listClients.get(currentUser).booksOut >= 5) {
										System.out.println("Sorry, but the maximum amount of books yoou can borrow is 5.");
									}
									
										}
								
								//If the user does not want to borrow it, break
								case 'N': {break;}
								
								default : {
									System.out.println("Please enter either y or n.");
									notdone3 = true;
								}
							}
							
						} while (notdone3);
						
						break;
						}
					
					//If the user wants to donate a book
					case 'D': {
						
						//Creates a book object
						David_Book book1 = new David_Book("Temp_title2", "Temp_first2", "Temp_last2", "400", false, "4-631", "7", false, 0);
						//Adds a book to the listBooks vector
						listBooks.add(book1);
						numberOfBooks ++;
						
						System.out.println("What is the title of the Book?");
						book1.title = console.nextLine();
						
						System.out.println("What is the first name of the author of the Book?");
						book1.authorFirst = console.nextLine();
						
						System.out.println("What is the last name of the author of the Book?");
						book1.authorLast = console.nextLine();
						
						book1.bookNumber = numberOfBooks;
						
						System.out.println("Thank you for your generous donation!");
						
						break;		
					}
					
					//If the user wants to look at information about their account
					case 'I': {

						System.out.print("Name: " + listClients.get(currentUser).firstName + " "
								+ listClients.get(currentUser).lastName
								+ "\nUsername: " + listClients.get(currentUser).userName
								+ "\nPassword: " + listClients.get(currentUser).password
								+ "\nAccount ID: " + listClients.get(currentUser).accountID
								+ "\nNumber of books taken out: " + listClients.get(currentUser).booksOut
								+ "\nBooks taken out:");
								for(int infoBooksTaken = 0; infoBooksTaken < listClients.get(currentUser).booksOut; infoBooksTaken++) {
							System.out.print(" " + listBooks.get(listClients.get(currentUser).booksArray[infoBooksTaken] - 1).title + "    ");
						};
						
						break;	
					}
					
					//If the user wants to exit
					case 'X': {
						
						//Saves the book information
						try {
						    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(BookFile)));
	
						    //While there are still books in the listBooks vector,
						    //save the book to the file
							for(int printBook = 0; printBook < listBooks.size(); printBook++)
							{	writer.println(listBooks.get(printBook).title +
								"\n" + listBooks.get(printBook).authorFirst +
								"\n" + listBooks.get(printBook).authorLast +
								"\n" + listBooks.get(printBook).pages +
								"\n" + listBooks.get(printBook).virtual +
								"\n" + listBooks.get(printBook).ISBN +
								"\n" + listBooks.get(printBook).numberCopies + 
								"\n" + listBooks.get(printBook).borrowed + 
								"\n" + listBooks.get(printBook).bookNumber +"\n");
							}
							writer.close();
						}
						//If it doesn't work
						catch(IOException e)
						{	System.err.println("An error occured while trying to write book information to the file.");
							break;
						}
						
						
						//Save the client information
						try {
						    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(ClientFile)));
						
						    //While there are still clients in the listClients vector,
						    //save the client information to the file
							for(int printClient = 0; printClient < listClients.size(); printClient++)
							{	writer.print(listClients.get(printClient).firstName +
								"\n" + listClients.get(printClient).lastName +
								"\n" + listClients.get(printClient).userName +
								"\n" + listClients.get(printClient).password +
								"\n" + listClients.get(printClient).accountID +
								"\n" + listClients.get(printClient).booksOut + "\n");
							
							for(int printBooksTaken = 0; printBooksTaken < 5; printBooksTaken++) {
								writer.println(listClients.get(printClient).booksArray[printBooksTaken]);
							} writer.print("\n");
							}
							writer.close();
						}
						//If it doesn't work
						catch(IOException e)
						{	System.err.println("An error occured while trying to write client information to the file.");
							break;
						}
						
						notdone1 = false;
						//End message
						System.out.println("\nHave a nice day!"
								+ "\nYou have been successfully logged out.");
						
						break;
					}
					
					//If the user does not enter either b, d or x.
					default: {
						System.out.println("Plese enter either b, d, i or x.");
					}
				
				}
				
			}//notdone1
		
	} //public static void
	
	public static int randInt(int min, int max) {
		
		//create a Random
	    Random rand = new Random();

	    //Assigns the Random something between min and max
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    
	    //Returns the Random
	    return randomNum;
	}
} //public class main