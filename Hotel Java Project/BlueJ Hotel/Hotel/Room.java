/* package hotel;  */
import java.io.*;
import java.util.*;

/**
 * This object class implements the room object used in 
 * the hotel management system implementation class. The 
 * room object has several attributes: roomID, roomType,
 * price, capacity, facilities.
 *
 * @author 031317
 * @version 08/03/2019
 *
 */
 
public class Room {
	
	public int roomNumber;
	public String roomType;
	public double price;
	public int capacity;
	public String facilities;
	
	/**
    * The constructor method for creating a room object.
    * 
    * @param roomNumber, roomType, price, capacity, facilities.
    *
    */
	
	public Room(int roomNumber, String roomType, double price, int capacity, String facilities){
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = price;
		this.capacity = capacity;
		this.facilities = facilities;
	}
	
	/**
    * The getter method to retrieve the room number attribute.
    * 
	* @return roomNumber
	*
    */
	
	public int getRoomNumber(){
		return roomNumber;
	}
	
	/**
    * The getter method to retrieve the room type attribute.
    * 
	* @return roomType
	*
    */
	
	public String getRoomType(){
		return roomType;
	}
	
	/**
    * The getter method to retrieve the price attribute.
    * 
	* @return price
	*
    */
	
	public double getPrice(){
		return price;
	}
	
	/**
    * The getter method to retrieve the capacity attribute.
    * 
	* @return capacity
	*
    */
	
	public int getCapacity(){
		return capacity;
	}
	
	/**
    * The getter method to retrieve the facilities attribute.
    * 
	* @return facilities
	*
    */
	
	public String getFacilities(){
		return facilities;
	}
	
	/**
    * A to string method to override the to string method
	* in the object superclass. This method returns all
	* room attributes as strings.
    * 
	* @return formatted string.
	*
    */
	
	@Override
	public String toString() {
        return String.format("%s, %s, %s, %s, %s", roomNumber, roomType, price, capacity, facilities);
	}	
}
