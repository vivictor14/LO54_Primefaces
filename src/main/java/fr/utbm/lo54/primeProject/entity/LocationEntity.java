package fr.utbm.lo54.primeProject.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Victor on 07/04/2017.
 */
@Entity
@Table(name = "location", schema = "lo54-project")
public class LocationEntity {
    private String city;
    private int id;
    private Collection<CourseSessionEntity> courseSessionsById;

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationEntity that = (LocationEntity) o;

        if (id != that.id) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @OneToMany(mappedBy = "locationByLocationId")
    public Collection<CourseSessionEntity> getCourseSessionsById() {
        return courseSessionsById;
    }

    public void setCourseSessionsById(Collection<CourseSessionEntity> courseSessionsById) {
        this.courseSessionsById = courseSessionsById;
    }
}
