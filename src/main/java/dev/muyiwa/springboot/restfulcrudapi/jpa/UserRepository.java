package dev.muyiwa.springboot.restfulcrudapi.jpa;

import dev.muyiwa.springboot.restfulcrudapi.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
