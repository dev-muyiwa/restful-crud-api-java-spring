package dev.muyiwa.springboot.restfulcrudapi.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class User {
    private Integer id;

    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;

    @Email(message = "Email must be valid")
    private String email;

    public User(int id, String name, String email) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
