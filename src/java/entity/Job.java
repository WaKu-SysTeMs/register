/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author s20163037
 */
@Entity
@Table(name = "JOB_LIST")
public class Job implements Serializable{
    
    private static final long serialVersionUID = 1L; // シリアライズ
    
    @Id @Column(name = "JOB_ID")
    private String jobId;      // 職業ID
    
    @Size(max = 20) @Column(name = "JOB_NAME")
    private String jobName;    // 職業名
    
    @OneToMany(mappedBy = "jobId", cascade = CascadeType.ALL)
    private List<Member> member;
    

    /* コンストラクタ */
    public Job() {
    }

    public Job(String jobId, String jobName) {
        this.jobId = jobId;
        this.jobName = jobName;
    }

    /* セッター、ゲッター */

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }
    


}
