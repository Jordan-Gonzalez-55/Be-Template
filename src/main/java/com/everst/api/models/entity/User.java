package com.everst.api.models.entity;

import com.everst.api.enums.Gender;
import com.everst.api.enums.Hobbies;
import com.everst.api.enums.SexualOrientation;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column( name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column( name = "sex")
    @Enumerated(EnumType.STRING)
    private SexualOrientation sex;



    //@Builder.Default
    @ElementCollection(targetClass = Hobbies.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="user_hobbies")
    @Column( name = "hobbies")
    //@Type(type = "json")
    private Collection<Hobbies> hobbies;
    //public Hobbies hobbies;


    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;

    public User(Integer id, String firstName, String lastName, String email, Date createDate, Date modifyDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    @PrePersist
    private void beforePersist(){
        this.createDate = new Date();

    }

    @PreUpdate
    private void afterPersist(){
        this.modifyDate = new Date();

    }

    private static final long serialVersionUID = -2327342842041992057L;


}
