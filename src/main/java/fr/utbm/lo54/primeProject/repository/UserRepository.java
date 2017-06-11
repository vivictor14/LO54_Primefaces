package fr.utbm.lo54.primeProject.repository;

import fr.utbm.lo54.primeProject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findOneByUsername(String username);

    @EntityGraph(attributePaths = "authorities")
    User findOneWithAuthoritiesById(int id);

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);

    Page<User> findAllByUsernameNot(Pageable pageable, String username);
}