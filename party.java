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

	public static void addAttendee(){
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		String lName = scan.nextLine();
		String fName = scan.nextLine();
		int comp = scan.nextInt();
		Attendee newAttendee = new Attendee(party.size()+1,lName,fName,comp);
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
