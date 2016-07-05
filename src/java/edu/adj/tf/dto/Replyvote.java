/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.adj.tf.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asanka
 */
@Entity
@Table(catalog = "forum", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Replyvote.findAll", query = "SELECT r FROM Replyvote r"),
    @NamedQuery(name = "Replyvote.findByUserId", query = "SELECT r FROM Replyvote r WHERE r.replyvotePK.userId = :userId"),
    @NamedQuery(name = "Replyvote.findByRId", query = "SELECT r FROM Replyvote r WHERE r.replyvotePK.rId = :rId"),
    @NamedQuery(name = "Replyvote.findByVote", query = "SELECT r FROM Replyvote r WHERE r.vote = :vote")})
public class Replyvote implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReplyvotePK replyvotePK;
    @Size(max = 100)
    @Column(length = 100)
    private String vote;
    @JoinColumn(name = "r_id", referencedColumnName = "r_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Reply reply;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    public Replyvote() {
    }

    public Replyvote(ReplyvotePK replyvotePK) {
        this.replyvotePK = replyvotePK;
    }

    public Replyvote(String userId, String rId) {
        this.replyvotePK = new ReplyvotePK(userId, rId);
    }

    public ReplyvotePK getReplyvotePK() {
        return replyvotePK;
    }

    public void setReplyvotePK(ReplyvotePK replyvotePK) {
        this.replyvotePK = replyvotePK;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (replyvotePK != null ? replyvotePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Replyvote)) {
            return false;
        }
        Replyvote other = (Replyvote) object;
        if ((this.replyvotePK == null && other.replyvotePK != null) || (this.replyvotePK != null && !this.replyvotePK.equals(other.replyvotePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.adj.tf.dto.Replyvote[ replyvotePK=" + replyvotePK + " ]";
    }
    
}
