package com.github.anothermarco.progresspuls.constants;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class DatabaseConstants {

    @NoArgsConstructor(access = PRIVATE)
    public static final class Audit {
        public static final String COLUMN_CREATED_BY = "created_by";
        public static final String COLUMN_LAST_MODIFIED_BY = "last_modified_by";
        public static final String COLUMN_CREATED_DATE = "created_date";
        public static final String COLUMN_LAST_MODIFIED_DATE = "last_modified_date";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class CompletedExercises {
        public static final String TABLE_NAME = "completed_exercises";
        public static final String COLUMN_ID = "id";
        public static final String JOIN_COLUMN_TRAINING_PLAN_EXERCISE = "training_plan_exercise_id";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class CompletedSets {
        public static final String TABLE_NAME = "completed_sets";
        public static final String COLUMN_ID = "id";
        public static final String JOIN_COLUMN_COMPLETED_EXERCISE = "completed_exercise_id";
        public static final String JOIN_COLUMN_COMPLETED_TRAINING_PLAN = "completed_training_plan_id";
        public static final String COLUMN_SET_NUMBER = "set_number";
        public static final String COLUMN_REPETITIONS = "repetitions";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String COLUMN_REST_BETWEEN_SETS = "rest_between_sets";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class CompletedTrainingPlans {
        public static final String TABLE_NAME = "completed_training_plans";
        public static final String COLUMN_ID = "ID";
        public static final String JOIN_COLUMN_TRAINING_PLAN = "training_plan_id";
        public static final String JOIN_COLUMN_USER = "user_id";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class Equipments {
        public static final String TABLE_NAME = "equipments";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class Exercises {
        public static final String TABLE_NAME = "exercises";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String JOIN_COLUMN_TYPE = "type_id";
        public static final String JOIN_TABLE_EQUIPMENTS = "exercises_equipments";
        public static final String JOIN_TABLE_EQUIPMENTS_COLUMN_EXERCISE = "exercise_id";
        public static final String JOIN_TABLE_EQUIPMENTS_COLUMN_EQUIPMENT = "equipment_id";
        public static final String COLUMN_DESCRIPTION = "description";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class ExerciseTypes {
        public static final String TABLE_NAME = "exercise_types";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class Roles {
        public static final String TABLE_NAME = "roles";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String JOIN_TABLE_ROLES_PERMISSIONS = "roles_permissions";
        public static final String JOIN_COLUM_ROLE = "role_id";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class SetDetails {
        public static final String TABLE_NAME = "set_details";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SET_NUMBER = "set_number";
        public static final String COLUMN_MIN_REPETITIONS = "min_repetitions";
        public static final String COLUMN_MAX_REPETITIONS = "max_repetitions";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String JOIN_COLUMN_TRAINING_PLAN_EXERCISE = "training_plan_exercise_id";
    }


    @NoArgsConstructor(access = PRIVATE)
    public static final class TrainingPlans {
        public static final String TABLE_NAME = "exercise_types";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static final class TrainingPlanExercises {
        public static final String TABLE_NAME = "training_plan_exercises";
        public static final String JOIN_COLUMN_EXERCISE = "exercise_id";
        public static final String JOIN_COLUMN_TRAINING_PLAN = "training_plan_id";
        public static final String COLUMN_ORDER = "'order'";
        public static final String COLUMN_ID = "id";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static class Users {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_DISPLAY_NAME = "display_name";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String JOIN_COLUMN_ROLE = "role_id";
    }
}
