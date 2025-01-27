package Database;

import Person.Person;
import Room.Room;
import java.util.*;;

/**
 * MARK: AllotedDB
 * DESC : This is the database that contains the information of the rooms alloted to person
 */
public class AllotedDB {

    private static Map<Room, Person> alloted = new HashMap<>();

    // Private constructor
    private AllotedDB(){
    }   

    /**
     * MARK:get_alloted_db
     * DESC: this function is used to retrieve the alloted map 
     * @return
     */
    public static Map<Room, Person> get_alloted_db(){
        return alloted;
    }

    /**
     * MARK: is_room_alloted 
     * DESC : this function is used to check if the room is already alloted to someone or not
     * @param room
     * @return
     */
    public static boolean is_room_alloted(Room room){
        return !alloted.containsKey(room);
    }


    /**
     * MARK: add_entry
     * DESC: adds an entry to the map
     * @param person
     * @param room
     */
    public static void add_entry(Person person, Room room){
        alloted.put(room, person);
        System.out.println(" SYSTEM : ENTRY ADDED, PERSON "+person +" ROOM ID "+room);
    }

    /**
     * MARK: remove_entry
     * DESC : removed the room from the db
     * @param room
     */
    public static void remove_entry(Room room){
        if(alloted.containsKey(room)){
            alloted.remove(room);
        }
    }

    /**
     * MARK: print_db
     * DESC : this is used to print the entris in the db
     */
    public static void print_db(){
        for(Map.Entry<Room, Person> entry : alloted.entrySet()){
            System.out.println(entry.getValue() +" RESERVED TO "+ entry.getKey());
        }
    }
}
