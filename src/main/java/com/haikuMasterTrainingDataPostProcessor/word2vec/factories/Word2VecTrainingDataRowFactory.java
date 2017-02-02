package com.haikuMasterTrainingDataPostProcessor.word2vec.factories;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecTrainingDataRow;

/**
 * Created by oliver.eder on 1/24/2017.
 */
public interface Word2VecTrainingDataRowFactory {

    Word2VecTrainingDataRow create(String word2vecTrainingDataRowString);

}
