package model;

import java.io.Serializable;

public class Chef extends User implements Serializable {
    public Chef(String name, String email, String username, String password, String phone) {
        super(name, email, username, password, phone);
    }
}
