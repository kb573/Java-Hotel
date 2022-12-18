/* package hotel;  */
import java.time.LocalDate;
import java.io.*;
import java.util.*;
import java.time.temporal.ChronoUnit;

/**
  * An implementation for the functionalities stated in the hotel
  * management system interface.
  *
  * @author 031317
  * @version 14/03/2019
  *
  */
  
public class HotelImpl implements Hotel{
	
	public String roomsTxtFileName;
	public String bookingsTxtFileName;
	public String guestsTxtFileName;
	public String paymentsTxtFileName;
	
	public ArrayList <Room> roomList = new ArrayList <Room> ();
	public ArrayList <Booking> bookingList = new ArrayList <Booking> ();
	public ArrayList <Payment> paymentList = new ArrayList <Payment> ();
	public ArrayList <Guest> guestList = new ArrayList <Guest> ();
	public ArrayList <VIPGuest> vipGuestList = new ArrayList <VIPGuest> ();
	
	private static int guestsAdded = 6;
	private static double vipMembershipPrice = 50.00;
	private static double vipDiscount = 0.10;
	private static int refundPeriod = 2;
	
	
	/**
    * The constructor method for creating a hotel object.
    * 
    * @param roomsTxtFileName, bookingsTxtFileName, guestsTxtFileName, paymentsTxtFileName
    *
    */
	
	public HotelImpl(String roomsTxtFileName, String bookingsTxtFileName, String guestsTxtFileName, String paymentsTxtFileName) {
		
		importRoomsData(roomsTxtFileName);
		importBookingsData(bookingsTxtFileName);
		importGuestsData(guestsTxtFileName);
		importPaymentsData(paymentsTxtFileName);
	}
	
	/**
	* Load all the room records from a text file
	*
	* @param  roomsTxtFileName  the text file for all room records
	* @return true if loading data successfully, otherwise false
	*/

