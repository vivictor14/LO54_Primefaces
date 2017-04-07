package fr.utbm.lo54.primeProject.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Victor on 07/04/2017.
 */
@Entity
@Table(name = "course_session", schema = "lo54-project")
public class CourseSessionEntity {
    private int id;
    private Date startDate;
    private Date endDate;
    private Collection<ClientEntity> clientsById;
    private CourseEntity courseByCourseCode;
    private LocationEntity locationByLocationId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseSessionEntity that = (CourseSessionEntity) o;

        if (id != that.id) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "courseSessionByCourseSessionId")
    public Collection<ClientEntity> getClientsById() {
        return clientsById;
    }

    public void setClientsById(Collection<ClientEntity> clientsById) {
        this.clientsById = clientsById;
    }

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "code", nullable = false)
    public CourseEntity getCourseByCourseCode() {
        return courseByCourseCode;
    }

    public void setCourseByCourseCode(CourseEntity courseByCourseCode) {
        this.courseByCourseCode = courseByCourseCode;
    }

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    public LocationEntity getLocationByLocationId() {
        return locationByLocationId;
    }

    public void setLocationByLocationId(LocationEntity locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
    }
}
