package bean;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@ViewScoped
public class Login implements Serializable {
    @Inject
    private LoginBean login;

    public void login(String empName, String regiNum) {

        // セッション id を変更
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        request.changeSessionId();

        login.setEmpName(empName);
        login.setRegiNum(regiNum);
        login.setAuthenticated(true);
        
        
    }

    public void logout() {
        this.login.logout();
    }     
    
}