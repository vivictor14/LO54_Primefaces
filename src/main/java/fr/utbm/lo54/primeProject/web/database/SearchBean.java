package fr.utbm.lo54.primeProject.web.database;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scorp on 13/06/2017.
 */

@ManagedBean(name="searchBean")
public class SearchBean {

    private List<String> tags = new ArrayList<>();

    public SearchBean(){

    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}
