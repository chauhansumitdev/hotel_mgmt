package Hotel;


/**
 * MARK : Hotel
 * DESC : Hotel entity
 */
public class Hotel {
    
    private String name;
    private String city;

    public Hotel(String name, String city){
        this.name = name;
        this.city = city;
    }

    public String get_name(){
        return name;
    }

    public String get_city(){
        return city;
    }
}
