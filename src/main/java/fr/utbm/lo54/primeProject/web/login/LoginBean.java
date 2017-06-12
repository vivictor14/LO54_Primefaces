package fr.utbm.lo54.primeProject.web.login;

import fr.utbm.lo54.primeProject.web.database.ClientBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * The Class LoginBean.
 */
@ManagedBean(name="loginManagementBean")
@RequestScoped
public class LoginBean {
     
    /** The user name. */
    private String userName = null;
     
    /** The password. */
    private String password = null;
 
    @ManagedProperty(value="#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

    @ManagedProperty(value="#{clientManagementBean}")
    private ClientBean clientBean = null;

    /**
     * Login.
     * 
     * @return the string
     */
    public String login() {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUserName(), this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
            clientBean.setClient(userName);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "Secured";
    }
     
    public String cancel() {
        return null;
    }
     
    public String logout(){
        SecurityContextHolder.clearContext();
        clientBean.clear();
        return "index?faces-redirect=true";
    }
 
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }
 
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public ClientBean getClientBean() {
        return clientBean;
    }

    public void setClientBean(ClientBean clientBean) {
        this.clientBean = clientBean;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }
 
    /**
     * Sets the user name.
     * 
     * @param userName
     *            the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    /**
     * Gets the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }
 
    /**
     * Sets the password.
     * 
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}