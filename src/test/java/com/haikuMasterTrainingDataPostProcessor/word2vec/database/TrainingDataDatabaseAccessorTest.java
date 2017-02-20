package com.haikuMasterTrainingDataPostProcessor.word2vec.database;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;
import com.haikuMasterTrainingDataPostProcessor.database.TrainingDataDatabaseAccessor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliver on 2/20/2017.
 */
public class TrainingDataDatabaseAccessorTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TrainingDataDatabaseAccessor trainingDataDatabaseAccessor = (TrainingDataDatabaseAccessor) context.getBean("trainingDataDatabaseAccessor");

        List<Word2VecData> word2vecList = new ArrayList<Word2VecData>();
        for (int i = 1; i <= 309; i++) {
            Word2VecData word2VecData = new Word2VecData();
            word2VecData.setToken("test");
            word2VecData.setVector(10.0);
            word2vecList.add(word2VecData);
        }
        trainingDataDatabaseAccessor.insertWord2VecData("test", word2vecList);
    }
}
