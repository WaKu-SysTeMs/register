/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.RentalInfoDb;
import entity.RentalInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    RentalInfoDb rentalDb;
    
    @Inject
    transient Logger log;

    @Inject
    Conversation conv;
    
    private int x = 1;
    
    private List<RentalInfo> rental;
    
    private List <TestRental> test;
    {
        test = new ArrayList<>();x=1;
        test.add(new TestRental(x++,"究極の苺","旧作","01"));
        test.add(new TestRental(x++,"おいしいサンセバスチャンケーキのつくりかた","新作","-"));
    }
    
    private static Map<String, Integer> items;
    static {
        items = new LinkedHashMap<>();
        items.put("当日", 1);
        items.put("1泊2日", 2);
        items.put("2泊3日", 3);
        items.put("7泊8日", 4);
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

    public Map<String, Integer> getItems() {
        return items;
    }

    public static void setItems(Map<String, Integer> items) {
        RentalBean.items = items;
    }
    
    
    
}
