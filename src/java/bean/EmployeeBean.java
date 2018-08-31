/*
 * レジ処理　Bean
 */
package bean;

import db.EmployeeDb;
import db.RegisterDb;
import entity.Employee;
import entity.Register;
import entity.RoleInfo;
import entity.StoreInfo;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.*;


/**
 *
 * @author s20163037
 */
@Named
@SessionScoped
public class EmployeeBean implements Serializable {

    @PersistenceContext
    EntityManager em;

    @Inject
    transient Logger log;

    @Inject
    Conversation conv;

    @EJB
    EmployeeDb employeeDb;

    @Size(max = 8)
    private Integer emp_num;            // 社員番号

    @Size(max = 30)
    private String emp_name;            // 社員名

    @Size(max = 1)                   // もしくは@patternで
    @NotNull
    private RoleInfo role_id;               // ロールID(FK)

    @Size(max = 20)
    private String passwd;              // パスワード

    @NotNull
    @Size(max = 3)
    private StoreInfo store_id;             // 勤務地(FK：店舗ID)

    public String search() {                                // 社員名　取得
        Employee m = (Employee) employeeDb.search(20163037);
        if (m != null) {
            this.emp_name = m.getEmp_name();
        }
        return this.emp_name;
    }

}
