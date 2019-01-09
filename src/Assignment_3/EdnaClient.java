package Assignment_3;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class EdnaClient {

	EdnaClient() {};
	
	EdnaClient(BufferedReader reader)
	{
		readSelf(reader);
	}
	
	void readSelf(BufferedReader reader)
	{
		String line = new String(); 
		try {
			line = reader.readLine();
			clientId = Integer.parseInt(line);
			firstName = reader.readLine();
			lastName = reader.readLine();
			address = reader.readLine();
			line = reader.readLine();
			fines = Integer.parseInt(line);
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
		booksCheckedOut = new Vector<EdnaBook>();
		booksOnHold = new Vector<EdnaBook>();
	}
	
	void writeSelf(BufferedWriter writer)
	{
		try {
			writer.write(Integer.toString(clientId));
			writer.newLine();
			writer.write(firstName);
			writer.newLine();
			writer.write(lastName);
			writer.newLine();
			writer.write(address);
			writer.newLine();
			writer.write(Integer.toString(fines));
			writer.newLine();
		} catch (IOException e) {
		    System.err.println("Caught IOException: " + e.getMessage());
		}
	}
	
	void dump()
	{
		System.out.println("clientid: "+clientId);
		System.out.println("firstname: "+firstName);
		System.out.println("lastname: "+lastName);
		System.out.println("address: "+address);
		System.out.println("fines: "+fines);
	}
	
	Integer clientId;
	String firstName;
	String lastName;
	String address;
	Integer fines;
	Vector<EdnaBook> booksCheckedOut;
	Vector<EdnaBook> booksOnHold;
}
