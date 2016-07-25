package model;

/**
 * Created by yjlu@thoughtworks.com on 7/25/16.
 */
public class User {
    private String id; //library number
    private String name;
    private String password;
    private String email;
    private String tel; //phone number

    public User(String id,String name,  String password, String email, String tel) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String description() {
        return "[Library number]: " + id + ", [name]: " + name +
                ", [Email]: " + email +", [Tel]: " + tel;
    }
}