	public boolean importRoomsData(String roomsTxtFileName){
		
		try{
			Scanner read = new Scanner(new File(roomsTxtFileName));
			do{
				String line = read.nextLine();
				String[] variables = line.split(",");
				int roomNumber = Integer.parseInt(variables[0]);
				String roomType = variables[1];
				double price = Double.parseDouble(variables[2]);
				int capacity = Integer.parseInt(variables[3]);
				String facilities = variables[4];
				roomList.add(new Room(roomNumber, roomType, price, capacity, facilities)); 
			}while(read.hasNext());
				read.close();
				return true;
		}catch(IOException ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
    /**
    * Load all the guest records from a text file
    *
    * @param  guestsTxtFileName  the text file for all guest records
    * @return true if loading data successfully, otherwise false
    */
   
	public boolean importGuestsData(String guestsTxtFileName){
		try{
			Scanner read = new Scanner(new File(guestsTxtFileName));
			do{
				String line = read.nextLine();
				String[] variables = line.split(",");
				int variablesSize = variables.length;
				if (variablesSize == 4){
					int guestID = Integer.parseInt(variables[0]);
					String fName = variables[1];
					String lName = (variables[2]);
					LocalDate dateJoin = LocalDate.parse(variables[3]);
					guestList.add(new Guest(guestID, fName, lName, dateJoin));
				}else{
					int guestID = Integer.parseInt(variables[0]);
					String fName = variables[1];
					String lName = (variables[2]);
					LocalDate dateJoin = LocalDate.parse(variables[3]);
					LocalDate VIPstartDate = LocalDate.parse(variables[4]);
					LocalDate VIPexpiryDate = LocalDate.parse(variables[5]);
					vipGuestList.add(new VIPGuest(guestID, fName, lName, dateJoin, VIPstartDate, VIPexpiryDate));
				}
			}while(read.hasNext());
				read.close();
				return true;
			}catch(IOException ex){
				System.out.println(ex.getMessage());
				return false;
			}
	}
	
    /**
    * Load all the booking records from a text file
    *
    * @param  bookingsTxtFileName  the text file for all booking records
    * @return true if loading data successfully, otherwise false
    */
   
	public boolean importBookingsData(String bookingsTxtFileName){
		try{
			Scanner read = new Scanner(new File(bookingsTxtFileName));
			do{
				String line = read.nextLine();
				String[] variables = line.split(",");
				int bookingID = Integer.parseInt(variables[0]);
				int guestID = Integer.parseInt(variables[1]);
				int roomID = Integer.parseInt(variables[2]);
				LocalDate bookingDate = LocalDate.parse(variables[3]);
				LocalDate checkin = LocalDate.parse(variables[4]);
				LocalDate checkout = LocalDate.parse(variables[5]);
				double totalAmount = Double.parseDouble(variables[6]);
				bookingList.add(new Booking(bookingID, guestID, roomID, bookingDate, checkin, checkout, totalAmount)); 
			}while(read.hasNext());
			read.close();
			return true;
		}catch(IOException ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
    /**
    * Load all the payment records from a text file
    *
    * @param  paymentsTxtFileName  the text file for all payment records
    * @return true if loading data successfully, otherwise false
    */
   
	public boolean importPaymentsData(String paymentsTxtFileName){
		try{
			Scanner read = new Scanner(new File(paymentsTxtFileName));
			do{
				String line = read.nextLine();
				String[] variables = line.split(",");
				LocalDate Date = LocalDate.parse(variables[0]);
				int guestID = Integer.parseInt(variables[1]);
				double amount = Double.parseDouble(variables[2]);
				String payReason = variables[3];
				paymentList.add(new Payment(Date, guestID, amount, payReason)); 
			}while(read.hasNext());
			read.close();
			return true;
		}catch(IOException ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
    /**
    * Display all room information in the current hotel
    */
   
	public void displayAllRooms(){
		for(Room item : roomList){
			System.out.println(item.toString());
		}	
	}
	
    /**
    * Display all guest information in the current hotel
    */
   
	public void displayAllGuests(){
		System.out.println(":STANDARD GUESTS:");
		for(Guest item : guestList){	
			System.out.println(item.toString());
		}
		System.out.println(":VIP GUESTS:");
		for(VIPGuest item : vipGuestList){
			System.out.println(item.toString());
		}
	}
   
    /**
    * Display all booking information in the current hotel
    */
   
	public void displayAllBookings(){
		for(Booking item : bookingList){
			System.out.println(item.toString());
		}
	}
	
    /**
    * Display all payment information in the current hotel
    */
   
	public void displayAllPayments(){
		for(Payment item : paymentList){
			System.out.println(item.toString());
		}
	}
	
    /**
    * Add one room to the hotel
    *
    * @param roomNumber   the room number
    * @param roomType     the room type
    * @param price        the room price (with no discount)
    * @param capacity     the maximal number of people to stay
    * @param facilities   the facilities of the room
    * @return             true if adding the room successfully, otherwise false
    */
  
	public boolean addRoom(int roomNumber, RoomType roomType, double price, int capacity, String facilities){
		for (Room item : roomList){
			if(item.getRoomNumber() == roomNumber){
				System.out.println("Error: Room already exists.");
				return false;
			}else{
				continue;
			}
		}	
		Room newRoom = new Room(roomNumber, roomTypeToString(roomType), price, capacity, facilities);
		roomList.add(newRoom);
		System.out.println("Room successfully added.");
		return true;
	}
	
    /**
    * Remove one room from the hotel
    *
    * @param roomNumber   the room number
    * @return             true if removing the room successfully, otherwise false
    */
  
	public boolean removeRoom(int roomNumber){
		for(Room item : roomList){
            if(item.getRoomNumber() == roomNumber){
                for(Booking item2 : bookingList){
                    if(item2.getRoomNumber() == roomNumber){
                        System.out.println("ERROR: Room has current or future booking.");
						return false;
                    }
                }
                roomList.remove(item);
				System.out.println("Room successfully removed.");
                return true;
            }
        }
		System.out.println("ERROR: Room not found.");
        return false;
	}
	
    /**
    * Add one standard guest to the hotel
    *
    * @param fName    the first name of the guest
    * @param lName    the last name of the guest
    * @param dateJoin the date of registration
    * @return         true if adding the guest successfully, otherwise false
    */
  
	public boolean addGuest(String fName, String lName, LocalDate dateJoin){
		guestsAdded += 1;
		Guest newGuest = new Guest(10000 + guestsAdded, fName, lName, dateJoin);
		guestList.add(newGuest);
		System.out.println("Guest successfully added.");
		return true;
	}
	
    /**
    * Add one VIP guest to the hotel
    *
    * @param fName        the first name of the guest
    * @param lName        the last name of the guest
    * @param dateJoin     the date of registration
    * @param VIPstartDate the start date of VIP membership
    * @param VIPexpiryDate the expiry date of VIP membership
    * @return             true if adding the guest successfully, otherwise false
    */
  
	public boolean addGuest(String fName, String lName, LocalDate dateJoin, LocalDate VIPstartDate, LocalDate VIPexpiryDate){
        if((VIPexpiryDate.getDayOfMonth()) != (VIPstartDate.getDayOfMonth()) || 
		   ((VIPexpiryDate.getMonth()) != (VIPstartDate.getMonth())) || 
		   ((VIPexpiryDate.getYear() - VIPstartDate.getYear()) != 1)) {
			System.out.println("ERROR: VIP membership must be 1 year in duration.");
			return false;
		} 
        VIPGuest newVIPGuest = new VIPGuest(10000 + guestsAdded, fName, lName, dateJoin, VIPstartDate, VIPexpiryDate);
        vipGuestList.add(newVIPGuest);

        Payment newPayment = new Payment(VIPstartDate, newVIPGuest.getGuestID(), vipMembershipPrice, "VIPmembership");
        paymentList.add(newPayment);
        
		System.out.println("VIP guest successfully added.");
		return true;
	}
	
    /**
    * Remove one guest from the hotel
    *
    * @param guestID the guest unique ID
    * @return        true if removing the guest successfully, otherwise false
    */
  
	public boolean removeGuest(int guestID){
		boolean isStandard = false;
		boolean isVip = false;
		boolean futureBooking = false;
		boolean vipFutureBooking = false;
		for(Guest item : guestList){
			if(item.getGuestID() == guestID){
				isStandard = true;
			}
		}
		for(VIPGuest item2 : vipGuestList){
			if(item2.getGuestID() == guestID){
				isVip = true;
			}
		}
		if(isStandard){
			for (Guest item3 : guestList) {
				if (item3.getGuestID() == guestID) {
					for (Booking item4 : bookingList) {
						if (item4.getGuestID() == guestID) {
							if (item4.getCheckInDate().isAfter(LocalDate.now())) {
								futureBooking = true;
								break;
							}
						}
					}
					if (futureBooking == false) {
						guestList.remove(item3);
						System.out.println("Guest successfully removed.");
						return true;
					}
				}
			}
		}else{
			for (VIPGuest item5 : vipGuestList) {
				if (item5.getGuestID() == guestID) {
					for (Booking item6 : bookingList) {
						if (item6.getGuestID() == guestID) {
							if (item6.getCheckInDate().isAfter(LocalDate.now())) {
								vipFutureBooking = true;
								break;
							}
						}
					}
					if (vipFutureBooking == false) {
						vipGuestList.remove(item5);
						System.out.println("VIP guest successfully removed.");
						return true;
					}
				}
			}
		}
		System.out.println("ERROR: Guest not found or has a current/future booking.");
        return false;
	}
	
    /**
    * check for a room's availability
    *
    * @param roomNumber a unique room number
    * @param checkin    the check-in date
    * @param checkout   the check-out date
    * @return           true if the room is available for this period, otherwise false.
    */
	
	public boolean isAvailable(int roomNumber, LocalDate checkin, LocalDate checkout){
		if(checkout.isBefore(checkin)){
            throw new IllegalArgumentException("ERROR: Checkin date must be before checkout date.");
        }
        for(Booking item : bookingList){
            if(item.getRoomNumber() == roomNumber){
				LocalDate min = (item.getCheckInDate().isBefore(checkin)) ? item.getCheckInDate() : checkin;
				LocalDate max = (item.getCheckOutDate().isAfter(checkout)) ? item.getCheckOutDate() : checkout;
                if ((ChronoUnit.DAYS.between(min, max)) - (ChronoUnit.DAYS.between(item.getCheckInDate(), item.getCheckOutDate()) 
					+ ChronoUnit.DAYS.between(checkin, checkout)) < 0){
					return false;
				}
			}
		}
        return true;
	}

    /**
    * Search for available rooms for one room type
    * @param roomType   a room type
    * @param checkin    the check-in date
    * @param checkout   the check-out date
    * @return           an array of available room numbers for this period
    */
  
	public int[] availableRooms(RoomType roomType, LocalDate checkin, LocalDate checkout){
		ArrayList<Integer> roomNumbers = new ArrayList<>();
        String roomTypeStr = roomTypeToString(roomType);
        for(Room item : roomList){
            if(item.getRoomType().equals(roomTypeStr)){
                roomNumbers.add(item.getRoomNumber());
            }
        }
        for(Integer item2 : roomNumbers){
			boolean availability = isAvailable(item2, checkin, checkout);
			if(availability = false){
				roomNumbers.remove(item2);
			}else{
				continue;
			}
		}
	
		return roomNumbers.stream().mapToInt(i -> i).toArray();
	}
	
    /**
    * Make a booking for one room type.
    * If more than one room avaible, choose one room randomly to book
    *
    * @param guestID    a unique guest ID
    * @param roomType   a room type
    * @param checkin    the check-in date
    * @param checkout   the check-out date
    * @return           the booked room number if the booking is successful,
    *                   otherwise, return -1
    */
  
	public int bookOneRoom(int guestID, RoomType roomType, LocalDate checkin, LocalDate checkout){
		boolean guestExists = false;
        boolean isVip = false;
        for(Guest item : guestList){
			if(item.getGuestID() == guestID){
				isVip = false;
				guestExists = true;
			}
		}
		for(VIPGuest item2 : vipGuestList){
			if(item2.getGuestID() == guestID){
				isVip = true;
				guestExists = true;
			}
		}
        if(!guestExists){
            throw new IllegalArgumentException("Invalid guest ID");
        }
        int[] rooms = availableRooms(roomType, checkin, checkout);
        if(rooms.length == 0){
            return -1;
        }
        int roomNum = rooms[new Random().nextInt(rooms.length)];
        for(Room item2 : roomList){
            if(item2.getRoomNumber() == roomNum){
                double totalAmount = item2.getPrice() * ChronoUnit.DAYS.between(checkin, checkout);
				int bookingID = bookingList.get(bookingList.size()-1).getBookingID() + 1;
                if(isVip){
                    totalAmount = (1 - vipDiscount) * totalAmount;
                }
                Booking newBooking = new Booking(bookingID, guestID, roomNum, LocalDate.now(), checkin, checkout, totalAmount);
                bookingList.add(newBooking);
                Payment newPayment = new Payment(LocalDate.now(), guestID, totalAmount, "booking");
                paymentList.add(newPayment);
                break;
            }
        }
        return roomNum;
	}
	
    /**
    * Check out by offering a unique booking ID.
    *
    * @param bookingID a unique booking ID
    * @param actualCheckoutDate the actual check-out date
    * @return          true if the check-out is successful, otherwise false.
    */
  
	public boolean checkOut(int bookingID, LocalDate actualCheckoutDate){
		for(Booking item : bookingList){
            if(item.getBookingID() == bookingID){
                if(actualCheckoutDate.isAfter(item.getCheckOutDate())||(actualCheckoutDate.isBefore(item.getCheckInDate()))){
                    System.out.println("Error: Invalid checkout date provide.");
					return false;
                }
                bookingList.remove(item);
                System.out.println("Check-out successful.");
				return true;
            }
        }
        System.out.println("Error: Booking not found");
        return false;
	}
	
    /**
    * Cancel a booking by offering a unique booking ID.
    *
    * @param bookingID a unique booking ID
    * @return          true if the cancellation is successful, otherwise false.
    */
  
	public boolean cancelBooking(int bookingID){
		for(Booking item : bookingList){
            if(item.getBookingID() == bookingID){
                bookingList.remove(item);
                long duration = ChronoUnit.DAYS.between(LocalDate.now(), item.getCheckInDate());
                if(duration >= refundPeriod){
                    Payment newPayment = new Payment(LocalDate.now(), item.getGuestID(), -item.getTotalAmount(), "refund");
                    paymentList.add(newPayment);
                }
                System.out.println("Booking successfully cancelled.");
				return true;
            }
        }
		System.out.println("ERROR: Provided booking ID not found.");
        return false;
	}
	
    /**
    * Search for a guest
    *
    * @param firstName the guest first name
    * @param lastName  the guest last name
    * @return          an array of guest IDs who match the name
    */
	
	public int [] searchGuest(String fName, String lName){
		ArrayList<Integer> searchGuestList = new ArrayList<>();
        for(Guest item : guestList){
            if((item.getFirstName().toLowerCase() == fName.toLowerCase()) && (item.getLastName().toLowerCase() == lName.toLowerCase())){
                searchGuestList.add(item.getGuestID());
            }
        }
        return searchGuestList.stream().mapToInt(x -> x).toArray();
	}
	
    /**
    * Print out a guest's booking information (if any)
    * by given the unique guest ID.
    *
    * @param guestID a unique guest ID
    *
    */
  
	public void displayGuestBooking(int guestID){
		for(Booking item : bookingList){
			if(item.getGuestID() == guestID){
				System.out.println(item);
			}
		}
	}
	
	/**
	* Find if a given test date is with the range of 
	* a provided start and end date.
	*
	* @param testDate date to be tested
	* @param startDate initial range date
	* @param endDate end range date
	*
	* @return true is the test date is within range, otherwise false.
	*/
	
	public boolean isWithinRange(LocalDate testDate, LocalDate startDate, LocalDate endDate) {
	   return !(testDate.isBefore(startDate) || testDate.isAfter(endDate));
	}
	
    /**
    * Display on the screen all the booking information by given a date
    * The output contains booking ID, the guest name, the room number,
    * the room type, the room price, the payment price (if the guest is
    * a VIP, the payment price is different from the room price, otherwise,
    * it equals the room price)
    *
    * @param  thisDate  a given date
    */
   
	public void displayBookingsOn(LocalDate thisDate){
		for(Booking item : bookingList){
			if(isWithinRange(thisDate, item.getCheckInDate(), item.getCheckOutDate())){
				System.out.println(item);
			}
		}
	}
	
    /**
    * Display on the screen all the payments on a given date.
    * This is to check how much income on a specific day.
    * The output contains the guest ID, the payment amount,
    * the payment reason ("booking", "VIPmembership" or "refund").
    * If it is due to cancelling, the payment amount refers to the
    * refund amount – a negative value.
    *
    * @param  thisDate  a given date
    */
  
	public void displayPaymentsOn(LocalDate thisDate){
		for(Payment item : paymentList){
			if(item.getDate() == thisDate){
				System.out.println(item);
			}
		}
	}
	
    /**
    * Save all the room records in a text file
    *
    * @param  roomsTxtFileName  the text file for all room records
    * @return true if saving data successfully, otherwise false
    */
   
	public boolean saveRoomsData(String roomsTxtFileName){
		try{
            BufferedWriter Writer = new BufferedWriter(new FileWriter(roomsTxtFileName));
            for(Room item : roomList){
                Writer.write(item.toString());
                Writer.newLine();
            }
            Writer.close();
			System.out.println("Room data successfully saved.");
            return true;
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
	}
	
    /**
    * Save all the guest records in a text file
    *
    * @param  guestsTxtFileName  the text file for all guest records
    * @return true if saving data successfully, otherwise false
    */
   
	public boolean saveGuestsData(String guestsTxtFileName){
		try{
            BufferedWriter Writer = new BufferedWriter(new FileWriter(guestsTxtFileName));
            for(Guest item : guestList){
                Writer.write(item.toString());
                Writer.newLine();
            }
            Writer.close();
			System.out.println("Guest data successfully saved.");
            return true;
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
	}
	
    /**
    * Save all the booking records in a text file
    *
    * @param  bookingsTxtFileName  the text file for all booking records
    * @return true if saving data successfully, otherwise false
    */
   
	public boolean saveBookingsData(String bookingsTxtFileName){
		try{
            BufferedWriter Writer = new BufferedWriter(new FileWriter(bookingsTxtFileName));
            for(Booking item : bookingList){
                Writer.write(item.toString());
                Writer.newLine();
            }
            Writer.close();
            System.out.println("Booking data successfully saved.");
			return true;
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
	}
	
    /**
    * Save all the payment records in a text file
    *
    * @param  paymentsTxtFileName  the text file for all payment records
    * @return true if saving data successfully, otherwise false
    */
   
	public boolean savePaymentsData(String paymentsTxtFileName){
		try{
            BufferedWriter Writer = new BufferedWriter(new FileWriter(paymentsTxtFileName));
            for(Payment item : paymentList){
                Writer.write(item.toString());
                Writer.newLine();
            }
            Writer.close();
            System.out.println("Payment data successfully saved.");
			return true;
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
	}
	
	String roomTypeToString(RoomType roomType) {
        String string;
        switch(roomType) {
            case DOUBLE: 
				string = "double"; 
				break;
            case SINGLE: 
				string = "single"; 
				break;
            case FAMILY: 
				string = "family"; 
				break;
            case TWIN: 
				string = "twin"; 
				break;
            default: throw new IllegalArgumentException("Invalid room type.");
        }
        return string;
    }
}