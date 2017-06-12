package fr.utbm.lo54.primeProject.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="course")
public class Course implements Serializable {
    private String code;
    private Collection<CourseSession> courseSessions;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (code != null ? !code.equals(course.code) : course.code != null) return false;

        return true;
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    public Collection<CourseSession> getCourseSessions() {
        return courseSessions;
    }

    public void setCourseSessions(Collection<CourseSession> courseSessions) {
        this.courseSessions = courseSessions;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }
}
