package fr.utbm.lo54.primeProject.service;

import fr.utbm.lo54.primeProject.entity.Course;
import fr.utbm.lo54.primeProject.repository.CourseRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("courseService")
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

}
