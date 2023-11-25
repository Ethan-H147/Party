import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
// Import the Scanner class to read text files
import java.util.*;

public class Main{
	
	
	public static void main (String[] args){  
	Party p1 = new Party();
	ArrayList<Attendee> party = new ArrayList<Attendee>();
	int id;
	String fName;
	String lName;
	int comp;
	String Company;
	String[] companyNames = {"WalMart","Kroger","Amazon","Lowes","Best Western","KMart","Fusian","Heinz","Gucci","Prada","Nike","Dodge","Maserati","Razor","AMD","Razer"};
	String[] myArray;
  int totalTable = 10;
		
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
        Company = companyNames[comp-1];
        Attendee a = new Attendee(id, lName, fName, comp);
        party.add(a);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }Scanner scan = new Scanner(System.in);

    if(!p1.partyCheck(party)){
      System.out.println("Company member limit or party limit exceeded.");
    }
    String function = "x";
  
    System.out.print("What do you want to do?(Search/Add/Sort/Assign)");
    function= scan.nextLine();
    if (function.equalsIgnoreCase("search")) {
            System.out.print("Enter first name or last name: ");
            String searchName = scan.nextLine();
            if(p1.searchAttendee(party, searchName)==-1){
              System.out.print("Attendee doesn't exist\n");
            }
            System.out.print(p1.searchAttendee(party, searchName)+". "+party.get(p1.searchAttendee(party, searchName)-1).getfName()+" "+party.get(p1.searchAttendee(party, searchName)-1).getlName());
        }

      if (function.equalsIgnoreCase("add")) {
            System.out.print("Enter first name and last name: ");
            p1.addAttendee(party);
        }

      if (function.equalsIgnoreCase("assign")) {
        ArrayList<ArrayList<Attendee>> tables = p1.assignTables(party);

          for(int i = 0;i<totalTable;i++){
            System.out.println(tables.get(i));
          }
        }
    
      //System.out.print(party);
      
	
	}
}

