package fr.utbm.lo54.primeProject.web.database;

import fr.utbm.lo54.primeProject.service.LocationService;
import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.text.SimpleDateFormat;
import java.util.*;

@Component("searchBean")
@ManagedBean(name="searchBean")
@ViewScoped
public class SearchBean {

    private List<String> chips = new ArrayList<>();

    private final LocationService locationService;

    private ResourceBundle bundle;

    private String location;

    private Date date = today();

    private String placeHolder;

    public SearchBean(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostConstruct
    public void init() {
        bundle = getMessageBundle();
    }

    private ResourceBundle getMessageBundle() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getResourceBundle(facesContext, "msg");
    }

    public List<String> getChips() {
        return chips;
    }

    public void setChips(List<String> chips) {
        if(chips != null) {
            this.chips = chips;
        }
        else {
            this.chips.clear();
        }
    }

    private void addChip(String chip) {
        if(!chip.isEmpty()) {
            chips.add(chip);
        }
    }

    public List<String> getAvailableLocations() {
        List<String> locations = new ArrayList<>();
        locationService.getLocations().forEach(consumer -> locations.add(consumer.getCity()));
        return locations;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addingLocationListener(AjaxBehaviorEvent event) {
        addChip(location);
        location = "";
    }

    public void addingDateListener(SelectEvent event) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        addChip(format.format(date));
        date = today();
    }

    private Date today() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        return today.getTime();
    }

    public String getPlaceHolder() {
        bundle = getMessageBundle();
        if(chips.size() > 0) {
            return "";
        }
        else {
            return bundle.getString("search.placeHolder");
        }
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }
}
