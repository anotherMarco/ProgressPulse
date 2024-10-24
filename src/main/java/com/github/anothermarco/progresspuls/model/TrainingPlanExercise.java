package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.constants.DatabaseConstants.TrainingPlanExercises;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = TrainingPlanExercises.TABLE_NAME)
public class TrainingPlanExercise {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = TrainingPlanExercises.COLUMN_ID, nullable = false)
    private Long id;

    private AuditMetadata auditMetadata;

    @ManyToOne
    @JoinColumn(name = TrainingPlanExercises.JOIN_COLUMN_EXERCISE)
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = TrainingPlanExercises.JOIN_COLUMN_TRAINING_PLAN)
    private TrainingPlan trainingPlan;

    @Column(name = TrainingPlanExercises.COLUMN_ORDER)
    private int order;

    @OneToMany(mappedBy = "trainingPlanExercise", cascade = CascadeType.ALL)
    private List<SetDetail> sets;

    private int restPeriodAfterExercise;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingPlanExercise that = (TrainingPlanExercise) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "exercise = " + exercise + ", " +
                "trainingPlan = " + trainingPlan + ", " +
                "order = " + order + ", " +
                "restPeriodAfterExercise = " + restPeriodAfterExercise + ")";
    }
}
