package login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

@SuppressWarnings("serial")

@Named

@SessionScoped

public class AccountManager implements Serializable {

    private String user;

    private String password;

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

    public boolean isLogin() {

        boolean result = false;

        if(this.user != null) {

            result = true;

        }

        return result;

    }

}