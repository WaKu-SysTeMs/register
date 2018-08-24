/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.RentalDb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;

/**
 *
 * @author s20163037
 */
@Named
@ConversationScoped
public class RentalBean implements Serializable {


    @EJB
    RentalDb rentalDb;
    
    @Inject
    transient Logger log;

    @Inject
    Conversation conv;
    
    private int x = 1;
    
    private List <TestRental> test;
    {
        test = new ArrayList<>();x=1;
        test.add(new TestRental(x++,"クソ松くん","旧作","01"));
        test.add(new TestRental(x++,"クソ松さん","新作","-"));
    }

    @PostConstruct
    public void start() {
        if (!conv.isTransient()) {
            log.info(log.getName() + "| 会話スコープ終了");
            conv.end();
        }
    }

    public String create() {
        log.info(log.getName() + "| 貸出情報登録画面");
        if (conv.isTransient()) {
            conv.begin();
        }
        return "/pages/rental/create.xhtml";
    }

    public List<TestRental> getTest() {
        return test;
    }

    public void setTest(List<TestRental> test) {
        this.test = test;
    }
    
    
}
