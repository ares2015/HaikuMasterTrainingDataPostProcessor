package com.haikuMasterTrainingDataPostProcessor.word2vec.factories;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;

import java.util.List;

/**
 * Created by Oliver on 1/27/2017.
 */
public interface Word2VecDatabaseListFactory {

    List<String> create(List<Word2VecData> word2VecDatabaseList);

}
