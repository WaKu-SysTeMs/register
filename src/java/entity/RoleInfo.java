/*
 * ロール情報 ROLE_INFO
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 *
 * @author s20163037
 */
//@NamedQueries({
//    @NamedQuery(name = RoleInfo.Qall, query = "SELECT e FROM ROLE_INFO e")
//})
@Entity
@Table(name = "role_info")
public class RoleInfo implements Serializable {
    
    public static final String Qall = "Qall";

    private static final long serialVersionUID = 1L;  // シリアルバージョンUIDのバージョン管理

    @Id
    @Size(max = 1)
    @Column(length = 1)
    private String role_id;         // ロールID

    @Size(max = 7)
    @Column(length = 7)
    private String role_name;       // 役職

    @OneToMany(mappedBy = "role_id", cascade = CascadeType.ALL)
    private List<Employee> employee;

    @Transient                           // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public RoleInfo() {
    }

    public RoleInfo(String role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    /* ゲッター、セッター */
    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
