/*
 * 職業 JOB_LIST
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
@Entity
@Table(name = "job_list")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L; // シリアルバージョンUIDのバージョン管理

    @Id
    @NotNull
    @Size(max = 1)
    private String job_id;      // 職業ID

    @Size(max = 20)
    private String job_name;    // 職業名

    @OneToMany(mappedBy = "job_id", cascade = CascadeType.ALL)
    private List<Member> member;

    @Transient                  // シリアライズしない
    private boolean editable;

    /* コンストラクタ */
    public Job() {
    }

    public Job(String job_id, String job_name) {
        this.job_id = job_id;
        this.job_name = job_name;
    }

    /* セッター、ゲッター */
    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
