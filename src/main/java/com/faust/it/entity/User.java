package com.faust.it.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;


// JPA
@Entity // relations with DB
@Table(catalog = "user_db")

// Lombok
@EqualsAndHashCode(of = "idUser")
@Getter
@Setter

// Hibernate
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Id
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "user_name")
    private String nickName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String password;

    @Column(name = "date_of_birth")
    private Date birthDay;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private Group group;

    @Override
    public String toString() {
        return nickName;
    }
}
