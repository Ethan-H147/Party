import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

public class Main{
	ArrayList<Attendee> Party = new ArrayList<Attendee>();
	
	
	public static void main (String[] args){  
		
		int id;
	String fName;
	String lName;
	int comp;
	String Company;
	String[] myArray;
		
		
		try {
      File myObj = new File("partyguests.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        //System.out.println(data);
        myArray = data.split(",");
        id = Integer.parseInt(myArray[0]);
        lName = myArray[1];
        fName = myArray[2];
        comp = Integer.parseInt(myArray[3]);
        Attendee a = new Attendee(id, lName, fName, comp);
        System.out.println();
        
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
	}
}

