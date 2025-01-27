package Database;
import Person.Person;
import java.util.*;
import Hotel.Hotel;

/**
 * MARK: FeedbackDB
 * DESC : this class is used to perform crud operations on the feedback db
 */
public class FeedbackDB {
    
    private static Map<Person,Node > feedback = new HashMap<>();

    private static FeedbackDB feedbackDB = new FeedbackDB();

    private FeedbackDB(){}


    public static FeedbackDB get_instance(){
        return feedbackDB;
    }

    /**
     * MARK: add_feedback
     * DESC : adds a feedback entry in the db
     * @param person
     * @param text
     * @param rating
     */
    public static void add_feedback(Person person,Hotel hotel, String text, int rating){
        if(UserDB.contains_user(person)){

            System.out.println(" SYSTEM : FEEDBACK ADDED  FROM "+person+" "+ text+" "+ rating +" FOR "+hotel);
            feedback.put(person, new Node(hotel,rating, text));
        }
    }

}

/**
 * MARK: Node
 * DESC : class for storing the rating and the feedback text
 */
class Node{
    public Hotel hotel;
    public int rate;
    public String text;
    public Node(Hotel hotel, int rate, String text){
        this.rate = rate;
        this.text = text;
        this.hotel = hotel;
    }
}