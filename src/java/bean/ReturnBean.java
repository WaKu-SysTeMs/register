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
    
    private int x = 1;
    
    private List <Test> test;
    {
        test = new ArrayList<>();x=1;
        test.add(new Test(x++,"苔大全","2018/07/31","2018/08/01",300));
        test.add(new Test(x++,"本当にあった祝いのビデオ～episode2194～","2018/07/31","2018/08/02",0));
    }
    
    private List <Test2> test2;
    {
        test2 = new ArrayList<>();x=1;
        test2.add(new Test2(x++,"絶望を与える守備集～倉本前安打～","菊水店","2018/07/30","2018/07/31",600));
        test2.add(new Test2(x++,"本当にあったような怖い話","旭川店","2018/07/31","2018/08/01",300));
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

    public List<Test2> getTest2() {
        return test2;
    }

    public void setTest2(List<Test2> test2) {
        this.test2 = test2;
    }
    
    

}
