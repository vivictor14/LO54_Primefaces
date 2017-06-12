package fr.utbm.lo54.primeProject.service;

import fr.utbm.lo54.primeProject.entity.CourseSession;
import fr.utbm.lo54.primeProject.repository.CourseSessionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("courseSessionService")
public class CourseSessionService {

    private final CourseSessionRepository courseSessionRepository;

    public CourseSessionService(CourseSessionRepository courseSessionRepository){
        this.courseSessionRepository = courseSessionRepository;
    }

    public List<CourseSession> getCourseSessions(){
        return courseSessionRepository.findAll();
    }

    public CourseSession getCourseSessionById(int sessionId) {
        return courseSessionRepository.findOne(sessionId);
    }

}
