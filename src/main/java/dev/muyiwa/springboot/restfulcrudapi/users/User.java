package dev.muyiwa.springboot.restfulcrudapi.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity(name = "users")
public class User {

    protected User() {
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;

    @Email(message = "Email must be valid")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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
