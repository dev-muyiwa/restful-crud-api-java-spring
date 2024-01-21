package dev.muyiwa.springboot.restfulcrudapi.users;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserController {

    private MessageSource messageSource;
    @Autowired

    public UserController(MessageSource source) {
        this.messageSource = source;
    }

    private UserDao dao;

    public UserController(UserDao dao) {
        this.dao = dao;
    }

    @GetMapping("/hello")
    public String helloInternationalization() {
        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage("good.morning.message", null, "Default Message!", locale);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return dao.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = dao.findOne(id);
        if(user == null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        dao.deleteOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User newUser = dao.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
