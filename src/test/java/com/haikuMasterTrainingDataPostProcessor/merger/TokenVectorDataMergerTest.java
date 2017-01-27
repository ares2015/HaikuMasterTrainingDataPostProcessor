package com.haikuMasterTrainingDataPostProcessor.merger;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;
import com.haikuMasterTrainingDataPostProcessor.factories.TrainingDataRowFactory;
import com.haikuMasterTrainingDataPostProcessor.factories.TrainingDataRowFactoryImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 1/26/2017.
 */
public class TokenVectorDataMergerTest {

    private TrainingDataRowFactory trainingDataRowFactory = new TrainingDataRowFactoryImpl();

    private TokenVectorDataMerger tokenVectorDataMerger = new TokenVectorDataMergerImpl(trainingDataRowFactory);

    @Test
    public void test() throws IOException {
        Map<String, Map<String, TokenVectorData>> mergedData = tokenVectorDataMerger.merge();
        assertEquals(2, mergedData.size());
        assertEquals(1.95, mergedData.get("dog").get("cat").getVector(), 0);
        assertEquals(1.98, mergedData.get("dog").get("wolf").getVector(), 0);

    }
}
