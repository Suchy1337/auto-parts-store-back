package pl.suchan.models;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String mailAddress;
}
