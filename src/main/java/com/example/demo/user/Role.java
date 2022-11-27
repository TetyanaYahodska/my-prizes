package com.example.demo.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "role")
@NoArgsConstructor
@EqualsAndHashCode(of = "role")
public class Role implements GrantedAuthority {
    public static final String ROLE_USER = "user";
    public static final String ROLE_ADMIN = "admin";
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column (name = "role", length = 25, nullable = false, unique = true)
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}



