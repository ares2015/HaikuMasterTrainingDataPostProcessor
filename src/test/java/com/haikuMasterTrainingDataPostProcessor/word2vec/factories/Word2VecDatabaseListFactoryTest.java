package com.haikuMasterTrainingDataPostProcessor.word2vec.factories;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 1/27/2017.
 */
public class Word2VecDatabaseListFactoryTest {

    private Word2VecDatabaseListFactory word2VecDatabaseListFactory = new Word2VecDatabaseListFactoryImpl();

    @Test
    public void test(){
        Word2VecData word2VecData = new Word2VecData();
        word2VecData.setToken("dog");
        word2VecData.setVector(0.80);
        List<Word2VecData> word2VecDataList = new ArrayList<>();
        word2VecDataList.add(word2VecData);

        List<String> databaseList = word2VecDatabaseListFactory.create(word2VecDataList);
        assertEquals(20, databaseList.size());
        assertEquals("dog", databaseList.get(0));
        assertEquals("", databaseList.get(1));
        assertEquals("", databaseList.get(19));


    }
}
