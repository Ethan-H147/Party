/**
 * Ethan Hu
 * 2023/11/26
 * Party Planner
 * Attendee Class-everything about an individual, the attributes, the way of printing that attendee
 */

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;


/*
 * This is the attendee class
 * it includes the attributes of an attendee
 * it also has getters and setter, along with a to string method to print attendees 
 */
public class Attendee {
	private int ID;
	private String fName;
	private String lName;
	private int comp;
	private String Company;
	
	String[] companyNames = {"WalMart","Kroger","Amazon","Lowes","Best Western","KMart","Fusian","Heinz","Gucci","Prada","Nike","Dodge","Maserati","Razor","AMD","Razer"};


	/*
	 * Setter, create an attendee with 4 attributes
	 * company is the string for the actual name of the company, decided by the int comp
	 */
	public Attendee(int initID, String initlName, String initfName, int initComp){
		ID = initID;
		fName = initfName;
		lName = initlName;
		comp = initComp;
		Company = companyNames[comp-1];
	}
	
	
	//toString method for printing
	public String toString(){
			return (ID+". "+fName+" "+lName+" "+comp+"\n");
		}
		
	
	//getter for last name
	public String getlName(){
		return lName;
	}
	//getter for first name
	public String getfName(){
		return fName;
	}
	//getter for company
	public int getComp(){
		return comp;
	}
}
