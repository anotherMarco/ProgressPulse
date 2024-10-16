package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.constants.DatabaseConstants.Equipments;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = Equipments.TABLE_NAME)
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Equipments.COLUMN_ID, nullable = false)
    private Long id;

    @Column(name = Equipments.COLUMN_NAME, nullable = false, unique = true)
    private String name;


    @ManyToMany(mappedBy = "equipments")
    private Collection<Exercise> exercises;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Equipment equipment = (Equipment) o;
        return getId() != null && Objects.equals(getId(), equipment.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ")";
    }
}
