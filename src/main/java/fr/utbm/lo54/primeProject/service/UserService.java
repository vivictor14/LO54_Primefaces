package fr.utbm.lo54.primeProject.service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.utbm.lo54.primeProject.entity.User;
import fr.utbm.lo54.primeProject.repository.UserRepository;

@Component("userService")
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUsername(String username) {

        Optional<User> user = userRepository.findOneByUsername(username);
        if(user.isPresent()) {
            return user.get();
        }
        else {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

    }

}
