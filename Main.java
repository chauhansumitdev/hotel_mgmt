import Person.Person;
import Database.UserDB;
import Hotel.Hotel;
import Room.Room;

public class Main {

    public static void main(String[] args) {
        

        HotelManagementSystem hms = new HotelManagementSystem();

        Person admin = hms.create_user("Admin", "SUPERUSER");
        Person agent = hms.create_user("Agent", "AGENT");
        Person user = hms.create_user("User", "USER_1");

        hms.register_user(admin);
        hms.register_user(agent);
        hms.register_user(user);


        hms.list_hotels();

        Hotel hotel = hms.create_hotel(agent, "HOTEL", "LAHORE");   

        Room room_1 = hms.create_room(agent);
        Room room_2 = hms.create_room(agent);

        hms.add_hotel(admin, agent, hotel);
        hms.add_room(agent, hotel, room_1);
        hms.add_room(agent, hotel, room_2);

        hms.list_hotels();

        UserDB.print_db();

        hms.book_room(user, room_1);

        hms.take_feedback(user,hotel, "nice room", 5);
    }
}