package fr.utbm.lo54.primeProject.web.database;

import fr.utbm.lo54.primeProject.entity.Client;
import fr.utbm.lo54.primeProject.service.ClientService;
import fr.utbm.lo54.primeProject.service.CourseSessionService;
import fr.utbm.lo54.primeProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

@Component("clientManagementBean")
@ManagedBean(name="clientManagementBean")
@SessionScoped
public class ClientBean {

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CourseSessionService courseSessionService;

    private Client client;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String email;

    public void clear() {
        client = null;
        lastName = null;
        firstName = null;
        address = null;
        phone = null;
        email = null;
    }

    public void enroll() {
        int sessionId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sessionId"));
        client.addCourseSession(courseSessionService.getCourseSessionById(sessionId));
        clientService.persist(client);
    }

    public boolean isAlreadyEnrolled(int sessionId) {
        return client.getCourseSessions().stream().anyMatch(courseSession -> courseSession.getId().equals(sessionId));
    }

    public Client getClient() {
        return client;
    }

    public void setClient(String username) {
        client = userService.findUserByUsername(username).getClient();
        lastName = client.getLastName();
        firstName = client.getFirstName();
        address = client.getAddress();
        phone = client.getPhone();
        email = client.getEmail();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        client.setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        client.setFirstName(firstName);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        client.setAddress(address);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        client.setPhone(phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        client.setEmail(email);
    }
}
