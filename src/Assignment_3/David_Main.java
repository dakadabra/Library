package Assignment_3;
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
• (To append) http://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
• (Bubble sort) http://www.programmingsimplified.com/java/source-code/java-program-to-bubble-sort
 */

/*	To do:
		Use enum
		
		Instead of password put ***** (maybe: http://stackoverflow.com/questions/8138411/masking-password-input-from-the-console-java)
*/

public class David_Main {
	public static void main (String[] args) {
		Scanner console = new Scanner (System.in);
		
		int numberOfBooks = 0;
		String ClientFile = "/Users/khazzamAir/Dropbox/David - Coding (1)/Emma_Eclipse_Nov18/Temp/LibraryClientInfoDavid2.txt";
		String BookFile = "/Users/khazzamAir/Dropbox/David - Coding (1)/Emma_Eclipse_Nov18/Temp/LibraryBookInfoDavid2.txt";
		int currentUser = 0;
		
		
		//Create client and book lists
		Vector<David_Client> listClients = new Vector<David_Client>();
		Vector<David_Book> listBooks = new Vector<David_Book>();

		boolean notdone1 = true;
		boolean notdone2 = true;
		boolean borrowBug = false;
		boolean accountBug = true;
		
		char aChar = 'a';
		while (true){
			//"Choose your language" lines
			System.out.println("To choose your language, press F or E. Pour choisir votre langage, appuyez le F ou l’E.:");
			System.out.println("F.Français");
			System.out.println("E.English");
			
			String aString = console.next().toUpperCase();;//Used to allow selecting menus with letters
			aChar = aString.charAt(0); //Used to allow selecting menus with letters
		
			
			if(aChar == 'F') { 
				//Welcome message
				System.out.println("                   	   Bienvenue à notre Bibliothèque!"
					+ "\n                       Si ça existe, on ne l’a presque surement pas.");
				break;
			}
				
			else if(aChar == 'E') { 
				//Welcome message
				System.out.println("                                     Welcome to our library!"
					+ "\n                       If it's out there, it is almost certainly not in here.");
				break;
			}
			
			System.out.println("Please enter f or e.\nÉcrivez s'il vous plait le f ou l’e.\n");			
		}
		
		//Client
		//file does not have a value.
		   BufferedReader file = null;

			try
			{
				//file = new BufferedReader(new FileReader("\\Sample1.txt"));
				
				//file is now a BufferedReader and reads Sample1 which in in Temp folder
				file = new BufferedReader(new FileReader(ClientFile));
				String line;
				String blankSpace1 = " ";
				
				
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
						blankSpace1 = line;
					}
					
			}
			//If file is not found
	      catch (FileNotFoundException e)
	      {
	    	if(aChar == 'F') {
	  			System.err.println("Ne peut pas ouvrir le document.");
	  		}
	  			
	  		else if(aChar == 'E') { 
	  			System.err.println("Cannot open file");
	  		}
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
					String blankSpace2 = " ";
					
					//While there is still information in the files, continue reading
					for(int readBook = 0; (line2 = file2.readLine()) != null; readBook++)
						{	
							
							//Create a new book with temporary information, so I can assign it
							//The book information on the file
							David_Book book01 = new David_Book("Temp_title1", "Temp_first1", "Temp_last1", "400", false, "4-631", "7", false, 0, 0);
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
							listBooks.get(readBook).borrowedBy = Integer.parseInt(line2);
							line2 = file2.readLine();
							//There is an empty space on the files so it's more user friendly
							blankSpace2 = line2;
						}
						
				}
				//If file is not found
		      catch (FileNotFoundException e)
		      {
		    	  if(aChar == 'F') {
			  			System.err.println("Ne peut pas ouvrir le document.");
			  		}
			  			
			  		else if(aChar == 'E') { 
			  			System.err.println("Cannot open file");
			  		}
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

				int timesTried = 0;
				
			while (notdone2){
				try {
					if(aChar == 'F') {
			  			System.out.println("\n\nEst-ce que tu voudrais créer un acompte (appuie a et ensuite ENTER)"
			  					+ "\nou ouvrir une session avec un acompte déjà créé (appuie l et ensuite ENTER)");
			  		}
			  			
			  		else if(aChar == 'E') { 
			  			System.out.println("\n\nWould you like to create and account (type a and press ENTER)"
								+ "\nor login with a previous account (type l and press ENTER)");
			  		}
			  			
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

							boolean firstNameWrong = true;
							boolean lastNameWrong = true;
							boolean userNameWrong = true;
							boolean passwordWrong = true;
							do {
								//Adds first name
								if(aChar == 'F') {
						  			System.out.println("Qu'est-ce qu'est ton prénom?");
						  		}
						  			
						  		else if(aChar == 'E') { 
						  			System.out.println("What is your first name?");
						  		}
								
								if (accountBug) {
									client1.firstName = console.nextLine();
									accountBug = false;
								}
								client1.firstName = console.nextLine();
								if (client1.firstName.length() <= 0) {
									if(aChar == 'F') {
										System.out.println("Écrivez ton prénom s'il vous plait.\n");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Write your first name please.\n");
								  	}
									continue;
								}
								else {
									firstNameWrong = false;
								}
							} while (firstNameWrong);
							
							do {
								//Adds last name
								if(aChar == 'F') {
						  			System.out.println("Qu'est-ce qu'est ton nom de famille?");
						  		}
						  			
						  		else if(aChar == 'E') {
									System.out.println("What is your last name?");
						  		}
								client1.lastName = console.nextLine();
								if (client1.lastName.length() <= 0) {
									if(aChar == 'F') {
										System.out.println("Écrivez ton nom de famille s'il vous plait.\n");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Write your last name please.\n");
								  	}
									continue;
								}
								else {
									lastNameWrong = false;
								}
							} while (lastNameWrong);
							
							do {
								//Adds username
								if(aChar == 'F') {
						  			System.out.println("S'il vous plait créé un nom d'utilisateur.");
						  		}
						  			
						  		else if(aChar == 'E') {
						  			System.out.println("Please create a username.");
						  		}
								client1.userName = console.nextLine();
								if (client1.userName.length() <= 0) {
									if(aChar == 'F') {
										System.out.println("Écrivez un nom d'utilisateur s'il vous plait.\n");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Write a username please.\n");
								  	}
									continue;
								}
								else {
									userNameWrong = false;
								}
							} while (userNameWrong);
							
							do {
								//Adds password
								if(aChar == 'F') {
						  			System.out.println("S'il vous plait créé un mot-de-passe.");
						  		}
						  			
						  		else if(aChar == 'E') {
						  			System.out.println("Please create a password.");
						  		}
								client1.password = console.nextLine();
								if (client1.password.length() <= 0) {
									if(aChar == 'F') {
										System.out.println("Écrivez un mot-de-passe s'il vous plait.\n");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Write a password please.\n");
								  	}
									continue;
								}
								else {
									passwordWrong = false;
								}
							} while (passwordWrong);
							
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
							
						    if(aChar == 'F') {
						    	System.out.print("Bienvenue " + client1.userName + "!"
										+ "\nTon chiffre ID est " + client1.accountID);
						    	System.out.println("\nTu as créé un accompte et est maintenant connecté.");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.print("Welcome " + client1.userName + "!"
										+ "\nYour ID number is " + client1.accountID);
					  			System.out.println("\nYou have sucessfully created and account and are now logged in.");
					  		}
							
							notdone2 = false;
							break;
						}
						
						//If the user wants to login
						case 'L': {
							accountBug = false;
							if(aChar == 'F') {
					  			System.out.println("Qu'est-ce qu'est ton nom d'utilisateur?");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.println("What is your username?");
					  		}
							String enteredUserName = console.nextLine();
							if (timesTried == 0) {
								enteredUserName = console.nextLine();
							}
							
							for (int lookForUsername = 0; lookForUsername < listClients.size(); lookForUsername++) {
								if (enteredUserName.equals(listClients.get(lookForUsername).userName)){
									
									if(aChar == 'F') {
							  			System.out.println("Qu'est-ce qu'est ton mot-de-passe?");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("What is your password?");
							  		}
									String enteredPassword = console.nextLine();
									
									
										if (enteredPassword.equals(listClients.get(lookForUsername).password)){
											notdone2 = false;
											currentUser = lookForUsername;
											if(aChar == 'F') {
									  			System.out.println("Bienvenue " + listClients.get(currentUser).firstName + " " + listClients.get(currentUser).lastName + "!");
									  		}
									  			
									  		else if(aChar == 'E') {
									  			System.out.println("Welcome back " + listClients.get(currentUser).firstName + " " + listClients.get(currentUser).lastName + "!");
									  		}
											break;
										}
								}
							}
							
							if (notdone2 == true) {
								
								if(aChar == 'F') {
						  			System.out.println("Le nom d'utilisateur ou mot-de-passe écrit n'est pas valide.");
						  		}
						  			
						  		else if(aChar == 'E') {
						  			System.out.println("The username or password you entered is not valid.");
						  		}
						  		timesTried ++;
							}
							
							break;
						}
						
						//If the user does not enter either a, or l.
						default: {
							if(aChar == 'F') {
					  			System.out.println("Écrit a ou l s'il vous plait.");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.println("Please enter either a or l.");
					  		}
							break;
						}
					}
				} catch (Exception e) {
					if(aChar == 'F') {
			  			System.out.println("Écrit a ou l s'il vous plait.");
			  		}
			  			
			  		else if(aChar == 'E') {
			  			System.out.println("Please enter either a or l.");
			  		}
				}
			}
			
			while (notdone1) {
				try {
					if(aChar == 'F') {
						System.out.println("\n\n                      MENU"
								+ "\nVeut tu emprunter un livre? (écrivez b et appuye ENTER)"
								+ "\nou retourner un livre? (écrivez r et appuye ENTER)"
								+ "\nou donner un livre? (écrivez d et appuye ENTER)"
								+ "\nou regarder l'information de ton accompte? (écrivez i et appuye ENTER)"
								+ "\nou quitter le bibliothèque et sauvegarder ton information? (écrivez x et appuye ENTER)?");
			  		}
			  			
			  		else if(aChar == 'E') {
			  			System.out.println("\n\n                      MAIN MENU"
								+ "\nDo you want to borrow a book? (type b and press ENTER)"
								+ "\nor return a book? (type r and press ENTER)"
								+ "\nor donate a book? (type d and press ENTER)"
								+ "\nor look at your account information? (type i and press ENTER)"
								+ "\nor Exit the library and save your information? (type x then press ENTER)?");
			  		}
					
					//Reads input from user
					Scanner input2 = new Scanner(System.in);
			    	String choice2 = input2.nextLine().toUpperCase();
			    	char accountQ2 = choice2.charAt(0);
					
							
					switch (accountQ2) {
						
						//If the user wants to borrow a book
						case 'B': {
	
							int chooseBookInt = 0;
							String chooseBookString = "a";
							
							//If there are no books in the library
							if (numberOfBooks == 0) {
								if(aChar == 'F') {
						  			System.out.println("Pardon, mais on n'a pas de livres en ce moment."
						  				+ "\nSi tu veut emprunter un livre, tu devrait le donner en premier.");
						  		}
						  			
						  		else if(aChar == 'E') {
						  			System.out.println("Sorry, we do not have any books at the moment."
						  				+ "\nIf you would like to take one out, please donate it first.");
						  		}
								break;
							}
							
							boolean bookNotChosen = true;
									
							do {
								try {
									
									if(aChar == 'F') {
							  			System.out.println("On a actuellement " + numberOfBooks + " livres dans notre bibliothèque."
							  				+ "\nVoici leurs titres:");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("We currently have " + numberOfBooks + " books in our library."
							  				+ "\nHere are their titles:");
							  		}
									
									//Prints the book titles
									for (int bookCounter1 = 0; bookCounter1 < listBooks.size(); bookCounter1++) {
										System.out.println("\n" + (bookCounter1+1) + ". " + listBooks.get(bookCounter1).title);
									}
									
									if(aChar == 'F') {
							  			System.out.println("\nPour voire plus d'information à-propos d'un livre, écrit son numéro.");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("\nTo see more information about a book, type its number.");
							  		}
									
									
									//Reads the number entered
									chooseBookString = console.nextLine();
									chooseBookInt = Integer.parseInt(chooseBookString);
									
										/*Accounts for the order of numbers in arrays
										(Because the first number in an array is 0, we need to change the number entered).
										*/
										chooseBookInt --;
										
										//Prints information about the book
										if(aChar == 'F') {
											System.out.println("\n" + listBooks.get(chooseBookInt).title +
													" était écrit par " + listBooks.get(chooseBookInt).authorFirst +
													" " + listBooks.get(chooseBookInt).authorLast + ".");
								  		}
								  			
								  		else if(aChar == 'E') {
								  			System.out.println("\n" + listBooks.get(chooseBookInt).title +
													" was written by " + listBooks.get(chooseBookInt).authorFirst +
													" " + listBooks.get(chooseBookInt).authorLast + ".");
								  		}
										
										bookNotChosen = false;
								} catch (Exception e) {
									if(aChar == 'F') {
							  			System.out.println("Écrivez s'il vous plait un nombre équivalent à un livre.");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Please enter a number equivalent to a book.");
							  		}
								}
							} while(bookNotChosen);
							
							boolean notdone3 = false;
							
							do {
								try{
								
									notdone3 = false;
									
									if(aChar == 'F') {
							  			System.out.println("Voudrais-tu emprunter cette livre? (y pour OUI, n pour NON)");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Would you like to borrow this book? (y)es or (n)o");
							  		}
									
									//Reads the input
									Scanner inputBorrow = new Scanner(System.in);
							    	String choiceBorrow = inputBorrow.nextLine().toUpperCase();
							    	char borrowQ = choiceBorrow.charAt(0);
									
									switch (borrowQ) {
										
										
										case 'Y': {
											
											//If the book has not been taken out
											if (listBooks.get(chooseBookInt).borrowed == false && listClients.get(currentUser).booksOut < 5) {
												listBooks.get(chooseBookInt).borrowed = true;
												listBooks.get(chooseBookInt).borrowedBy = Integer.parseInt(Character.toString(listClients.get(currentUser).accountID.charAt(0)));
												
												borrowBug = true;
												
												if(aChar == 'F') {
													System.out.println("Tu as emprunté " + listBooks.get(chooseBookInt).title + "!");
										  		}
										  			
										  		else if(aChar == 'E') {
										  			System.out.println("You have sucessfully borrowed " + listBooks.get(chooseBookInt).title + "!");
										  		}
												
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
												if(aChar == 'F') {
													System.out.println("Pardon, cetter livre a déjà été emprunté par l'utilisateur " + listClients.get(listBooks.get(chooseBookInt).borrowedBy - 1).userName + ".");
										  		}
										  			
										  		else if(aChar == 'E') {
										  			System.out.println("Sorry, this book has already been taken out by user " + listClients.get(listBooks.get(chooseBookInt).borrowedBy - 1).userName + ".");
										  		}
												
											}
											
											else if (listClients.get(currentUser).booksOut >= 5) {
												if(aChar == 'F') {
													System.out.println("Pardon, mais le maximum de livres tu peut emprunter est 5.");
										  		}
										  			
										  		else if(aChar == 'E') {
										  			System.out.println("Sorry, but the maximum amount of books yoou can borrow is 5.");
										  		}
												
											}
											
												}
										
										//If the user does not want to borrow it, break
										case 'N': {break;}
										
										default : {
											if(aChar == 'F') {
												System.out.println("S'il vous plait écrit y or n.");
									  		}
									  			
									  		else if(aChar == 'E') {
									  			System.out.println("Please enter either y or n.");
									  		}
											
											notdone3 = true;
										}
									}
								} catch (Exception e) {
									if(aChar == 'F') {
										System.out.println("S'il vous plait écrit y or n.");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Please enter either y or n.");
							  		}
									
									notdone3 = true;
								}
							} while (notdone3);
							
							break;
							}
						
						
						//If the user wants to return a book
						case 'R': {
							
							int returnChoiceInt = 0;
							String returnChoiceString = "a";
							
							if (listClients.get(currentUser).booksOut <= 0) {
								if(aChar == 'F') {
						  			System.out.println("Pardon, mais vous n'avez pas de livres en ce moment."
						  				+ "\nSi vous voudrez retourner un livre, tu devrait emprunter un en premier.");
						  		}
						  			
						  		else if(aChar == 'E') {
						  			System.out.println("Sorry, you do not have any books out at the moment."
						  				+ "\nIf you would like to return a book, please borrow one first.");
						  		}
								break;
							}
							
							boolean returnChosen = false;
							
							do {
								try {
									
									if(aChar == 'F') {
										System.out.println("Voici les livres que tu as:");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("These are the books you have currently out:");
							  		}
									
									//Prints the book titles
									for (int bookCounter2 = 0; bookCounter2 < 5; bookCounter2++) {
										if (listClients.get(currentUser).booksArray[bookCounter2] != 0){
											System.out.println("\n" + (bookCounter2+1) + ". " + listBooks.get(listClients.get(currentUser).booksArray[bookCounter2]-1).title);
										}
									}
									if(aChar == 'F') {
										System.out.println("\nÉcrivez le chiffre du livre que tu voudrais retourner.");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("\nEnter the number of the book you would like to return.");
							  		}
									
									//Reads the number entered
									returnChoiceString = console.nextLine();
									returnChoiceInt = Integer.parseInt(returnChoiceString);
									
									//If they do not enter a number equivalent to a book
									if (returnChoiceInt > listClients.get(currentUser).booksOut || returnChoiceInt < 1) {
										if(aChar == 'F') {
											System.out.println("S'il vous plait écrit un nomber équivalent à un livre.");
								  		}
								  			
								  		else if(aChar == 'E') {
								  			System.out.println("Please enter a number equivalent to a book.");
								  		}
										returnChosen = true;
									}
									
									else {
										returnChosen = false;
									}
								} catch (Exception e) {
									if(aChar == 'F') {
										System.out.println("S'il vous plait écrit un nomber équivalent à un livre.\n");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Please enter a number equivalent to a book.\n");
							  		}
									returnChosen = true;
								}
							} while(returnChosen);
							
							boolean notdone4 = false;
							
							do {
								try {
									notdone4 = false;
									
									if(aChar == 'F') {
										System.out.println("Voudrais-tu retourner " + listBooks.get(listClients.get(currentUser).booksArray[returnChoiceInt-1]-1).title + "? (y pour OUI, n pour NON)");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Would you like to return " + listBooks.get(listClients.get(currentUser).booksArray[returnChoiceInt-1]-1).title + "? (y)es or (n)o");
							  		}
									
									//Reads the input
									Scanner inputBorrow = new Scanner(System.in);
							    	String choiceBorrow = inputBorrow.nextLine().toUpperCase();
							    	char returnQ = choiceBorrow.charAt(0);
									
									switch (returnQ) {
										
										case 'Y': {
											
											
												listBooks.get(listClients.get(currentUser).booksArray[returnChoiceInt-1]-1).borrowed = false;
												listBooks.get(listClients.get(currentUser).booksArray[returnChoiceInt-1]-1).borrowedBy = 0;
												
												if(aChar == 'F') {
													System.out.println("Tu as retourné " + listBooks.get(listClients.get(currentUser).booksArray[returnChoiceInt-1]-1).title + "!");
										  		}
										  			
										  		else if(aChar == 'E') {
										  			System.out.println("You have sucessfully returned " + listBooks.get(listClients.get(currentUser).booksArray[returnChoiceInt-1]-1).title + "!");
										  		}
												
												listClients.get(currentUser).booksOut --;
												
												for (int numbersInArray = 0; numbersInArray < 5; numbersInArray++) {
													if (listClients.get(currentUser).booksArray[numbersInArray] == listClients.get(currentUser).booksArray[returnChoiceInt-1]) {
														listClients.get(currentUser).booksArray[numbersInArray] = 0;
													}
												}
												
												int c, d, swap;
												for (c = 0; c < (4); c++) {
													for (d = 0; d < 5 - c - 1; d++) {
												        if (listClients.get(currentUser).booksArray[d] < listClients.get(currentUser).booksArray[d+1])
												        {
												          swap       = listClients.get(currentUser).booksArray[d];
												          listClients.get(currentUser).booksArray[d]   = listClients.get(currentUser).booksArray[d+1];
												          listClients.get(currentUser).booksArray[d+1] = swap;
												        }
													}
												}
										}
										
										//If the user does not want to return it, break
										case 'N': {break;}
										
										default : {
											if(aChar == 'F') {
												System.out.println("Écrivez s'il vous plait y ou n.");
									  		}
									  			
									  		else if(aChar == 'E') {
									  			System.out.println("Please enter either y or n.");
									  		}
											
											notdone4 = true;
										}
									}
								} catch (Exception e)	{
									if(aChar == 'F') {
										System.out.println("Écrivez s'il vous plait y ou n.");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Please enter either y or n.");
							  		}
									
									notdone4 = true;
								}
							} while (notdone4);
							
							break;
							
						}
						
						//If the user wants to donate a book
						case 'D': {
							
							//Creates a book object
							David_Book book1 = new David_Book("Temp_title2", "Temp_first2", "Temp_last2", "400", false, "4-631", "7", false, 0, 0);
							//Adds a book to the listBooks vector
							listBooks.add(book1);
							numberOfBooks ++;

							boolean titleIncorrect = true;
							boolean firstNameIncorrect = true;
							boolean lastNameIncorrect = true;
							do {
								if(aChar == 'F') {
									System.out.println("Qu'est-ce qu'est le titre du livre");
						  		}
						  			
						  		else if(aChar == 'E') {
						  			System.out.println("What is the title of the book?");
							  	}
								if (borrowBug) {
									book1.title = console.nextLine();
									borrowBug = false;
								}
								book1.title = console.nextLine();
								
								if (book1.title.length() <= 0) {
									if(aChar == 'F') {
										System.out.println("Écrivez un titre s'il vous plait.\n");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Write a title please.\n");
								  	}
									continue;
								}
								else {
									titleIncorrect = false;
								}
							} while (titleIncorrect);
							
							do {
								if(aChar == 'F') {
									System.out.println("Qu'est-ce qu'est le prénom de l'auteur?");
						  		}
						  			
						  		else if(aChar == 'E') {
						  			System.out.println("What is the first name of the author of the book?");
						  		}
								book1.authorFirst = console.nextLine();
	
								if (book1.authorFirst.length() <= 0) {
									if(aChar == 'F') {
										System.out.println("Écrivez le prénom de l'auteur s'il vous plait.\n");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Write the first name of the author of the book please.\n");
								  	}
									continue;
								}
								else {
									firstNameIncorrect = false;
								}
							} while (firstNameIncorrect);
							
							do {
								if(aChar == 'F') {
									System.out.println("Qu'est-ce qu'est le nom de famille de l'auteur?");
						  		}
						  			
						  		else if(aChar == 'E') {
						  			System.out.println("What is the last name of the author of the book?");
						  		}
								
								book1.authorLast = console.nextLine();
								
								if (book1.authorLast.length() <= 0) {
									if(aChar == 'F') {
										System.out.println("Écrivez le nom de famille de l'auteur s'il vous plait.\n");
							  		}
							  			
							  		else if(aChar == 'E') {
							  			System.out.println("Write the last name of the author of the book please.\n");
								  	}
									continue;
								}
								else {
									lastNameIncorrect = false;
								}
							} while (lastNameIncorrect);
							
							book1.bookNumber = numberOfBooks;
							
							if(aChar == 'F') {
								System.out.println("Merci pour votre don généreu!");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.println("Thank you for your generous donation!");
					  		}
							
							break;		
						}
						
						//If the user wants to look at information about their account
						case 'I': {
							if(aChar == 'F') {
								System.out.print("Nom: " + listClients.get(currentUser).firstName + " "
										+ listClients.get(currentUser).lastName
										+ "\nNom d'utilisateur: " + listClients.get(currentUser).userName
										+ "\nMot-de-passe: " + listClients.get(currentUser).password
										+ "\nChiffre ID: " + listClients.get(currentUser).accountID
										+ "\nNombre de livres sortie: " + listClients.get(currentUser).booksOut);
								if (listClients.get(currentUser).booksOut > 0) {
								System.out.print("\nLivres sorties:");
										for(int infoBooksTaken = 0; infoBooksTaken < 5; infoBooksTaken++) {
											if (listClients.get(currentUser).booksArray[infoBooksTaken] != 0){
											System.out.print(" " + listBooks.get(listClients.get(currentUser).booksArray[infoBooksTaken] - 1).title + "    ");
										}
									}
								}
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.print("Name: " + listClients.get(currentUser).firstName + " "
										+ listClients.get(currentUser).lastName
										+ "\nUsername: " + listClients.get(currentUser).userName
										+ "\nPassword: " + listClients.get(currentUser).password
										+ "\nAccount ID: " + listClients.get(currentUser).accountID
										+ "\nNumber of books taken out: " + listClients.get(currentUser).booksOut);
					  			if (listClients.get(currentUser).booksOut > 0) {
						  			System.out.print("\nBooks taken out:");
						  			for(int infoBooksTaken = 0; infoBooksTaken < 5; infoBooksTaken++) {
										if (listClients.get(currentUser).booksArray[infoBooksTaken] != 0){
										System.out.print(" " + listBooks.get(listClients.get(currentUser).booksArray[infoBooksTaken] - 1).title + "    ");
										}
									}
					  			}
					  		}
							
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
									"\n" + listBooks.get(printBook).bookNumber + 
									"\n" + listBooks.get(printBook).borrowedBy +"\n");
								}
								writer.close();
							}
							//If it doesn't work
							catch(IOException e) {
								if(aChar == 'F') {
									System.out.println("Un erreur s'est produit en essayant d'écrire l'information des livres au document.");
						  		}
						  			
						  		else if(aChar == 'E') {
						  			System.err.println("An error occured while trying to write book information to the file.");
						  		}
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
							catch(IOException e) {
								if(aChar == 'F') {
									System.out.println("Un erreur s'est produit en essayant d'écrire l'information de client au document.");
						  		}
						  			
						  		else if(aChar == 'E') {
						  			System.err.println("An error occured while trying to write client information to the file.");
						  		}
								
								break;
							}
							
							notdone1 = false;
							//End message
							if(aChar == 'F') {
								System.out.println("\nBonne journée!"
										+ "\nTu est maintenant déconnecté.");
					  		}
					  			
					  		else if(aChar == 'E') {
					  			System.out.println("\nHave a nice day!"
										+ "\nYou have been successfully logged out.");
					  		}
	
							break;
						}
						
						//If the user does not enter either b, d or x.
						default: {
							if(aChar == 'F') {
								System.out.println("Écrit s'il-te-plait b, r, d, i ou x.");
					  		}
					  			
					  		else if(aChar == 'E') {
								System.out.println("Plese enter either b, r, d, i or x.");
					  		}
						}
					
					}
				} catch (Exception e) {
					if(aChar == 'F') {
						System.out.println("Écrit s'il-te-plait b, r, d, i ou x.");
			  		}
			  			
			  		else if(aChar == 'E') {
						System.out.println("Plese enter either b, r, d, i or x.");
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