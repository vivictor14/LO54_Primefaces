package fr.utbm.lo54.primeProject.repository;

import fr.utbm.lo54.primeProject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Victor on 07/04/2017.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}
