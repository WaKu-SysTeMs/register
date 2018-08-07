/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.ReturnDb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 
 *
 * @author s20163060
 */
@Named
@ConversationScoped
public class ReturnBean implements Serializable{
    
    @EJB
    ReturnDb returnDb;
    @Inject
    transient Logger log;
    
    @Inject
    Conversation conv;
    
    private List <Test> test;
    {
        test = new ArrayList<>();
        test.add(new Test(1,"test1","test2","test3",300));
        test.add(new Test(2,"test4","test5","test6",600));
        test.add(new Test(3,"test7","test8","test9",900));
    }
    
    
    
    @PostConstruct
    public void start(){
        if(!conv.isTransient()){
            log.info(log.getName() + "￤ 会話スコープ終了");
            conv.end();
        }
    }
    
    public String create() {
        log.info(log.getName() + "| 返却情報変更画面");
        if (conv.isTransient()) {
            conv.begin();
        }
        return "/pages/returnl/update.xhtml";
    }

    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }
    
    

}
