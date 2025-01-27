package Database;

import java.util.*;
import Person.Person;

/**
 * MARK: UserDB
 * DESC : this is used to perform crud operations on the User db
 */
public class UserDB {
    
    private static List<Person> users = new ArrayList<>();
    private static UserDB userDB = new UserDB();

    private UserDB(){}

    public static UserDB get_instance(){
        return userDB;
    }
     
    /**
     * MARK: get_users
     * DESC : this is used to return the reference of the users db
     * @return
     */
    public static List<Person> get_users(){
        return users;
    }

    /**
     * MARK : contains_user
     * DESC : checks if the db contains the specific person
     * @param person
     * @return
     */
    public static boolean contains_user(Person person){
        return users.contains(person);
    }


    /**
     * MARK : add_user
     * DESC : adds a user to the db
     * @param person
     */
    public static void add_user(Person person){
        users.add(person);
    }

    /**
     * MARK : delete_user
     * DESC : deletes a user fro the db
     * @param person
     */
    public static void delete_user(Person person){
        if(users.contains(person)){
            users.remove(person);
            System.out.println(" SYSTEM : USER DELETED ");
            return;
        }
        System.out.println(" SYSTEM : USER DOES NOT EXIST ");
    }

    /**
     * MARK : update_user
     * DESC : update a user
     * @param person
     */
    public static void update_user(Person person){
        System.out.println(" SYSTEM : USER UPDATED ");
    }

    /**
     * MARK : print_db
     * DESC : this is used to print the db
     */
    public static void print_db(){

        System.out.println(" SYSTEM : PRINTING DB ");

        for(Person person : users){
            System.out.println(person);
        }
    }
}
