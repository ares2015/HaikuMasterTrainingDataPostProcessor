package com.haikuMasterTrainingDataPostProcessor.main;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;
import com.haikuMasterTrainingDataPostProcessor.database.TrainingDataDatabaseAccessor;
import com.haikuMasterTrainingDataPostProcessor.word2vec.merger.Word2VecDataMerger;
import com.haikuMasterTrainingDataPostProcessor.word2vec.sorter.Word2VecDataSorter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Oliver on 1/26/2017.
 */
public class HaikuMasterTrainingDataPostProcessor {

    public Word2VecDataMerger word2VecDataMerger;

    public Word2VecDataSorter word2VecDataSorter;

    public TrainingDataDatabaseAccessor trainingDataDatabaseAccessor;

    public HaikuMasterTrainingDataPostProcessor(Word2VecDataMerger word2VecDataMerger, Word2VecDataSorter word2VecDataSorter,
                                                TrainingDataDatabaseAccessor trainingDataDatabaseAccessor) {
        this.word2VecDataMerger = word2VecDataMerger;
        this.word2VecDataSorter = word2VecDataSorter;
        this.trainingDataDatabaseAccessor = trainingDataDatabaseAccessor;
    }

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HaikuMasterTrainingDataPostProcessor trainingDataPostProcessor = (HaikuMasterTrainingDataPostProcessor) context.getBean("trainingDataPostProcessor");
        long startTime = System.currentTimeMillis();
        Map<String, Map<String, Word2VecData>> mergedData = trainingDataPostProcessor.word2VecDataMerger.merge();
        Map<String, List<Word2VecData>> sortedData = trainingDataPostProcessor.word2VecDataSorter.sort(mergedData);
        trainingDataPostProcessor.trainingDataDatabaseAccessor.clearWord2VecDatabase();
        Iterator it = sortedData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String keyToken = (String) pair.getKey();
            List<Word2VecData> list = (List<Word2VecData>) pair.getValue();
            trainingDataPostProcessor.trainingDataDatabaseAccessor.insertWord2VecData(keyToken, list);
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(sortedData.size() + " of word2vec training data rows processed in " + (elapsedTime / 1000) / 60 + " minutes and "
                + (elapsedTime / 1000) % 60 + " seconds");
    }

}
