/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asanka
 */
@Entity
@Table(catalog = "forum", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reply.findAll", query = "SELECT r FROM Reply r"),
    @NamedQuery(name = "Reply.findByRId", query = "SELECT r FROM Reply r WHERE r.rId = :rId"),
    @NamedQuery(name = "Reply.findByReply", query = "SELECT r FROM Reply r WHERE r.reply = :reply"),
    @NamedQuery(name = "Reply.findByDate", query = "SELECT r FROM Reply r WHERE r.date = :date"),
    @NamedQuery(name = "Reply.findByTime", query = "SELECT r FROM Reply r WHERE r.time = :time")})
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "r_id", nullable = false, length = 10)
    private String rId;
    @Size(max = 100)
    @Column(length = 100)
    private String reply;
    @Size(max = 100)
    @Column(length = 100)
    private String date;
    @Size(max = 100)
    @Column(length = 100)
    private String time;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reply", fetch = FetchType.EAGER)
    private List<Replyvote> replyvoteList;
    @JoinColumn(name = "q_id", referencedColumnName = "q_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Question qId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User userId;

    public Reply() {
    }

    public Reply(String rId) {
        this.rId = rId;
    }

    public String getRId() {
        return rId;
    }

    public void setRId(String rId) {
        this.rId = rId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @XmlTransient
    public List<Replyvote> getReplyvoteList() {
        return replyvoteList;
    }

    public void setReplyvoteList(List<Replyvote> replyvoteList) {
        this.replyvoteList = replyvoteList;
    }

    public Question getQId() {
        return qId;
    }

    public void setQId(Question qId) {
        this.qId = qId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reply)) {
            return false;
        }
        Reply other = (Reply) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.adj.tf.dto.Reply[ rId=" + rId + " ]";
    }
    
}
