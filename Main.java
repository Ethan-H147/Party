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
  ArrayList<ArrayList<Attendee>> tables = new ArrayList<>();
		
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
      System.out.println("Company member limit or party limit exceeded. Unable to assign tables.");
    }
    String function = "x";
    do{
    System.out.print("What do you want to do?(Search/Add/Assign/Table/Company Search/Quit)");
    function= scan.nextLine();


    
    if(function.equalsIgnoreCase("search")) {
            System.out.print("Enter first name or last name: ");
            String searchName = scan.nextLine();
            if(p1.searchAttendee(party, searchName)==-1){
              System.out.print("Attendee doesn't exist.\n");
            }
            else{
            System.out.print(p1.searchAttendee(party, searchName)+". "+party.get(p1.searchAttendee(party, searchName)-1).getfName()+" "+party.get(p1.searchAttendee(party, searchName)-1).getlName());
            System.out.println(" / "+companyNames[party.get(p1.searchAttendee(party, searchName)-1).getComp()-1]);
            for(int i=0; i<tables.size(); i++) {
              ArrayList<Attendee> currentTable=tables.get(i);
              for (int j=0; j<currentTable.size(); j++) {
                  Attendee attendee = currentTable.get(j);
                  if (attendee.getfName().equalsIgnoreCase(party.get(p1.searchAttendee(party, searchName)-1).getfName()) && attendee.getlName().equalsIgnoreCase(party.get(p1.searchAttendee(party, searchName)-1).getlName())) {
                      System.out.println("Table "+(i+1)+" Seat "+(j+1));
                  }
                }
                }
          }
          }

      if(function.equalsIgnoreCase("add")) {
            System.out.print("Enter first name and last name: ");
            p1.addAttendee(party);
        }

      if(function.equalsIgnoreCase("assign")) {
        tables = p1.assignTables(party);
          /*for(int i = 0;i<totalTable;i++){
            System.out.println(tables.get(i));
          }*/
          System.out.println("Tables assigned.");
        }

        if(function.equalsIgnoreCase("table")) {
          System.out.print("Enter the table number: ");
          int table = scan.nextInt();
          if(tables.size()>=table){
          System.out.println(tables.get(table-1));
          }
          else{System.out.println("Table not assigned yet.");}
        }

        if(function.equalsIgnoreCase("company search")) {
          System.out.print("Enter the company number: ");
          int company = scan.nextInt();
          p1.printCompany(party, company);
        }
        
      }
      while(!function.equalsIgnoreCase("Quit"));
      //System.out.print(party);
	}
}

