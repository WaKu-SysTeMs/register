package login;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;

import javax.inject.Inject;

import javax.inject.Named;

@SuppressWarnings("serial")

@Named

@ViewScoped

public class TopBean implements Serializable {

    @Inject

    private AccountManager accountManager;

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

    @PostConstruct

    public void init() {

        this.user = this.accountManager.getUser();

        this.password = this.accountManager.getPassword();

    }

}