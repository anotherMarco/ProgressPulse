package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.constants.DatabaseConstants.Equipments;
import com.github.anothermarco.progresspuls.constants.DatabaseConstants.Exercises;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static com.github.anothermarco.progresspuls.constants.DatabaseConstants.ExerciseTypes.COLUMN_ID;

@Getter
@Setter
@Entity
@Table(name = Exercises.TABLE_NAME)
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Exercises.COLUMN_ID, nullable = false)
    private Long id;

    private AuditMetadata auditMetadata;

    @Column(name = Exercises.COLUMN_NAME, nullable = false, unique = true)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = Exercises.JOIN_COLUMN_TYPE, referencedColumnName = COLUMN_ID, nullable = false, unique = true)
    private ExerciseType type;

    @ManyToMany
    @JoinTable(name = Exercises.JOIN_TABLE_EQUIPMENTS,
            joinColumns = @JoinColumn(name = Exercises.JOIN_TABLE_EQUIPMENTS_COLUMN_EXERCISE,
                    referencedColumnName = Exercises.COLUMN_ID),
            inverseJoinColumns = @JoinColumn(name = Exercises.JOIN_TABLE_EQUIPMENTS_COLUMN_EQUIPMENT,
                    referencedColumnName = Equipments.COLUMN_ID))
    private Set<Equipment> equipments = new LinkedHashSet<>();

    @Column(name = Exercises.COLUMN_DESCRIPTION)
    private String description;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Exercise exercise = (Exercise) o;
        return getId() != null && Objects.equals(getId(), exercise.getId());
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
                "name = " + name + ", " +
                "type = " + type + ")";
    }
}
