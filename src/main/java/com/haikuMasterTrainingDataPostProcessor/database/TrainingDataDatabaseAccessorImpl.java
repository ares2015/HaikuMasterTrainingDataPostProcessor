package com.haikuMasterTrainingDataPostProcessor.database;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;
import com.haikuMasterTrainingDataPostProcessor.factories.DatabaseListFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Oliver on 1/26/2017.
 */
public class TrainingDataDatabaseAccessorImpl implements TrainingDataDatabaseAccessor {

    private JdbcTemplate jdbcTemplate;

    private DatabaseListFactory databaseListFactory;

    public TrainingDataDatabaseAccessorImpl(final JdbcTemplate jdbcTemplate, DatabaseListFactory databaseListFactory) {
        this.jdbcTemplate = jdbcTemplate;
        this.databaseListFactory = databaseListFactory;
    }

    @Override
    public void insertTokenWord2VecData(String keyToken, List<TokenVectorData> tokenVectorDataList) {
        List<String> databaseList = databaseListFactory.create(tokenVectorDataList);
    }
}
