package dev.ifrs.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class User extends PanacheEntity {
    
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Message> messages;

    //Constructor
    public User(){
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

}
