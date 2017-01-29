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

//    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    private TokenVectorDataMerger tokenVectorDataMerger;

    private TokenVectorDataSorter tokenVectorDataSorter;

    private TrainingDataDatabaseAccessor trainingDataDatabaseAccessor;

    public HaikuMasterTrainingDataPostProcessor(TokenVectorDataMerger tokenVectorDataMerger, TokenVectorDataSorter tokenVectorDataSorter,
                                                TrainingDataDatabaseAccessor trainingDataDatabaseAccessor) {
        this.tokenVectorDataMerger = tokenVectorDataMerger;
        this.tokenVectorDataSorter = tokenVectorDataSorter;
        this.trainingDataDatabaseAccessor = trainingDataDatabaseAccessor;
    }

    public TokenVectorDataMerger getTokenVectorDataMerger() {
        return tokenVectorDataMerger;
    }

    public TokenVectorDataSorter getTokenVectorDataSorter() {
        return tokenVectorDataSorter;
    }

    public TrainingDataDatabaseAccessor getTrainingDataDatabaseAccessor() {
        return trainingDataDatabaseAccessor;
    }

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HaikuMasterTrainingDataPostProcessor trainingDataPostProcessor = (HaikuMasterTrainingDataPostProcessor) context.getBean("trainingDataPostProcessor");

        Map<String, Map<String, TokenVectorData>> mergedData = trainingDataPostProcessor.getTokenVectorDataMerger().merge();
        Map<String, List<TokenVectorData>> sortedData = trainingDataPostProcessor.getTokenVectorDataSorter().sort(mergedData);
        Iterator it = sortedData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String keyToken = (String) pair.getKey();
            List<TokenVectorData> list = (List<TokenVectorData>) pair.getValue();
            trainingDataPostProcessor.getTrainingDataDatabaseAccessor().insertTokenWord2VecData(keyToken, list);
        }
    }

}
