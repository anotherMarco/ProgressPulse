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
    public static class Users {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USER_NAME = "user_name";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
    }
}
