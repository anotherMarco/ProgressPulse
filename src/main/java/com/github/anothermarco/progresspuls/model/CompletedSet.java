package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.constants.DatabaseConstants.CompletedExercises;
import com.github.anothermarco.progresspuls.constants.DatabaseConstants.CompletedSets;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = CompletedSets.TABLE_NAME)
public class CompletedSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CompletedSets.COLUMN_ID, nullable = false)
    private Long id;

    private AuditMetadata auditMetadata;

    @ManyToOne
    @JoinColumn(name = CompletedSets.JOIN_COLUMN_COMPLETED_EXERCISE,
            referencedColumnName = CompletedExercises.COLUMN_ID)
    private CompletedExercise completedExercise;

    @Column(name = CompletedSets.COLUMN_SET_NUMBER)
    private int setNumber;

    @Column(name = CompletedSets.COLUMN_REPETITIONS)
    private int repetitions;

    @Column(name = CompletedSets.COLUMN_WEIGHT)
    private double weight;

    @Column(name = CompletedSets.COLUMN_REST_BETWEEN_SETS)
    private int restPeriodBetweenSets;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CompletedSet that = (CompletedSet) o;
        return getId() != null && Objects.equals(getId(), that.getId());
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
                "completedExercise = " + completedExercise + ", " +
                "setNumber = " + setNumber + ", " +
                "repetitions = " + repetitions + ", " +
                "weight = " + weight + ", " +
                "restPeriodBetweenSets = " + restPeriodBetweenSets + ")";
    }
}