package fr.utbm.lo54.primeProject.web.database;

import fr.utbm.lo54.primeProject.entity.Course;
import fr.utbm.lo54.primeProject.entity.CourseSession;
import fr.utbm.lo54.primeProject.entity.Location;
import fr.utbm.lo54.primeProject.service.CourseService;
import fr.utbm.lo54.primeProject.service.CourseSessionService;
import fr.utbm.lo54.primeProject.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Component("coursesManagementBean")
@ManagedBean(name="coursesManagementBean")
@SessionScoped
public class CoursesBean {

    private final CourseService courseService;

    private final CourseSessionService courseSessionService;

    private int sessionId;
    private String sessionIdString;

    public CoursesBean(CourseService courseService, CourseSessionService courseSessionService) {
        this.courseService = courseService;
        this.courseSessionService = courseSessionService;
    }

    private List<Course> courses;

    @PostConstruct
    void init() {
        courses = courseService.getCourses();
    }

    public List<Course> getCourses(){
        return courses;
    }

    public CourseSession getSession() {
        return courseSessionService.getCourseSessionById(this.sessionId);
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionIdString(String sessionIdString) {
        this.sessionIdString = sessionIdString;
        sessionId = Integer.parseInt(sessionIdString);
    }
}
