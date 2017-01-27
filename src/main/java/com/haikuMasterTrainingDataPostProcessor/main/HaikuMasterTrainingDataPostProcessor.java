package com.haikuMasterTrainingDataPostProcessor.main;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;
import com.haikuMasterTrainingDataPostProcessor.factories.TrainingDataRowFactory;
import com.haikuMasterTrainingDataPostProcessor.factories.TrainingDataRowFactoryImpl;
import com.haikuMasterTrainingDataPostProcessor.merger.TokenVectorDataMerger;
import com.haikuMasterTrainingDataPostProcessor.merger.TokenVectorDataMergerImpl;
import com.haikuMasterTrainingDataPostProcessor.sorter.TokenVectorDataSorter;
import com.haikuMasterTrainingDataPostProcessor.sorter.TokenVectorDataSorterImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Oliver on 1/26/2017.
 */
public class HaikuMasterTrainingDataPostProcessor {

    private TrainingDataRowFactory trainingDataRowFactory = new TrainingDataRowFactoryImpl();

    private TokenVectorDataMerger tokenVectorDataMerger = new TokenVectorDataMergerImpl(trainingDataRowFactory);

    private TokenVectorDataSorter tokenVectorDataSorter = new TokenVectorDataSorterImpl();

    public static void main(String[] args) throws IOException {
        TrainingDataRowFactory trainingDataRowFactory = new TrainingDataRowFactoryImpl();

        TokenVectorDataMerger tokenVectorDataMerger = new TokenVectorDataMergerImpl(trainingDataRowFactory);

        TokenVectorDataSorter tokenVectorDataSorter = new TokenVectorDataSorterImpl();
        Map<String, Map<String, TokenVectorData>> mergedData = tokenVectorDataMerger.merge();
        Map<String, List<TokenVectorData>> sortedData = tokenVectorDataSorter.sort(mergedData);




    }

}
