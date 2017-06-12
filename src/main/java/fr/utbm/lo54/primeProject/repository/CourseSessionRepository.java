package fr.utbm.lo54.primeProject.repository;

import fr.utbm.lo54.primeProject.entity.CourseSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface CourseSessionRepository extends JpaRepository<CourseSession, Integer> {
}
