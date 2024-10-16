package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.constants.DatabaseConstants.ExerciseTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = ExerciseTypes.TABLE_NAME)
public class ExerciseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ExerciseTypes.COLUMN_ID, nullable = false)
    private Long id;

    @Column(name = ExerciseTypes.COLUMN_NAME, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "type")
    private Set<Exercise> exercises;


}
