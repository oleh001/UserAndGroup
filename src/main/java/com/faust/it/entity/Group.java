package com.faust.it.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.List;

// JPA
@Entity // relations with DB
@Table(catalog = "user_db")

// Lombok
//@EqualsAndHashCode(of = "idGroup") //ERROR
@Getter
@Setter

// Hibernate
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Group {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Id
    @Column(name = "id_group")
    private Long idGroup;

    @Column(name = "name_group")
    private String name;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "group")
    private List<User> users;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group = (Group) o;

        return idGroup.equals(group.idGroup);
    }

    @Override
    public int hashCode() {
        return idGroup.hashCode();
    }

}
