package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.constants.DatabaseConstants.CompletedTrainingPlans;
import com.github.anothermarco.progresspuls.constants.DatabaseConstants.TrainingPlans;
import com.github.anothermarco.progresspuls.constants.DatabaseConstants.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = CompletedTrainingPlans.TABLE_NAME)
public class CompletedTrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CompletedTrainingPlans.COLUMN_ID, nullable = false)
    private Long id;

    private AuditMetadata auditMetadata;

    @ManyToOne
    @JoinColumn(name = CompletedTrainingPlans.JOIN_COLUMN_TRAINING_PLAN, referencedColumnName = TrainingPlans.COLUMN_ID)
    private TrainingPlan trainingPlan;

    @Column(name = CompletedTrainingPlans.COLUMN_DATE)
    private LocalDate date;

    @Column(name = CompletedTrainingPlans.COLUMN_TIME)
    private LocalTime time;


    @ManyToOne
    @JoinColumn(name = CompletedTrainingPlans.JOIN_COLUMN_USER, referencedColumnName = Users.COLUMN_ID)
    private User user;

    @OneToMany(mappedBy = "completedTrainingPlan", orphanRemoval = true)
    private Set<CompletedSet> completedSets = new LinkedHashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CompletedTrainingPlan that = (CompletedTrainingPlan) o;
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
                "trainingPlan = " + trainingPlan + ", " +
                "date = " + date + ", " +
                "time = " + time + ", " +
                "user = " + user + ")";
    }
}