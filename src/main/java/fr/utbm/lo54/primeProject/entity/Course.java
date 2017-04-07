package fr.utbm.lo54.primeProject.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Victor on 07/04/2017.
 */
@Entity
@Table(name = "course", schema = "lo54-project")
public class Course {
    private String code;
    private Collection<CourseSession> courseSessionsByCode;

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

        Course that = (Course) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @OneToMany(mappedBy = "courseByCourseCode")
    public Collection<CourseSession> getCourseSessionsByCode() {
        return courseSessionsByCode;
    }

    public void setCourseSessionsByCode(Collection<CourseSession> courseSessionsByCode) {
        this.courseSessionsByCode = courseSessionsByCode;
    }
}
