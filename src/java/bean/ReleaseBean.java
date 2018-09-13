/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.ReleaseListDb;
import entity.ReleaseList;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ReleaseBean {
    String kbn="";
    String release_name;
    
    
    @Inject
    ReleaseListDb releasedb;
    
    public void serchName(String kbn){
        ReleaseList release = this.releasedb.serchName(kbn);
        this.release_name = release.getRelease_name();
    }
    
    

    public String getKbn() {
        return kbn;
    }

    public void setKbn(String kbn) {
        this.kbn = kbn;
    }

    public String getRelease_name() {
        return release_name;
    }

    public void setRelease_name(String release_name) {
        this.release_name = release_name;
    }

    public ReleaseListDb getReleasedb() {
        return releasedb;
    }

    public void setReleasedb(ReleaseListDb releasedb) {
        this.releasedb = releasedb;
    }
    
    
    
    
    
    
}
