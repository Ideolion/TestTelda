
package com.example.TestTelda.entity;


/**
 *
 * @author Уфилин Д.В.
 * 
 */

public class Region {
    
    Long id;
    String regionfullname;
    String regionshortname;

    public Region() {
    }

    public Region(Long id, String regionfullname, String regionshortname) {
        this.id = id;
        this.regionfullname = regionfullname;
        this.regionshortname = regionshortname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionfullname() {
        return regionfullname;
    }

    public void setRegionfullname(String regionfullname) {
        this.regionfullname = regionfullname;
    }

    public String getRegionshortname() {
        return regionshortname;
    }

    public void setRegionshortname(String regionshortname) {
        this.regionshortname = regionshortname;
    }

 
    
}
