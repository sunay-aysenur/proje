public class User extends Person {
    private String userName;
    private String password;

    public User(String userName, String password, int id, String firstName, String lastName, int age){
        super(id, firstName, lastName, age);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }
}
