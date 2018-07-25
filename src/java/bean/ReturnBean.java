/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import db.ReturnDb;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
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
    
    @PostConstruct
    public void start(){
        if(!conv.isTransient()){
            log.info(log.getName() + "￤ 会話スコープ終了");
            conv.end();
        }
    }

}
