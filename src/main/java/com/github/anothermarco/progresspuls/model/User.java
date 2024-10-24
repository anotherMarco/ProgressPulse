package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.config.security.Permission;
import com.github.anothermarco.progresspuls.constants.DatabaseConstants.Roles;
import com.github.anothermarco.progresspuls.constants.DatabaseConstants.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = Users.TABLE_NAME)
public class User implements UserDetails {

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = Users.JOIN_COLUMN_ROLE, referencedColumnName = Roles.COLUMN_ID)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getPermissions().stream()
                .map(Permission::name)
                .map(SimpleGrantedAuthority::new)
                .toList();
    }


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