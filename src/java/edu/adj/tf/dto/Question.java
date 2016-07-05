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
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByQId", query = "SELECT q FROM Question q WHERE q.qId = :qId"),
    @NamedQuery(name = "Question.findByQuestion", query = "SELECT q FROM Question q WHERE q.question = :question"),
    @NamedQuery(name = "Question.findByDate", query = "SELECT q FROM Question q WHERE q.date = :date"),
    @NamedQuery(name = "Question.findByTime", query = "SELECT q FROM Question q WHERE q.time = :time")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "q_id", nullable = false, length = 10)
    private String qId;
    @Size(max = 100)
    @Column(length = 100)
    private String question;
    @Size(max = 100)
    @Column(length = 100)
    private String date;
    @Size(max = 100)
    @Column(length = 100)
    private String time;
    @ManyToMany(mappedBy = "questionList", fetch = FetchType.EAGER)
    private List<Category> categoryList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User userId;
    @OneToMany(mappedBy = "qId", fetch = FetchType.EAGER)
    private List<Reply> replyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", fetch = FetchType.EAGER)
    private List<Questionvote> questionvoteList;

    public Question() {
    }

    public Question(String qId) {
        this.qId = qId;
    }

    public String getQId() {
        return qId;
    }

    public void setQId(String qId) {
        this.qId = qId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    @XmlTransient
    public List<Questionvote> getQuestionvoteList() {
        return questionvoteList;
    }

    public void setQuestionvoteList(List<Questionvote> questionvoteList) {
        this.questionvoteList = questionvoteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qId != null ? qId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.qId == null && other.qId != null) || (this.qId != null && !this.qId.equals(other.qId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.adj.tf.dto.Question[ qId=" + qId + " ]";
    }
    
}
