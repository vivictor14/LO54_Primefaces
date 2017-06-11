package fr.utbm.lo54.primeProject.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Victor on 11/06/2017.
 */
@Entity
public class Location {
    private String city;
    private Integer id;

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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        if (id != null ? !id.equals(location.id) : location.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
