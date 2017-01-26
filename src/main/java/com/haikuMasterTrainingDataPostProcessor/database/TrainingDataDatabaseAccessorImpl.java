package com.haikuMasterTrainingDataPostProcessor.database;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Oliver on 1/26/2017.
 */
public class TrainingDataDatabaseAccessorImpl implements TrainingDataDatabaseAccessor {

    private JdbcTemplate jdbcTemplate;

    public TrainingDataDatabaseAccessorImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
