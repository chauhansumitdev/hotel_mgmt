package Person;

public class UserManagement {
    
    public Person create_user(String type, String name){
        if(type.equals("Admin")){
            return new Admin(name);
        }else if(type.equals("User")){
            return new User(name);
        }else{
            return new Agent(name);
        }
    }

    public void read_user(Person person){
        if(person instanceof Admin){
            System.out.println(" SYSTEM : READING ADMIN "+person);
        }else if(person instanceof Agent){
            System.out.println(" SYSTEM : READING AGENT "+ person);
        }else{
            System.out.println(" SYSTEM : READING USER "+person);
        }
    }

    public void update_user(Person person){
        System.out.println(" SYSTEM : USER UPDATED "+person);
    }

}
