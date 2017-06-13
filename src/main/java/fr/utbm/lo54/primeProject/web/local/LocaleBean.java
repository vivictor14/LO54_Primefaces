package fr.utbm.lo54.primeProject.web.local;

 
import java.io.*;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.*;
import javax.faces.event.*;
 
@ManagedBean(name = "localeManagementBean")
@SessionScoped
public class LocaleBean implements Serializable {
    private Locale locale = Locale.ENGLISH;
    private String language = "en";

    private List<String> availableLanguages = new ArrayList<>();

    @PostConstruct
    public void init() {
        FacesContext.getCurrentInstance().getApplication().getSupportedLocales().forEachRemaining(supportedLocale -> availableLanguages.add(supportedLocale.toLanguageTag()));
    }

    public Locale getLocale() {
        return(locale);
    }

    public void valueChanged(AjaxBehaviorEvent event) {
        locale = Locale.forLanguageTag(language);
        updateViewLocale();
    }

    private void updateViewLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Collection<String> getAvailableLanguages() {
        return availableLanguages;
    }
}