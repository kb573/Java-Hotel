/* package hotel;  */
import java.io.*;
import java.util.*;
import java.time.LocalDate;

/**
 * This object class implements the booking object used in 
 * the hotel management system implementation class. The 
 * booking object has several attributes: bookingID, guestID,
 * roomID, bookingDate, checkInDate, checkOutDate, totalAmount.
 *
 * @author 031317
 * @version 08/03/2019
 *
 */
 
public class Booking {
	
	public int bookingID;
	public int guestID;
	public int roomNumber;
	public LocalDate bookingDate;
	public LocalDate checkin;
	public LocalDate checkout;
	public double totalAmount;
	
	/**
    * The constructor method for creating a booking object.
    * 
    * @param bookingID, guestID, roomID, bookingDate, checkin, checkout, totalAmount.
    *
    */
	
	public Booking(int bookingID, int guestID, int roomNumber, LocalDate bookingDate, LocalDate checkin, LocalDate checkout, double totalAmount){
		this.bookingID = bookingID;
		this.guestID = guestID;
		this.roomNumber = roomNumber;
		this.bookingDate = bookingDate;
		this.checkin = checkin;
		this.checkout = checkout;
		this.totalAmount = totalAmount;
	}
	
	/**
    * The getter method to retrieve the booking ID attribute.
    * 
	* @return bookingID
	*
    */
	
	public int getBookingID(){
		return bookingID;
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
    * The getter method to retrieve the room ID attribute.
    * 
	* @return roomID
	*
    */
	
	public int getRoomNumber(){
		return roomNumber;
	}
	
	/**
    * The getter method to retrieve the booking date attribute.
    * 
	
	* @return bookingDate
	*
    */
	public LocalDate getBookingDate(){
		return bookingDate;
	}
	
	/**
    * The getter method to retrieve the check in date attribute.
    * 
	* @return checkin
	*
    */
	
	public LocalDate getCheckInDate(){
		return checkin;
	}
	
	/**
    * The getter method to retrieve the check out date attribute.
    * 
	* @return checkout
	*
    */
	
	public LocalDate getCheckOutDate(){
		return checkout;
	}
	
	/**
    * The getter method to retrieve the total amount attribute.
    * 
	* @return totalAmount
	*
    */
	
	public double getTotalAmount(){
		return totalAmount;
	}
	
	/**
    * A to string method to override the to string method
	* in the object superclass. This method returns all
	* booking attributes as strings.
    * 
	* @return formatted string.
	*
    */
	
	@Override
	public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s", bookingID, guestID, roomNumber, bookingDate, checkin, checkout, totalAmount);
	}
}