package com.haikuMasterTrainingDataPostProcessor.factories;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 1/27/2017.
 */
public class DatabaseListFactoryTest {

    private DatabaseListFactory databaseListFactory = new DatabaseListFactoryImpl();

    @Test
    public void test(){
        TokenVectorData tokenVectorData = new TokenVectorData();
        tokenVectorData.setToken("dog");
        tokenVectorData.setVector(0.80);
        List<TokenVectorData> tokenVectorDataList = new ArrayList<>();
        tokenVectorDataList.add(tokenVectorData);

        List<String> databaseList = databaseListFactory.create(tokenVectorDataList);
        assertEquals(20, databaseList.size());
        assertEquals("dog", databaseList.get(0));
        assertEquals("", databaseList.get(1));
        assertEquals("", databaseList.get(19));


    }
}
