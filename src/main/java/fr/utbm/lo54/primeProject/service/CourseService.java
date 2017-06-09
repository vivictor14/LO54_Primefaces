package fr.utbm.lo54.primeProject.service;

import fr.utbm.lo54.primeProject.entity.Course;
import fr.utbm.lo54.primeProject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 07/04/2017.
 */

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseService(){

    }

    public List<Course> getCourses(){
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

}
