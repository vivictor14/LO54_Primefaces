package fr.utbm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -7860243025833384447L;

    @Id
    private Long id;

    private String login;
    
    private String firstName;
    
    private String lastName;
    
    private Date dayOfBirth;
    
    @ManyToOne
    private User manager;


}
