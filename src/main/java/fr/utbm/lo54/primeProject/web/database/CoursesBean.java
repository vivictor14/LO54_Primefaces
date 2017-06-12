package fr.utbm.lo54.primeProject.web.database;

import fr.utbm.lo54.primeProject.Application;
import fr.utbm.lo54.primeProject.entity.Course;
import fr.utbm.lo54.primeProject.entity.CourseSession;
import fr.utbm.lo54.primeProject.service.CourseService;
import fr.utbm.lo54.primeProject.service.CourseSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scorp on 09/06/2017.
 */
@Component("coursesMgmtBean")
@ManagedBean(name="coursesMgmtBean")
@SessionScoped
public class CoursesBean implements Serializable {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseSessionService courseSessionService;

    private List<Course> courses;

    @PostConstruct
    void init() {
        courses = courseService.getCourses();
    }

    public List<Course> getCourses(){
        return courses;
    }

    public CourseSession getSession(int sessionId) {
        return courseSessionService.getCourseSessionById(sessionId);
    }
}
