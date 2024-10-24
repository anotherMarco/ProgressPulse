package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.constants.DatabaseConstants;
import com.github.anothermarco.progresspuls.constants.DatabaseConstants.CompletedExercises;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = CompletedExercises.TABLE_NAME)
public class CompletedExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CompletedExercises.COLUMN_ID, nullable = false)
    private Long id;

    private AuditMetadata auditMetadata;

    @ManyToOne
    @JoinColumn(name = CompletedExercises.JOIN_COLUMN_TRAINING_PLAN_EXERCISE,
            referencedColumnName = DatabaseConstants.TrainingPlanExercises.COLUMN_ID)
    private TrainingPlanExercise trainingPlanExercise;

    @OneToMany(mappedBy = "completedExercise", cascade = CascadeType.ALL)
    private List<CompletedSet> completedSets;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CompletedExercise that = (CompletedExercise) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + "id = " + id + ", " + "trainingPlanExercise = " + trainingPlanExercise + ")";
    }
}