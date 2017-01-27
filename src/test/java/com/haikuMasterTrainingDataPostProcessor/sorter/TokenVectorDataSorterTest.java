package com.haikuMasterTrainingDataPostProcessor.sorter;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;
import com.haikuMasterTrainingDataPostProcessor.factories.TrainingDataRowFactory;
import com.haikuMasterTrainingDataPostProcessor.factories.TrainingDataRowFactoryImpl;
import com.haikuMasterTrainingDataPostProcessor.merger.TokenVectorDataMerger;
import com.haikuMasterTrainingDataPostProcessor.merger.TokenVectorDataMergerImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 1/26/2017.
 */
public class TokenVectorDataSorterTest {

    private TrainingDataRowFactory trainingDataRowFactory = new TrainingDataRowFactoryImpl();

    private TokenVectorDataMerger tokenVectorDataMerger = new TokenVectorDataMergerImpl(trainingDataRowFactory);

    private TokenVectorDataSorter tokenVectorDataSorter = new TokenVectorDataSorterImpl();

    /*
    dog#cat%0.98@puppy%0.90
    dog#wolf%0.99@cat%0.97@man%0.82
    dog#wolf%0.99
    eagle#bird%0.95@animal%0.90
     */
    @Test
    public void testSort() throws IOException {
        Map<String, Map<String, TokenVectorData>> mergedData = tokenVectorDataMerger.merge();
        Map<String, List<TokenVectorData>> sortedData = tokenVectorDataSorter.sort(mergedData);
        assertEquals(2, sortedData.size());
        List<TokenVectorData> dogVectors = sortedData.get("dog");
        for (TokenVectorData tokenVectorData : dogVectors) {
            System.out.println("dog -> " + tokenVectorData.getToken() + " " + tokenVectorData.getVector());
        }
        List<TokenVectorData> eagleVectors = sortedData.get("eagle");
        for (TokenVectorData tokenVectorData : eagleVectors) {
            System.out.println("wolf -> " + tokenVectorData.getToken() + " " + tokenVectorData.getVector());
        }
    }
}