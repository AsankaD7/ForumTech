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
    @NamedQuery(name = "Questionvote.findAll", query = "SELECT q FROM Questionvote q"),
    @NamedQuery(name = "Questionvote.findByUserId", query = "SELECT q FROM Questionvote q WHERE q.questionvotePK.userId = :userId"),
    @NamedQuery(name = "Questionvote.findByQId", query = "SELECT q FROM Questionvote q WHERE q.questionvotePK.qId = :qId"),
    @NamedQuery(name = "Questionvote.findByVote", query = "SELECT q FROM Questionvote q WHERE q.vote = :vote")})
public class Questionvote implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuestionvotePK questionvotePK;
    @Size(max = 100)
    @Column(length = 100)
    private String vote;
    @JoinColumn(name = "q_id", referencedColumnName = "q_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Question question;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    public Questionvote() {
    }

    public Questionvote(QuestionvotePK questionvotePK) {
        this.questionvotePK = questionvotePK;
    }

    public Questionvote(String userId, String qId) {
        this.questionvotePK = new QuestionvotePK(userId, qId);
    }

    public QuestionvotePK getQuestionvotePK() {
        return questionvotePK;
    }

    public void setQuestionvotePK(QuestionvotePK questionvotePK) {
        this.questionvotePK = questionvotePK;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
        hash += (questionvotePK != null ? questionvotePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionvote)) {
            return false;
        }
        Questionvote other = (Questionvote) object;
        if ((this.questionvotePK == null && other.questionvotePK != null) || (this.questionvotePK != null && !this.questionvotePK.equals(other.questionvotePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.adj.tf.dto.Questionvote[ questionvotePK=" + questionvotePK + " ]";
    }
    
}
