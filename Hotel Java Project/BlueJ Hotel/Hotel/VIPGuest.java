/* package hotel;  */
import java.io.*;
import java.util.*;
import java.time.LocalDate;

/**
 * This object class implements the VIP guest object which
 * extends the guest superclass. The VIP guest object has 
 * several attributes: all attributes inherited from the 
 * guest class, as well as, VIPstartDate, VIPexpiryDate.
 *
 * @author 031317
 * @version 08/03/2019
 *
 */
 
public class VIPGuest extends Guest {

	public LocalDate VIPstartDate;
	public LocalDate VIPexpiryDate;
	
	/**
    * The constructor method for creating a VIP guest object.
    * 
    * @param guestID, fName, lName, dateJoin, VIPstartDate, VIPexpiryDate.
    *
    */
	public VIPGuest(int guestID, String fName, String lName, LocalDate dateJoin, LocalDate VIPstartDate, LocalDate VIPexpiryDate){
		super(guestID, fName, lName, dateJoin);
		this.VIPstartDate = VIPstartDate;
		this.VIPexpiryDate = VIPexpiryDate;
	}
	
	/**
    * The getter method to retrieve the vip start date attribute.
    * 
	* @return VIPstartDate
	*
    */
	
	public LocalDate getVipStart(){
		return VIPstartDate;
	}
	
	/**
    * The getter method to retrieve the vip end date attribute.
    * 
	* @return VIPexpiryDate
	*
    */
	
	public LocalDate getVipEnd(){
		return VIPexpiryDate;
	}
	
	/**
    * A to string method to override the to string method
	* in the object superclass. This method returns all
	* VIP guest attributes as strings.
    * 
	* @return formatted string.
	*
    */
	
	@Override
	public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s", guestID, fName, lName, dateJoin, VIPstartDate, VIPexpiryDate);
	}
}