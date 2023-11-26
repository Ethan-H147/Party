import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
// Import the Scanner class to read text files
import java.util.*;

/**
 * Ethan Hu
 * 2023/11/26
 * Party Planner
 * Party Class-methods for organizing and looking up information
 */


 /*
	Party class contains every single method needed in the functions
	including searching, arranging seats, adding attendees and printing table and company
	it also includes some other methods like checking if a company already exists in a table, or checking if the party is valid
  */
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
	

	/*scan first and last name, and then company, create and add a new attendee to the party*/
	public void addAttendee(ArrayList<Attendee> party){
		Scanner scan = new Scanner(System.in);
		String tempname = scan.nextLine();
        String[] newName = tempname.split(" ");//split into first name and last name
		System.out.print("Enter company: ");
		int comp = scan.nextInt();
		Attendee newAttendee = new Attendee(party.size()+1,newName[1],newName[0],comp);//create new attendee using new info
		party.add(newAttendee);
	} 


	/*check if the party is valid in two ways
	 * if the party has more people than the max capacity (100 in this case)
	 * or at least one company has more people than the number of tables(10 in this case)
	 * if so then the requirement of no people from the same company sit together cannot be met*/
	public boolean partyCheck(ArrayList<Attendee> party){
		if(party.size()>tableNumber*perTable){//check if over 100 people
			return false;
		}
		int[] companyCount = new int[companyNames.length];//an array of counters for employee of companies
		for(int i=0;i<party.size();i++){//go over everyone in the party
			companyCount[party.get(i).getComp()-1]++;//add 1 to the company the person belongs to
		}
		for(int i=0;i<companyCount.length-1;i++){
			if(companyCount[i]>tableNumber){//if any company has employee more the number of tables, which is 10 in this case, then it's invalid
				return false;
			}
		}
		return true;
	}

	/* basic linear search
	 * although it will look for matching last name and first name
	 * return -1 if not found
	 */
	public int searchAttendee(ArrayList<Attendee> party, String name){
		for(int i=0; i<party.size();i++){
			if (party.get(i).getfName().equalsIgnoreCase(name)||party.get(i).getlName().equalsIgnoreCase(name)){//check both last and first name
			return i+1;
			}
		}
	return -1;
	}

	/* 
	 * this is the tricky part, it will need to make sure no two people from the same company sit together
	 * I used a logic that go through the party attendees one by one
	 * it has a table counter
	 * it will check if the current table is available, if not then move to the next table, the while loop will ensure it stops at an available table
	 * mod will make sure when the counter goes above the table number(10), it will go back to the first one, like moving in a circle
	 * if there are more than 10 people from the same company, it will get into an infinite loop because the while loop will never find a table for the last one
	 */
	public ArrayList<ArrayList<Attendee>> assignTables(ArrayList<Attendee> party) {
        ArrayList<ArrayList<Attendee>> tables = new ArrayList<>();//create the arraylist of arraylists, 10 tables with 10 people each
		for(int i = 0; i < tableNumber; i++){
            tables.add(new ArrayList<>());//add the table arraylists
        }
		int table = 0;//current table
		for(int i = 0; i < party.size(); i++){//go through everyone in the party to place them
			Attendee attendee = party.get(i);//temporary
			int company = attendee.getComp();
				while(tables.get(table).size()>=perTable||companyExist(tables.get(table), company)){//if the table is full or the company already exists within the table
					table++; //move to the next
					table = table % tableNumber;//make sure it doesn't get over 10
				}
				tables.get(table).add(attendee); //add to the table
				table++;
				table = table % tableNumber;
			}
        return tables;//return the whole table plan
	}


	/*
	 * This is used in the method assignTables,
	 * if the company already exists within the table,
	 * then the program will move to the next table to see if he can be placed there
	 */
	public boolean companyExist(ArrayList<Attendee> table, int company) {
        for(int i = 0; i < table.size(); i++) {//go through everyone in the table
            if(table.get(i).getComp() == company) {//if anyone is from there return true
                return true;
            }
        }
        return false;
    }

	/*
	 * Print everyone in the party from a specific company
	 * basic for loop, check everyone in the party
	 */
	public void printCompany(ArrayList<Attendee> party, int company) {
		System.out.println("Company: "+companyNames[company-1]);//I used int to represent companies, this is the actual name, correspond to a thing in the array
        for(int i = 0; i < party.size(); i++) {
            if(party.get(i).getComp() == company) {
                System.out.print(party.get(i).getfName()+" "+party.get(i).getlName()+" / ");//print name
            }
        }
		System.out.print("\n");
    }
}
