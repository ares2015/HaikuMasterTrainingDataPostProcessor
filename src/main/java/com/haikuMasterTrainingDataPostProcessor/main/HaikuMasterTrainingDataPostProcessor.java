package com.haikuMasterTrainingDataPostProcessor.main;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;
import com.haikuMasterTrainingDataPostProcessor.database.TrainingDataDatabaseAccessor;
import com.haikuMasterTrainingDataPostProcessor.merger.TokenVectorDataMerger;
import com.haikuMasterTrainingDataPostProcessor.sorter.TokenVectorDataSorter;
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

    public TokenVectorDataMerger tokenVectorDataMerger;

    public TokenVectorDataSorter tokenVectorDataSorter;

    public TrainingDataDatabaseAccessor trainingDataDatabaseAccessor;

    public HaikuMasterTrainingDataPostProcessor(TokenVectorDataMerger tokenVectorDataMerger, TokenVectorDataSorter tokenVectorDataSorter,
                                                TrainingDataDatabaseAccessor trainingDataDatabaseAccessor) {
        this.tokenVectorDataMerger = tokenVectorDataMerger;
        this.tokenVectorDataSorter = tokenVectorDataSorter;
        this.trainingDataDatabaseAccessor = trainingDataDatabaseAccessor;
    }

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HaikuMasterTrainingDataPostProcessor trainingDataPostProcessor = (HaikuMasterTrainingDataPostProcessor) context.getBean("trainingDataPostProcessor");
        long startTime = System.currentTimeMillis();
        Map<String, Map<String, TokenVectorData>> mergedData = trainingDataPostProcessor.tokenVectorDataMerger.merge();
        Map<String, List<TokenVectorData>> sortedData = trainingDataPostProcessor.tokenVectorDataSorter.sort(mergedData);
        trainingDataPostProcessor.trainingDataDatabaseAccessor.clearDatabase();
        Iterator it = sortedData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String keyToken = (String) pair.getKey();
            List<TokenVectorData> list = (List<TokenVectorData>) pair.getValue();
            trainingDataPostProcessor.trainingDataDatabaseAccessor.insertTokenWord2VecData(keyToken, list);
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(sortedData.size() + " of key tokens processed in " + (elapsedTime / 1000) / 60 + " minutes and "
                + (elapsedTime / 1000) % 60 + " seconds");
    }

}
