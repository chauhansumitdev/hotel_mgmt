import Database.AllotedDB;
import Database.FeedbackDB;
import Database.HotelDB;
import Database.UserDB;
import Hotel.Hotel;
import Hotel.HotelManagement;
import Person.UserManagement;
import Room.RoomManagement;
import Person.*;
import Person.User;
import Room.Room;
import java.util.*;

/**
 * MARK: HotelManagementSystem
 * DESC: Hotel Management class for performing different role specific operations 
 */
public class HotelManagementSystem {

    private RoomManagement roomManagement;
    private HotelManagement hotelManagement;
    private UserManagement userManagement;


    public HotelManagementSystem(){
        roomManagement = new RoomManagement();
        hotelManagement = new HotelManagement();
        userManagement = new UserManagement();
    }

    
    public void list_hotels(){
        HotelDB.read_hotel();
    }

    /**
     * MARK: list_hotels
     * DESC : this is used to list the hotels based on the filter
     * @param name
     * @param city
     */
    public void list_hotels(String name, String city){

        if(name == null && city == null){

            System.out.println(" SYSTEM : NAME AND CITY CANNOT BE NULL ");
            return;

        }

        if(name == null){
            HotelDB.read_hotel_by_city_name(city);
        }else if(city == null){
            HotelDB.read_hotel_by_name(name);
        }
    }

    /**
     * MARK: register_user
     * DESC : this is used to register the user
     * @param person
     */
    public void register_user(Person person){
    
        UserDB.add_user(person);

        if(person instanceof Admin){            
            System.out.println(" SYSTEM : ADMIN ADDED ");
        }else if(person instanceof User){
            System.out.println(" SYSTEM : USER ADDED ");
        }else{
            System.out.println(" SYSTEM : AGENT ADDED");
        }
    }

    /**
     * MARK: update_user_details
     * DESC : this is used to update the user details
     * @param person
     */
    public void update_user_details(Person person){
        if(UserDB.contains_user(person)){
            userManagement.update_user(person);
        }else{  
            System.out.println(" SYSTEM : USER DOES NOT EXIST ");
        }
    }

    /**
     * MARK: add_hotel
     * DESC : this is used to add a hotel to the system
     * @param admin
     * @param agent
     * @param hotel
     */
    public void add_hotel(Person admin, Person agent, Hotel hotel){
        if(agent instanceof Agent && UserDB.contains_user(agent)){
            approve_by_admin(admin, hotel);
            HotelDB.add_hotel(hotel);
            System.out.println(" SYSTEM : HOTEL ADDED SUCCESSFULLY ");
        }else{
            System.out.println(" SYSTEM : RESTRICTED ACCESS ");
        }
    }

    /**
     * MARK: add_hotel
     * DESC : this is used to add a hotel to the system
     * @param admin
     * @param agent
     * @param hotel
     * @param rooms
     */
    public void add_hotel(Person admin ,Person agent, Hotel hotel, List<Room> rooms){
        if(agent instanceof Agent && UserDB.contains_user(agent)){
            approve_by_admin(admin, hotel);
            HotelDB.add_hotel(hotel, rooms);
            System.out.println(" SYSTEM : HOTEL ADDED SUCCESSFULLY ");
        }else{
            System.out.println(" SYSTEM : RESTRICTED ACCESS ");
        }
    }

    /**
     * MARK: approve_by_admin
     * DESC : gives approval from the admin
     * @param admin
     * @param hotel
     * @return
     */
    public boolean approve_by_admin(Person admin, Hotel hotel){

        if(admin instanceof Admin){

            System.out.println(" SYSTEM : APPROVED BY ADMIN ");
            return true;
        }

        System.out.println(" SYSTEM : CANNOT APPROVE BY ADMIN ");
        return false;
    }

    /**
     * MARK: update_hotel_details
     * DESC : update the hotel dettails
     * @param person
     * @param hotel
     * @param rooms
     */
    public void update_hotel_details(Person person, Hotel hotel, List<Room> rooms){
        if((person instanceof Agent || person instanceof Admin) && UserDB.contains_user(person) && HotelDB.contains_hotel(hotel)){
            hotelManagement.update_hotel(hotel, rooms);
        }
    }   

    /**
     * MARK: remove_hotel
     * DESC : removes the hotel based on the hotel
     * @param person
     * @param hotel
     */
    public void remove_hotel(Person person, Hotel hotel){
        if(person instanceof Admin || person instanceof Agent){
            HotelDB.remove_hotel(hotel);
        }
    }


    /**
     * MARK: book_room
     * DESC : books a rooom to the user
     * @param user
     * @param room
     */
    public void book_room(Person user , Room room){
        if(user instanceof User && UserDB.contains_user(user) && AllotedDB.is_room_alloted(room)){
            AllotedDB.add_entry(user, room);
            System.out.println(" SYSTEM : ROOM ALLOTED ");
            return;
        }else{

            System.out.println(" SYSTEM : CANNOT ALLOT ROOM ");

        }
    }

    /**
     * MARK: reservation_status
     * DESC : shows the booked users
     */
    public void reservation_status(){
        AllotedDB.print_db();
    }


    /**
     * MARK: create_hotel
     * DESC :this is used to create a hotel based on role
     * @param person
     * @param name
     * @param city
     * @return
     */
    public Hotel create_hotel(Person person, String name, String city){

        if(!(person instanceof Agent)){
            System.out.println(" SYSTEM : RESTRICTED ACCESS ");
            return null;
        }

        System.out.println(" SYSTEM : HOTEL CREATED ");

        return hotelManagement.create_hotel(name, city);
    }

    public void read_hotel(Hotel hotel){
        hotelManagement.read_hotel(hotel);
    }

    public void update_hotel(Person person, Hotel hotel){
        if(person instanceof Admin || person instanceof Agent){
            hotelManagement.update_hotel(hotel, null);
        }
    }

    public Person create_user(String type, String name){
        return userManagement.create_user(type, name);
    }

    public void read_user(Person person){
        userManagement.read_user(person);
    }

    public void update_user(Person access, Person person){
        if(access instanceof Admin || access instanceof Agent){
            userManagement.read_user(person);
        }
    }

    /**
     * MARK: add_room
     * DESC : adds a room to a particular hotel
     * @param person
     * @param hotel
     * @param room
     */
    public void add_room(Person person, Hotel hotel, Room room){
        if(person instanceof Agent){
            HotelDB.add_room(hotel, room);
        }
    }

    /**
     * MARK: create_room
     * DESC : creates a room 
     * @param person
     * @return
     */
    public Room create_room(Person person){
        if(person  instanceof Agent){

            System.out.println(" SYSTEM : ROOM CREATED ");
            return roomManagement.create_room();
        }

        return null;
    }

    public void read_room(Room room){
        roomManagement.read_room(room);
    }

    public void update_room(Person person, Room room){
        if(person instanceof Agent){
            roomManagement.update_room(room);
            return;
        }

        System.out.println(" SYSTEM : RESTRICTED ACCESS ");
    }


    public void take_feedback(Person person,Hotel hotel, String text, int rating){
        FeedbackDB.add_feedback(person, hotel, text, rating);
    }


}
