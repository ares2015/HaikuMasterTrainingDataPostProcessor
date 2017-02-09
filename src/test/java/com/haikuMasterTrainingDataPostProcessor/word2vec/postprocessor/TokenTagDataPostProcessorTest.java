package com.haikuMasterTrainingDataPostProcessor.word2vec.postprocessor;

import com.haikuMasterTrainingDataPostProcessor.database.TrainingDataDatabaseAccessor;
import com.haikuMasterTrainingDataPostProcessor.tags.merger.TokenTagDataMerger;
import com.haikuMasterTrainingDataPostProcessor.tags.postprocessor.TokenTagDataPostProcessor;
import com.haikuMasterTrainingDataPostProcessor.tags.postprocessor.TokenTagDataPostProcessorImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Oliver on 2/9/2017.
 */
public class TokenTagDataPostProcessorTest {

    private TokenTagDataPostProcessor tokenTagDataPostProcessor;

    @Before
    public void setup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TokenTagDataMerger tokenTagDataMerger = (TokenTagDataMerger) context.getBean("tokenTagDataMerger");
        TrainingDataDatabaseAccessor trainingDataDatabaseAccessor = (TrainingDataDatabaseAccessor) context.getBean("trainingDataDatabaseAccessor");
        tokenTagDataPostProcessor = new TokenTagDataPostProcessorImpl(tokenTagDataMerger, trainingDataDatabaseAccessor);
    }

    @Test
    public void test() throws IOException {
        tokenTagDataPostProcessor.postProcess();
    }
}
