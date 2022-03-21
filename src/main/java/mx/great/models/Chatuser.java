package mx.great.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "chatuser", indexes = {
        @Index(name = "fk_chatuser_idUser_idx", columnList = "userId")
})
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Chatuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idchatUser", nullable = false)

    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chatId", nullable = false)
    private Chat chat;



    public Chatuser() {
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Chatuser{" +
                "id:" + id +
                ", user:" + user +
                ", chat:" + chat +
                '}';
    }
}