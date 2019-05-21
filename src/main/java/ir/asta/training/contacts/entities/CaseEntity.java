package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CaseEntity")
public class CaseEntity implements Serializable {
    String sender;
    String receiver;
    String description;
    String title;
    String date;
    String condition;
    String satisfied;
    String paraf;

    @Id
    @Basic
    @Column(name="SENDER_")
    public String getsender() {
        return sender;
    }
    public void setsender(String sender) {
        this.sender = sender;
    }

    @Id
    @Basic
    @Column(name="RECEIVER_")
    public String getreceiver() {
        return receiver;
    }
    public void setreceiver(String receiver) {
        this.receiver = receiver;
    }

    @Basic
    @Column(name="DESCRIPTION_")
    public String getdescription() {
        return description;
    }
    public void setdescription(String description) {
        this.description = description;
    }

    @Id
    @Basic
    @Column(name="TITLE_")
    public String gettitle() {
        return title;
    }
    public void settitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name="DATE_")
    public String getdate() {
        return date;
    }
    public void setdate(String date) {
        this.date = date;
    }

    @Id
    @Basic
    @Column(name="CONDITION_")
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name="SATISFIED_")
    public String getSatisfied() {
        return satisfied;
    }
    public void setSatisfied(String satisfied) {
        this.satisfied = satisfied;
    }


    @Basic
    @Column(name="PARAF_")
    public String getParaf() {
        return paraf;
    }
    public void setParaf(String paraf) {
        this.paraf = paraf;
    }

}
