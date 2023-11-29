import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private final String name;
    private final String email;
    private final String username;
    private final String password;
    private final String phone;

    public User(String name, String email, String username,String password, String phone) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    // tostring
    @Override
    public String toString() {
        return name;
    }
}
