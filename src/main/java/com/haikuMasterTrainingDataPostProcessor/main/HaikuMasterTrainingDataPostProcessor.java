package com.haikuMasterTrainingDataPostProcessor.main;

import com.haikuMasterTrainingDataPostProcessor.database.TrainingDataDatabaseAccessor;
import com.haikuMasterTrainingDataPostProcessor.tags.merger.TokenTagDataMerger;
import com.haikuMasterTrainingDataPostProcessor.tags.postprocessor.TokenTagDataPostProcessorImpl;
import com.haikuMasterTrainingDataPostProcessor.word2vec.merger.Word2VecDataMerger;
import com.haikuMasterTrainingDataPostProcessor.word2vec.postprocessor.Word2VecDataPostProcessorImpl;
import com.haikuMasterTrainingDataPostProcessor.word2vec.sorter.Word2VecDataSorter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Oliver on 1/26/2017.
 */
public class HaikuMasterTrainingDataPostProcessor {


    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        TrainingDataDatabaseAccessor trainingDataDatabaseAccessor = (TrainingDataDatabaseAccessor) context.getBean("trainingDataDatabaseAccessor");
        Word2VecDataMerger word2VecDataMerger = (Word2VecDataMerger) context.getBean("word2vecMerger");
        Word2VecDataSorter word2vecSorter = (Word2VecDataSorter) context.getBean("word2vecSorter");

        TokenTagDataMerger tokenTagDataMerger = (TokenTagDataMerger) context.getBean("tokenTagDataMerger");

        boolean areDataProcessed = false;

        ExecutorService executor = Executors.newFixedThreadPool(2);
        long startTime = System.currentTimeMillis();

        Runnable word2VecDataPostProcessor = new Word2VecDataPostProcessorImpl(word2VecDataMerger, word2vecSorter, trainingDataDatabaseAccessor);
        Future<?> word2vecFuture = executor.submit(word2VecDataPostProcessor);

        Runnable tokenTagDataPostProcessor = new TokenTagDataPostProcessorImpl(tokenTagDataMerger, trainingDataDatabaseAccessor);
        Future<?> tokenTagDataFuture = executor.submit(tokenTagDataPostProcessor);

        while (!areDataProcessed) {
            areDataProcessed = word2vecFuture.isDone() && tokenTagDataFuture.isDone();
        }

        if (areDataProcessed) {
            executor.shutdown();
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Training data processed in " + elapsedTime / 1000 + " seconds / in " + (elapsedTime / 1000) / 60 +
                    +(elapsedTime / 1000) % 60 + " seconds");
        }
    }

}