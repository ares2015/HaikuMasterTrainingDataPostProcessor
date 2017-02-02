package com.haikuMasterTrainingDataPostProcessor.word2vec.merger;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Oliver on 1/26/2017.
 */
public interface Word2VecDataMerger {

    Map<String, Map<String, Word2VecData>> merge() throws IOException;
}
