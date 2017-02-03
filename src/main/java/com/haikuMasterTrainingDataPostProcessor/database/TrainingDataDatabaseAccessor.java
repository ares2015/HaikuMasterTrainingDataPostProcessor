package com.haikuMasterTrainingDataPostProcessor.database;

import com.haikuMasterTrainingDataPostProcessor.data.TokenTagData;
import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;

import java.util.List;

/**
 * Created by Oliver on 1/26/2017.
 */
public interface TrainingDataDatabaseAccessor {

    void clearWord2VecDatabase();

    void clearTokenTagDataDatabase();

    void insertWord2VecData(String keyToken, List<Word2VecData> word2VecDataList);

    void insertTokenTagData(TokenTagData tokenTagData);

}
