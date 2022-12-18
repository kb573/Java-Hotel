/* package hotel; */ 
import java.io.*;
import java.util.*;
import java.time.LocalDate;

/**
 * This object class implements the guest object used in 
 * the hotel management system implementation class. The 
 * guest object has several attributes: guestID, firstName,
 * lastName, dateJoin.
 *
 * @author 031317
 * @version 08/03/2019
 *
 */
 
public class Guest {
	
	public int guestID;
	public String fName;
	public String lName;
	public LocalDate dateJoin;
	
	/**
    * The constructor method for creating a guest object.
    * 
    * @param guestID, fName, lName, dateJoin.
    *
    */
	
	public Guest(int guestID, String fName, String lName, LocalDate dateJoin){
		this.guestID = guestID;
		this.fName = fName;
		this.lName = lName;
		this.dateJoin = dateJoin;
	}
	
	/**
    * The getter method to retrieve the guest ID attribute.
    * 
	* @return guestID
	*
    */
	
	public int getGuestID(){
		return guestID;
	}
	
	/**
    * The getter method to retrieve the first name attribute.
    * 
	* @return fName
	*
    */
	
	public String getFirstName(){
		return fName;
	}
	
	/**
    * The getter method to retrieve the last name attribute.
    * 
	* @return lName
	*
    */
	
	public String getLastName(){
		return lName;
	}
	
	/**
    * The getter method to retrieve the date joined attribute.
    * 
	* @return dateJoin
	*
    */
	
	public LocalDate getDateJoined(){
		return dateJoin;
	}
	
	/**
    * A to string method to override the to string method
	* in the object superclass. This method returns all
	* guest attributes as strings.
    * 
	* @return formatted string.
	*
    */
	
	@Override
	public String toString() {
        return String.format("%s, %s, %s, %s", guestID, fName, lName, dateJoin);
	}
}