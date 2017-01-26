package com.haikuMasterTrainingDataPostProcessor.factory;

import com.haikuMasterTrainingDataPostProcessor.TrainingDataRowFactory;
import com.haikuMasterTrainingDataPostProcessor.TrainingDataRowFactoryImpl;
import com.haikuMasterTrainingDataPostProcessor.data.TrainingDataRow;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oliver.eder on 1/24/2017.
 */
public class TrainingDataRowFactoryTest {

    private TrainingDataRowFactory trainingDataRowFactory;

    @Before
    public void setup(){
        trainingDataRowFactory = new TrainingDataRowFactoryImpl();
    }

    @Test
    public void testCreate(){
        String trainingDataRowString = "dog#cat%0.98@puppy%0.97@man%0.92";
        TrainingDataRow trainingDataRow = trainingDataRowFactory.create(trainingDataRowString);
        assertEquals("dog", trainingDataRow.getKeyToken());
        assertEquals(3, trainingDataRow.getTokenVectorDataList().size());
        assertEquals("cat", trainingDataRow.getTokenVectorDataList().get(0).getToken());
        assertEquals(0.98, trainingDataRow.getTokenVectorDataList().get(0).getVector(), 0);
        assertEquals("puppy", trainingDataRow.getTokenVectorDataList().get(1).getToken());
        assertEquals(0.97, trainingDataRow.getTokenVectorDataList().get(1).getVector(), 0);
        assertEquals("man", trainingDataRow.getTokenVectorDataList().get(2).getToken());
        assertEquals(0.92, trainingDataRow.getTokenVectorDataList().get(2).getVector(), 0);
    }
}