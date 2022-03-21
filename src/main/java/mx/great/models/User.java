package mx.great.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@JsonAutoDetect (fieldVisibility = Visibility.ANY)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Integer id;

    @Column(name = "createAt")
    private Date createAt;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "updateAt")
    private Date updateAt;

   // @OneToMany(mappedBy = "user")
   // private Set<Message> messages = new LinkedHashSet<>();

    //@OneToMany(mappedBy = "user")
    //private Set<Chatuser> chatusers = new LinkedHashSet<>();

//    public Set<Chatuser> getChatusers() {
        //return chatusers;
   // }

  //  public void setChatusers(Set<Chatuser> chatusers) {
      //  this.chatusers = chatusers;
    //}

    //public Set<Message> getMessages() {
       // return messages;
    //}

    //public void setMessages(Set<Message> messages) {
      //  this.messages = messages;
    //}

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}