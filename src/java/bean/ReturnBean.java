/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.sun.faces.application.annotation.ConfigAnnotationHandler;
import db.ReturnDb;
import entity.Return;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author s20163060
 */
@Named
@RequestScoped
public class ReturnBean implements Serializable{
    
    @EJB
    ReturnDb returnDb;
    @Inject
    transient Logger log;
    
    @Inject
    Conversation conv;
    
    @PostConstruct
    public void start(){
        if(!conv.isTransient()){
            log.info(log.getName() + "￤ 会話スコープ終了");
            conv.end();
        }
    }
    
    private List<Return> test;
    {
        test = new ArrayList<>();
        test.add(new Return("1234567890","2018/07/19","2018/07/20",0));
        test.add(new Return("2345678901","2018/07/20","2018/07/20",0));
        test.add(new Return("0987654321","2013/02/029","2013/03/01",300000));
    }

    public ReturnDb getReturnDb() {
        return returnDb;
    }

    public void setReturnDb(ReturnDb returnDb) {
        this.returnDb = returnDb;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public Conversation getConv() {
        return conv;
    }

    public void setConv(Conversation conv) {
        this.conv = conv;
    }

    public List<Return> getTest() {
        return test;
    }

    public void setTest(List<Return> test) {
        this.test = test;
    }

}
