package Room;

/**
 * MARK : RoomManagement
 * DESC : perform crud operation on the room
 */
public class RoomManagement {

    public Room create_room(){
        return new Room();
    }

    public void read_room(Room room){
        System.out.println(" SYSTEM : READING "+room);
    }

    public void update_room(Room room){
        System.out.println(" SYSTEM : ROOM UPDATED ");
    }
}
