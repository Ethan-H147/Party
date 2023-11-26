import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
// Import the Scanner class to read text files
import java.util.*;


public class Party{
	int tables = 10;
	int maxPeople = 100;
	int id;
	String fName;
	String lName;
	int comp;
	String Company;
	String[] companyNames = {"WalMart","Kroger","Amazon","Lowes","Best Western","KMart","Fusian","Heinz","Gucci","Prada","Nike","Dodge","Maserati","Razor","AMD","Razer"};
	String[] myArray;
	int tableNumber = 10;
  	int perTable = 10;
	

	public void addAttendee(ArrayList<Attendee> party){
		Scanner scan = new Scanner(System.in);
		String tempname = scan.nextLine();
        String[] newName = tempname.split(" ");
		System.out.print("Enter company: ");
		int comp = scan.nextInt();
		Attendee newAttendee = new Attendee(party.size()+1,newName[1],newName[0],comp);
		party.add(newAttendee);
	} 

	public boolean partyCheck(ArrayList<Attendee> party){
		if(party.size()>100){
			return false;
		}
		int[] companyCount = new int[15];	
		for(int i=0;i<party.size();i++){
			companyCount[party.get(i).getComp()-1]++;
		}
		for(int i=0;i<companyCount.length-1;i++){
			if(companyCount[i]>tableNumber){
				return false;
			}
		}
		return true;
	}


	public int searchAttendee(ArrayList<Attendee> party, String name){
		for(int i=0; i<party.size();i++){
			if (party.get(i).getfName().equalsIgnoreCase(name)||party.get(i).getlName().equalsIgnoreCase(name)){
			return i+1;
			}
		}
	return -1;
	}


	public ArrayList<ArrayList<Attendee>> assignTables(ArrayList<Attendee> party) {
        ArrayList<ArrayList<Attendee>> tables = new ArrayList<>();
		for(int i = 0; i < tableNumber; i++){
            tables.add(new ArrayList<>());
        }
		int table = 0;
		for(int i = 0; i < party.size(); i++){
			Attendee attendee = party.get(i);
			int company = attendee.getComp();
				while(tables.get(table).size()>=perTable||companyExist(tables.get(table), company)){
					table++; 
					table = table % tableNumber;
				}
				tables.get(table).add(attendee); 
				table++; 
				table = table % tableNumber;
			}
        return tables;
	}

	public boolean companyExist(ArrayList<Attendee> table, int company) {
        for(int i = 0; i < table.size(); i++) {
            if(table.get(i).getComp() == company) {
                return true;
            }
        }
        return false;
    }

	public void printCompany(ArrayList<Attendee> party, int company) {
		System.out.println("Company: "+companyNames[company-1]);
        for(int i = 0; i < party.size(); i++) {
            if(party.get(i).getComp() == company) {
                System.out.print(party.get(i).getfName()+" "+party.get(i).getlName()+" / ");
            }
        }
		System.out.print("\n");
    }
}
