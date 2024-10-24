package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.constants.DatabaseConstants.SetDetails;
import com.github.anothermarco.progresspuls.constants.DatabaseConstants.TrainingPlanExercises;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = SetDetails.TABLE_NAME)
public class SetDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = SetDetails.COLUMN_ID, nullable = false)
    private Long id;

    private AuditMetadata auditMetadata;

    @ManyToOne
    @JoinColumn(name = SetDetails.JOIN_COLUMN_TRAINING_PLAN_EXERCISE,
            referencedColumnName = TrainingPlanExercises.COLUMN_ID)
    private TrainingPlanExercise trainingPlanExercise;

    @Column(name = SetDetails.COLUMN_SET_NUMBER)
    private int setNumber;

    @Column(name = SetDetails.COLUMN_MIN_REPETITIONS)
    private int minRepetitions;

    @Column(name = SetDetails.COLUMN_MAX_REPETITIONS)
    private int maxRepetitions;

    @Column(name = SetDetails.COLUMN_WEIGHT)
    private double weight;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SetDetail setDetail = (SetDetail) o;
        return getId() != null && Objects.equals(getId(), setDetail.getId());
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
                "trainingPlanExercise = " + trainingPlanExercise + ", " +
                "setNumber = " + setNumber + ", " +
                "minRepetitions = " + minRepetitions + ", " +
                "maxRepetitions = " + maxRepetitions + ", " +
                "weight = " + weight + ")";
    }
}