package Assignment_3;
//Imports
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.channels.FileChannel;
/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream; */
// I COMMENTED THIS OUT import java.nio.file.Files;

//Methods and class
public class Cheik_Main 
{
	
	//Method later used to read files
	public static void ReadFileBook()
	{
		String FILE_NAME_1 = "/Users/khazzamAir/Dropbox/David - Coding (1)/Emma_Eclipse_Nov18/Temp/LibraryBookInfoCheik.txt";
		int counter = 0;
		
		BufferedReader file = null;

		try {
			file = new BufferedReader(new FileReader(FILE_NAME_1));
			String line;
	
			while ((line = file.readLine()) != null)
			{
				counter++;
				System.out.println(counter + ":" + line);
			}
		}
		
		catch (FileNotFoundException e) {
			System.err.println("cannot open file");
		}
		
		catch (IOException e) {
			System.exit(0);
		}
	
		finally {
	        try {
	        	if (file != null) file.close();
	        }
	        
	        catch (IOException e) {
	        	System.err.println(e);
	        }
      }
	}
	public static void ReadFileClient() {
		String FILE_NAME_1 = "/Users/khazzamAir/Dropbox/David - Coding (1)/Emma_Eclipse_Nov18/Temp/LibraryClientInfoCheik.txt";
		int counter = 0;
		
		BufferedReader file = null;

		try {
			file = new BufferedReader(new FileReader(FILE_NAME_1));
			String line;
	
			while ((line = file.readLine()) != null) {
				counter++;
				System.out.println(counter + ":" + line);
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("cannot open file");
		}
		catch (IOException e) {
			System.exit(0);
		}
		finally {
	        try {
	        	if (file != null) file.close();
	        }
	        catch (IOException e) {
	        	System.err.println(e);
	        }
      }
	}
	
	//Method later used to write to file
	public static void WriteFileBook() {
		boolean append = true;
		try {
			PrintStream stdout = System.out;
			System.setOut(new PrintStream(new FileOutputStream("/Users/khazzamAir/Dropbox/David - Coding (1)/Emma_Eclipse_Nov18/Temp/LibraryBookInfoCheik.txt", append)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void WriteFileClient() {
		try {
			System.setOut(new PrintStream(new FileOutputStream("/Users/khazzamAir/Dropbox/David - Coding (1)/Emma_Eclipse_Nov18/Temp/LibraryClientInfoCheik.txt")));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//Method later used to stop writing to file
	public static void StopWriteFile() {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	}
	
		//Main method
		public static void main(String[] args) {
			Scanner user_input = new Scanner(System.in);//Scanner used to allow menu selection with letters in console
			Scanner console = new Scanner(System.in);//Scanner used to write in console
			boolean done = true;//Boolean used for While loop
			
			//Vectors for books and clients
			Vector<Cheik_Book> CheiksBookList = new Vector<Cheik_Book>();
			Vector<Cheik_Client> CheiksClientList = new Vector<Cheik_Client>();
			
			
			//Clients
			Cheik_Client Cheik = new Cheik_Client("Cheik-Siramakan", "Keita", "male", "18", "453", "13/05/1996", "1956", "Test");
			Cheik_Client Eric = new Cheik_Client("Eric", "Chislett", "male", "18", "454", "13/05/1996", "1996", "Test");
			Cheik_Client David = new Cheik_Client("David", "Khazzam", "male", "13", "455", "13/05/1996", "2001", "Test");
			Cheik_Client Emma = new Cheik_Client("Emma", "Khazzam", "female", "16", "456", "13/05/1996", "1998", "Test");
			Cheik_Client Daniella = new Cheik_Client("Daniella", "Jacques", "female", "17", "457", "13/05/1996", "1997", "Test");
			Cheik_Client Edna = new Cheik_Client("Edna", "Braun", "female", "0", "458", "13/05/1996", "0", "Test");
			
			CheiksClientList.add(Cheik);
			CheiksClientList.add(Eric);
			CheiksClientList.add(David);
			CheiksClientList.add(Emma);
			CheiksClientList.add(Daniella);
			CheiksClientList.add(Edna);
			
			//"Choose your language" lines
			System.out.println("To choose your language, press F or E. Pour choisir votre language appuyez F ou E):");
			System.out.println("F.Français");
			System.out.println("E.English");
			
			String aString = user_input.next().toUpperCase();;//Used to allow selecting menus with letters
			char aChar = aString.charAt(0); //Used to allow selecting menus with letters
			
			if(aChar == 'F') { //F for French language selection to later have the choices in French
				System.out.println("Bonjour et bienvenue à la bibliotheque de Cheik!");
			}
				
			else if (aChar == 'E'){ //E for English language selection to later have choices in English
				System.out.println("Hello, welcome to Cheik's library!");
			}
				
			while(done) {
			
				//Menu selection for language
				if(aChar == 'F') {
					System.out.println("Que voudriez vous faire aujourd'hui?");
					System.out.println("Pressez un boutton entre 1 et 3 pour sélectionner une option:");
			
					System.out.println("1.Donnez un livre");
					System.out.println("2.Devenez membre de la bibliotheque");
					System.out.println("3.Emprunter un livre");
					System.out.println("4.Voire le liste des livres");
				}
				else if (aChar == 'E'){ //E for English language selection to later have choices in English
					System.out.println("What do you want to do today?");
					System.out.println("Press a button between 4 and 7 to select an option:");
				
					System.out.println("1.Donate a book");
					System.out.println("2.Become member of the library");
					System.out.println("3.Borrow a book");
					System.out.println("4.See the list of books");
				}
				else if((aChar != 'F') && (aChar != 'E')) { //If an unallowed key is entered
					System.err.println("Error. Wrong input, please run the program again.");
				}
				int selection = 0;//Integer used for menu selection for "What you want to do at the library"
				int back;//Integer used for the end of choices menu and returns
				
				selection = console.nextInt();//Used for menu selection
				Scanner masterscanner = new Scanner(System.in);//Used for all the writting in console
				
				
				//Menus selections for "What you want to do at the library"
				if(aChar == 'F'){ 
					if(selection == 1 ) { //Give a book French version
						Cheik_Book Ray = new Cheik_Book("The Martian Chronicle", "Ray Bradburry", "99/55/66", "Science-Fiction/Fantasy", "300", "English", "Simon & Shuster Paperback", "Rad"); 
						CheiksBookList.add(Ray);
						System.out.println("1.Nom:");
						Ray.Title= masterscanner.nextLine();
						System.out.println("2.Auteur:");
						Ray.Author= masterscanner.nextLine();
						System.out.println("3.Genre:");
						Ray.Genre= masterscanner.nextLine();
					    System.out.println("4.Collection:");
					    Ray.Collection= masterscanner.nextLine();
						System.out.println("5.Éditeur:");
						Ray.Editeur= masterscanner.nextLine();
						System.out.println("Voici " + Ray.Title + " " + "Écrit par" + " " + Ray.Author + " " + "dans la collection" + " " + Ray.Collection + " " + "et est édité par" + " " + Ray.Editeur + ".");
						
						WriteFileBook();//Starts writing to file
						for (int i = 0; i <CheiksBookList.size();i++) {
							System.out.println("Title: " + CheiksBookList.elementAt(i).Title);
							System.out.println("Author: " + CheiksBookList.elementAt(i).Author);
							System.out.println("Genre: " + CheiksBookList.elementAt(i).Genre);
							System.out.println("Collection: " + CheiksBookList.elementAt(i).Collection);
							System.out.println("Editor: " + CheiksBookList.elementAt(i).Editeur);
							System.out.println("================================================");
						}
						StopWriteFile();//Stops writing to file
					}
					else if(selection == 2) { //Become member French version
						System.out.println("Deviens membre de la librairie:");
						System.out.println("1.Prénom:");
						Cheik.Name= masterscanner.nextLine();
						System.out.println("2.Nom de famille:");
						Cheik.Famillyname= masterscanner.nextLine();
						System.out.println("3.Sex:");
						Cheik.Sex= masterscanner.nextLine();
						System.out.println("4.Age:");
						Cheik.Age= masterscanner.nextLine();
						System.out.println("5.Date de naissance:");
						Cheik.Bday= masterscanner.nextLine();
						System.out.println("6.Username:");
						Cheik.Username= masterscanner.nextLine();
						System.out.println("7.Password:");
						Cheik.Pin= masterscanner.nextLine();
						CheiksClientList.add(Cheik);
						System.out.println("Est-ce que ces information sont bonne?" + " " + Cheik.Name + " " + Cheik.Famillyname + " " + "de sex" + " " + Cheik.Sex + "," + " " + "age de" + " " + Cheik.Age + " " + "ans" + " " + "nee le" + " " + Cheik.Bday + ".");
						System.out.println("Username: " + Cheik.Username);
						System.out.println("Password: " + Cheik.Pin);
						
						WriteFileClient();//Starts writing to file
						for (int i = 0; i <CheiksClientList.size();i++) {
							System.out.println("Name: " + CheiksClientList.elementAt(i).Name);
							System.out.println("Familly Name: " + CheiksClientList.elementAt(i).Famillyname);
							System.out.println("Gender: " + CheiksClientList.elementAt(i).Sex);
							System.out.println("Age: " + CheiksClientList.elementAt(i).Age);
							System.out.println("Birthday: " + CheiksClientList.elementAt(i).Bday);
							System.out.println("Username: " + CheiksClientList.elementAt(i).Username);
							System.out.println("Pin: " + CheiksClientList.elementAt(i).Pin);
							System.out.println("================================================");
						}
						
						StopWriteFile();//Stops writing to file
					}
					else if(selection == 3) { //Borrow a book French
						System.out.println("Emprunter un livre:");
						ReadFileBook();
						System.out.println("");
					}
				
				}//aChar = F
				
				else if (aChar == 'E') {
					if(selection == 1) { //Give a book English version
						Cheik_Book Ray2 = new Cheik_Book("Fahrenheit 451", "Ray Bradburry", "66/89/45", "Scien-Fiction/Fantasy", "190", "English", "Simon & Shuster Paperback", "Rad" );
						CheiksBookList.add(Ray2);
						System.out.println("Give a book: ");
						System.out.println("1.Name: ");
						Ray2.Title= masterscanner.nextLine();
						System.out.println("2.Author: ");
						Ray2.Author= masterscanner.nextLine();
						System.out.println("3.Genre: ");
						Ray2.Genre= masterscanner.nextLine();
						System.out.println("4.Collection: ");
						Ray2.Collection= masterscanner.nextLine();
						System.out.println("5.Editor: ");
						Ray2.Editeur= masterscanner.nextLine();
						System.out.println("This is" + " " + Ray2.Title + " " + "written by" + " " + Ray2.Author + ".");
						
						WriteFileBook();//Starts writing to file
						for (int i = 0; i <CheiksBookList.size();i++) {
							System.out.println("Title: " + CheiksBookList.elementAt(i).Title);
							System.out.println("Author: " + CheiksBookList.elementAt(i).Author);
							System.out.println("Genre: " + CheiksBookList.elementAt(i).Genre);
							System.out.println("Collection: " + CheiksBookList.elementAt(i).Collection);
							System.out.println("Editor: " + CheiksBookList.elementAt(i).Editeur);
							System.out.println("================================================");
						}
						StopWriteFile();//Stops writing to file
					}
					else if(selection == 2) { //Become member English version
						System.out.println("Become member of the library:");
						System.out.println("1.Name:");
						Cheik.Name= masterscanner.nextLine();
						System.out.println("2.Familly Name:");
						Cheik.Famillyname= masterscanner.nextLine();
						System.out.println("3.Gender:");
						Cheik.Sex= masterscanner.nextLine();
						System.out.println("4.Age:");
						Cheik.Age= masterscanner.nextLine();
						System.out.println("5.Birth Date:");
						Cheik.Bday= masterscanner.nextLine();
						System.out.println("6.Username:");
						Cheik.Username= masterscanner.nextLine();
						System.out.println("7.Pin:");
						Cheik.Pin= masterscanner.nextLine();
						CheiksClientList.add(Cheik);
						System.out.println("Are these informations right?" + " " + Cheik.Name + " " + Cheik.Famillyname + " " + "of" + " " + Cheik.Sex + "gender" + "," + " " + "aged of" + " " + Cheik.Age + " " + "years" + " " + "born" + " " + Cheik.Bday + ".");
						System.out.println("Username: " + Cheik.Username);
						System.out.println("Pin: " + Cheik.Pin);
						
						WriteFileClient();//Starts writing to file
						for (int i = 0; i <CheiksClientList.size();i++) {
							System.out.println("Name: " + CheiksClientList.elementAt(i).Name);
							System.out.println("Familly Name: " + CheiksClientList.elementAt(i).Famillyname);
							System.out.println("Gender: " + CheiksClientList.elementAt(i).Sex);
							System.out.println("Age: " + CheiksClientList.elementAt(i).Age);
							System.out.println("Birthday: " + CheiksClientList.elementAt(i).Bday);
							System.out.println("Username: " + CheiksClientList.elementAt(i).Username);
							System.out.println("Pin: " + CheiksClientList.elementAt(i).Pin);
							System.out.println("================================================");
						}
						StopWriteFile();//Stops writing to file
					}
					else if(selection == 3) { //Borrow a book English
						System.out.println("Borrow a book:");
						ReadFileBook();
					}
					
				}//aChar = E
				
				if(selection == 4) { //Selection made to read the list and display it
					ReadFileBook();
				}
				else if(selection == 13051996) { //Selection made for only me to see clients and their personal informations
					ReadFileClient();
				}
				else if((selection != 1) && (selection != 2) && (selection != 3) && (selection != 4)) { //If an unhallowed key is entered
					System.err.println("Error. Wrong input, please run the program again.");
				}
				
				//End of choices
				System.out.println("Press 1 to restart or 2 to have your informations saved.");
				back = console.nextInt();
				
				if (back == 1) {
					System.out.println("================================================");
				}
				
				else if(back == 2) {
					if (aChar == 'E') {
						System.out.println("Your information has been saved you can now leave or run the program again to restart.");
					}
					else if (aChar == 'F') {
						System.out.println("Vos informations sont maintenant sauvegardés vous pouvez quitter ou redemarrer le programme afin de pouvoir naviguer dans les menus.");
					}
					done=false;
				}
				
				else if((back != 1) && (back != 2)) {
					System.err.println("Error. Wrong input, please run the program again.");
				}
			}//While loop's curly bracket
		}//Main's curly bracket
}//Class's curly bracket