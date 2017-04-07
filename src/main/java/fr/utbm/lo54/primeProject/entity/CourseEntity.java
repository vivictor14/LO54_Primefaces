package fr.utbm.lo54.primeProject.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Victor on 07/04/2017.
 */
@Entity
@Table(name = "course", schema = "lo54-project")
public class CourseEntity {
    private String code;
    private Collection<CourseSessionEntity> courseSessionsByCode;

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

        CourseEntity that = (CourseEntity) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @OneToMany(mappedBy = "courseByCourseCode")
    public Collection<CourseSessionEntity> getCourseSessionsByCode() {
        return courseSessionsByCode;
    }

    public void setCourseSessionsByCode(Collection<CourseSessionEntity> courseSessionsByCode) {
        this.courseSessionsByCode = courseSessionsByCode;
    }
}
