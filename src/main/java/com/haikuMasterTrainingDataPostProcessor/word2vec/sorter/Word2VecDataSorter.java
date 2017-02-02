package com.haikuMasterTrainingDataPostProcessor.word2vec.sorter;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;

import java.util.List;
import java.util.Map;

/**
 * Created by Oliver on 1/26/2017.
 */
public interface Word2VecDataSorter {

    Map<String, List<Word2VecData>> sort(Map<String, Map<String, Word2VecData>> mergedData);

}
