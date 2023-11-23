import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
// Import the Scanner class to read text files
import java.util.*;


public class Party{
	int tables = 10;
	int maxPeople = 100;
	//ArrayList<Attendee> party = new ArrayList<Attendee>();
	int id;
	String fName;
	String lName;
	int comp;
	String Company;
	String[] companyNames = {"WalMart","Kroger","Amazon","Lowes","Best Western","KMart","Fusian","Heinz","Gucci","Prada","Nike","Dodge","Maserati","Razor","AMD","Razer"};
	String[] myArray;
	
	
	public void createList(){

}

	public static void addAttendee(ArrayList<Attendee> party){
		Scanner scan = new Scanner(System.in);
		String tempname = scan.nextLine();
        String[] newName = tempname.split(" ");
		int comp = scan.nextInt();
		Attendee newAttendee = new Attendee(party.size()+1,newName[0],newName[1],comp);
		party.add(newAttendee);
	} 




	public int searchAttendee(ArrayList<Attendee> party, String name){
		for(int i=0; i<party.size();i++){
			if (party.get(i).getfName().equals(name)){
			
			return i+1;
			}
		}
	return -1;
	}
}
