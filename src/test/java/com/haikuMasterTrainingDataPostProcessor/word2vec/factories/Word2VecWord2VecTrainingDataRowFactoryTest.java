package com.haikuMasterTrainingDataPostProcessor.word2vec.factories;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecTrainingDataRow;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oliver.eder on 1/24/2017.
 */
public class Word2VecWord2VecTrainingDataRowFactoryTest {

    private Word2VecTrainingDataRowFactory word2VecTrainingDataRowFactory;

    @Before
    public void setup(){
        word2VecTrainingDataRowFactory = new Word2VecTrainingDataRowFactoryImpl();
    }

    @Test
    public void testCreate(){
        String trainingDataRowString = "dog#cat%0.98@puppy%0.97@man%0.92";
        Word2VecTrainingDataRow word2VecTrainingDataRow = word2VecTrainingDataRowFactory.create(trainingDataRowString);
        assertEquals("dog", word2VecTrainingDataRow.getKeyToken());
        assertEquals(3, word2VecTrainingDataRow.getWord2VecDataList().size());
        assertEquals("cat", word2VecTrainingDataRow.getWord2VecDataList().get(0).getToken());
        assertEquals(0.98, word2VecTrainingDataRow.getWord2VecDataList().get(0).getVector(), 0);
        assertEquals("puppy", word2VecTrainingDataRow.getWord2VecDataList().get(1).getToken());
        assertEquals(0.97, word2VecTrainingDataRow.getWord2VecDataList().get(1).getVector(), 0);
        assertEquals("man", word2VecTrainingDataRow.getWord2VecDataList().get(2).getToken());
        assertEquals(0.92, word2VecTrainingDataRow.getWord2VecDataList().get(2).getVector(), 0);
    }
}