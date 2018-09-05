package bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
    private String empName;
    private String regiNum;
    private boolean authenticated;
    
    public void login(String empName){
        this.empName = empName;
        this.authenticated = true;
    }
    
    public void logout(){
        this.empName = null;
        this.authenticated = false;
    }

    // getter setter
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getRegiNum() {
        return regiNum;
    }

    public void setRegiNum(String regiNum) {
        this.regiNum = regiNum;
    }
    
    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}