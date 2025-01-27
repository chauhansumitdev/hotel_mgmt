package Database;

import java.util.*;
import Hotel.Hotel;
import Room.Room;


/**
 * MARK: HotelDB
 * DESC : This contains the hoteldb and performs crud operations
 */
public class HotelDB {

    private static Map<Hotel , List<Room>> map = new HashMap<>();
    private static HotelDB hotelDB = new HotelDB();
    private HotelDB(){
    
    }

    public static HotelDB get_instance(){
        return hotelDB;
    }

    /**
     * MARK: add_hotel
     * DESC : used to add a hotel with a set of rooms
     * @param hotel
     * @param rooms
     */
    public static void add_hotel(Hotel hotel, List<Room> rooms){
        map.put(hotel, rooms);
        System.out.println(" SYSTEM : HOTEL ADDED ");
    }

    /**
     * MARK: add_hotel
     * DESC : used to add hotel
     * @param hotel
     */
    public static void add_hotel(Hotel hotel){
        map.put(hotel, new ArrayList<>());
    }

    /**
     * MARK: remove_hotel
     * DESC : used to remove the hotel from the db
     * @param hotel
     */
    public static void remove_hotel(Hotel hotel){
        if(map.containsKey(hotel)){
            map.remove(hotel);
            System.out.println(" SYSTEM : HOTEL REMOVED ");
            return;
        }
        System.out.println(" SYSTEM : NO SUCH HOTEL EXISTS ");
    }


    /**
     * MARK: read_hotel
     * DESC : reads/prints the db
     */
    public static void read_hotel(){
        for(Map.Entry<Hotel , List<Room>> entry : map.entrySet()){
            System.out.println(" HOTEL "+ entry.getKey());

            for(Room current_rooom : entry.getValue()){
                System.out.println(" ROOM ID "+current_rooom);
            }
        }
    }

    /**
     * MARK: read_hotel_by_name
     * DESC : finds the hotel by name
     * @param name
     */
    public static void read_hotel_by_name(String name){
        for(Map.Entry<Hotel , List<Room>> entry : map.entrySet()){

            if(!(entry.getKey().get_name().equals(name))){
                continue;
            }

            System.out.println(" HOTEL "+ entry.getKey());

            for(Room current_rooom : entry.getValue()){
                System.out.println(" ROOM ID "+current_rooom);
            }
        }
    }

    /**
     * MARK: read_hotel_by_city_name
     * DESC : finds the city by city name
     * @param city_name
     */
    public static void read_hotel_by_city_name(String city_name){
        for(Map.Entry<Hotel , List<Room>> entry : map.entrySet()){

            if(!(entry.getKey().get_city().equals(city_name))){
                continue;
            }

            System.out.println(" HOTEL "+ entry.getKey());

            for(Room current_rooom : entry.getValue()){
                System.out.println(" ROOM ID "+current_rooom);
            }
        }
    }


    /**
     * MARK: add_room
     * DESC : adds a room to the hotel
     * @param hotel
     * @param room
     */
    public  static void add_room(Hotel hotel, Room room){
        if(map.containsKey(hotel)){
            map.get(hotel).add(room);
            System.out.println(" SYSTEM : ROOM ADDED "); 
            return;
        }

        System.out.println(" SYSTEM : RESTRICTED ACTION ");
    }

    public static boolean contains_hotel(Hotel hotel){
        return map.containsKey(hotel);
    }
}

