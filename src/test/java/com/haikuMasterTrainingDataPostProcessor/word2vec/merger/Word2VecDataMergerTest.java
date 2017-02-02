package com.haikuMasterTrainingDataPostProcessor.word2vec.merger;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;
import com.haikuMasterTrainingDataPostProcessor.word2vec.factories.Word2VecTrainingDataRowFactory;
import com.haikuMasterTrainingDataPostProcessor.word2vec.factories.Word2VecTrainingDataRowFactoryImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Oliver on 1/26/2017.
 */
public class Word2VecDataMergerTest {

    private Word2VecTrainingDataRowFactory word2VecTrainingDataRowFactory = new Word2VecTrainingDataRowFactoryImpl();

    private Word2VecDataMerger word2VecDataMerger = new Word2VecDataMergerImpl(word2VecTrainingDataRowFactory);

    @Test
    public void test() throws IOException {
        Map<String, Map<String, Word2VecData>> mergedData = word2VecDataMerger.merge();
//        assertEquals(2, mergedData.size());
//        assertEquals(1.95, mergedData.get("dog").get("cat").getVector(), 0);
//        assertEquals(1.98, mergedData.get("dog").get("wolf").getVector(), 0);

    }
}
