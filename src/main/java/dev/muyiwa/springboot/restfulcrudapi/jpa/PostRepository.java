package dev.muyiwa.springboot.restfulcrudapi.jpa;

import dev.muyiwa.springboot.restfulcrudapi.users.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
