package dev.matheuslf.desafio.inscritos.repositories;

import dev.matheuslf.desafio.inscritos.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
