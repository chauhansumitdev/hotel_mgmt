package Hotel;

import java.util.*;
import Room.Room;

/**
 * MARK : HotelManagement
 * DESC : perform crud operations on hotel
 */
public class HotelManagement {
    

    public Hotel create_hotel(String name, String city){
        return new Hotel(name, city);
    }

    public void read_hotel(Hotel hotel){
        System.out.println(" SYSTEM : READING HOTEL "+ hotel);
    }

    public void update_hotel(Hotel hotel, List<Room> rooms){
        System.out.println(" SYSTEM : UPDATING HOTEL " + hotel);
    }
}
