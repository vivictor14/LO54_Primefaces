package fr.utbm.lo54.primeProject.repository;

import fr.utbm.lo54.primeProject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
