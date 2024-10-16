package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.constants.DatabaseConstants.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = Users.TABLE_NAME)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Users.COLUMN_ID, nullable = false)
    private Long id;

    private AuditMetadata auditMetadata;

    @Column(name = Users.COLUMN_USER_NAME, nullable = false, unique = true)
    private String username;

    @Column(name = Users.COLUMN_EMAIL, nullable = false, unique = true)
    private String email;

    @Column(name = Users.COLUMN_PASSWORD, nullable = false)
    private String password;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "auditMetadata = " + auditMetadata + ", " +
                "username = " + username + ", " +
                "email = " + email + ")";
    }
}