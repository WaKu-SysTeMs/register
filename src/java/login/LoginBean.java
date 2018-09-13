package login;

import db.EmployeeDb;
import db.RegisterDb;
import entity.Employee;
import entity.Register;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
@SuppressWarnings("serial")
@Named
@ViewScoped
public class LoginBean implements Serializable {
    @Inject
    EmployeeDb employeeDb;
    @Inject
    RegisterDb registerDb;
    @Inject
    private AccountManager accountManager;
    private String user="";
    private String password="";
    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public String login() {
        Employee singleemp = this.employeeDb.loginemp(this.user);
        Register register = this.registerDb.loginid(this.password);
        
        if(singleemp!=null && register!=null){
            // ログイン成功した場合
            this.sessionUpdate();
            this.accountManager.setUser(singleemp.getEmp_name());
            this.accountManager.setPassword(this.password);
            return "/index.xhtml"; //?faces-redirect=true
        } else {
            // ログイン失敗した場合
           return null;
        }
    }

    
    // セッションハイジャック対策
    private void sessionUpdate() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ((HttpServletRequest)facesContext.getExternalContext().getRequest()).changeSessionId();
    }
  
}