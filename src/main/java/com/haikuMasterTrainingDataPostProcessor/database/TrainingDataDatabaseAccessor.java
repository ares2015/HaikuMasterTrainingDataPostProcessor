package com.haikuMasterTrainingDataPostProcessor.database;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;

import java.util.List;

/**
 * Created by Oliver on 1/26/2017.
 */
public interface TrainingDataDatabaseAccessor {

    void clearDatabase();

    void insertTokenWord2VecData(String keyToken, List<TokenVectorData> tokenVectorDataList);

}
