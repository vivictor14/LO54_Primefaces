package fr.utbm.lo54.primeProject.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "course_session")
public class CourseSession {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Course course;
    private Location location;
    private Collection<Client> clients;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

        CourseSession that = (CourseSession) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "code", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToMany(mappedBy = "courseSessions")
    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }
}
