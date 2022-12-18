/* package hotel;  */
import java.io.*;
import java.util.*;
import java.time.LocalDate;

/**
 * This object class implements the payment object used in 
 * the hotel management system implementation class. The 
 * payment object has several attributes: date, guestID,
 * amount, payReason.
 *
 * @author 031317
 * @version 08/03/2019
 *
 */
 
public class Payment {
	
	public LocalDate date;
	public int guestID;
	public double amount;
	public String payReason;
	
	/**
    * The constructor method for creating a payment object.
    * 
    * @param date, guestID, amount, payReason.
    *
    */
	
	public Payment(LocalDate date, int guestID, double amount, String payReason){
		this.date = date;
		this.guestID = guestID;
		this.amount = amount;
		this.payReason = payReason;
	}
	
	/**
    * The getter method to retrieve the date attribute.
    * 
	* @return date
	*
    */
	
	public LocalDate getDate(){
		return date;
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
    * The getter method to retrieve the amount attribute.
    * 
	* @return amount
	*
    */
	
	public double getAmount(){
		return amount;
	}
	
	/**
    * The getter method to retrieve the pay reason attribute.
    * 
	* @return payReason
	*
    */
	
	public String getPayReason(){
		return payReason;
	}
	
	/**
    * A to string method to override the to string method
	* in the object superclass. This method returns all
	* payment attributes as strings.
    * 
	* @return formatted string.
	*
    */
	
	@Override
	public String toString() {
        return String.format("%s, %s, %s, %s", date, guestID, amount, payReason);
	}
}