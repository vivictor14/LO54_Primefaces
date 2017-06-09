package fr.utbm.lo54.primeProject.web.database;

import fr.utbm.lo54.primeProject.entity.Course;
import fr.utbm.lo54.primeProject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scorp on 09/06/2017.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@ManagedBean(name="coursesMgmtBean")
public class CoursesBean {

    @Autowired
    CourseService courseService;
    private List<Course> courseList = courseService.getCourses();

    public List<Course> getCourses(){
        return courseList;
    }

}
