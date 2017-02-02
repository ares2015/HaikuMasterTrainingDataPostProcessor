package com.haikuMasterTrainingDataPostProcessor.word2vec.sorter;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;
import com.haikuMasterTrainingDataPostProcessor.word2vec.factories.Word2VecTrainingDataRowFactory;
import com.haikuMasterTrainingDataPostProcessor.word2vec.factories.Word2VecTrainingDataRowFactoryImpl;
import com.haikuMasterTrainingDataPostProcessor.word2vec.merger.Word2VecDataMerger;
import com.haikuMasterTrainingDataPostProcessor.word2vec.merger.Word2VecDataMergerImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 1/26/2017.
 */
public class Word2VecDataSorterTest {

    private Word2VecTrainingDataRowFactory word2VecTrainingDataRowFactory = new Word2VecTrainingDataRowFactoryImpl();

    private Word2VecDataMerger word2VecDataMerger = new Word2VecDataMergerImpl(word2VecTrainingDataRowFactory);

    private Word2VecDataSorter word2VecDataSorter = new Word2VecDataSorterImpl();

    /*
    dog#cat%0.98@puppy%0.90
    dog#wolf%0.99@cat%0.97@man%0.82
    dog#wolf%0.99
    eagle#bird%0.95@animal%0.90
     */
    @Test
    public void testSort() throws IOException {
        Map<String, Map<String, Word2VecData>> mergedData = word2VecDataMerger.merge();
        Map<String, List<Word2VecData>> sortedData = word2VecDataSorter.sort(mergedData);
        assertEquals(2, sortedData.size());
        List<Word2VecData> dogVectors = sortedData.get("dog");
        for (Word2VecData word2VecData : dogVectors) {
            System.out.println("dog -> " + word2VecData.getToken() + " " + word2VecData.getVector());
        }
        List<Word2VecData> eagleVectors = sortedData.get("eagle");
        for (Word2VecData word2VecData : eagleVectors) {
            System.out.println("wolf -> " + word2VecData.getToken() + " " + word2VecData.getVector());
        }
    }
}