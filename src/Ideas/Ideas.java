/*package Ideas;
import Client;

import java.util.Random;


public class Ideas {
case 'A': {
	
	//Creates a client object	
	Client client1 = new Client();
	//Adds a client to the listClients vector
	listClients.add(client1);
	
	//Adds first name
	System.out.println("What is your first name?");
	client1.firstName = console.nextLine();

	System.out.println("What is your last name?");
	client1.lastName = console.nextLine();
	
	System.out.println("Please create a username.");
	client1.userName = console.nextLine();
	
	System.out.println("Please create a password.");
	client1.password = console.nextLine();
	
	  
	//Gives the client an ID
	client1.accountID = listClients.size();
	
	int min = 1000;
    int max = 10000;
	  
	
	
	System.out.print("Welcome " + client1.userName + "!"
			+ "\nYour ID number is " + client1.accountID);
	
	float clientsIDCombined = client1.accountID;
	
	for (int i = 0; i < 3; i++) {
	Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    
    clientsIDCombined = Float.valueOf(String.valueOf(clientsIDCombined) + String.valueOf(randomNum));
	}
    System.out.println(clientsIDCombined);
	
	System.out.println("\nYou are now logged in.");
	
	break;
	}
}
*/