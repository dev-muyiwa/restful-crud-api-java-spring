package dev.muyiwa.springboot.restfulcrudapi.users;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDao {
    private static List<User> users = new ArrayList<User>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "John", "john@mail.com"));
        users.add(new User(++userCount, "Doe", "doe@mail.com"));
        users.add(new User(++userCount, "Wells", "wells@mail.com"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
