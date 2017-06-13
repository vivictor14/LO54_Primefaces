package fr.utbm.lo54.primeProject.web.database;

import javax.faces.bean.ManagedBean;

/**
 * Created by Scorp on 13/06/2017.
 */

@ManagedBean(name="searchBean")
public class SearchBean {

    private String tags;

    public SearchBean(){

    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
        System.out.println(tags);
    }

}
