package com.haikuMasterTrainingDataPostProcessor.merger;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;
import com.haikuMasterTrainingDataPostProcessor.data.TrainingDataRow;
import com.haikuMasterTrainingDataPostProcessor.factories.TrainingDataRowFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oliver on 1/26/2017.
 */
public class TokenVectorDataMergerImpl implements TokenVectorDataMerger {

    private String inputFilePath = "C:\\Users\\Oliver\\Documents\\NlpTrainingData\\Word2VecModelData.txt";

    private TrainingDataRowFactory trainingDataRowFactory;

    public TokenVectorDataMergerImpl(TrainingDataRowFactory trainingDataRowFactory) {
        this.trainingDataRowFactory = trainingDataRowFactory;
    }

    @Override
    public Map<String, Map<String, TokenVectorData>> merge() throws IOException {
        Map<String, Map<String, TokenVectorData>> mergedData = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
        String trainingDataRowAsString = br.readLine();
        while (trainingDataRowAsString != null) {
            TrainingDataRow trainingDataRow = trainingDataRowFactory.create(trainingDataRowAsString);
            List<TokenVectorData> tokenVectorDataList = trainingDataRow.getTokenVectorDataList();
            for (TokenVectorData tokenVectorData : tokenVectorDataList) {
                populateMap(mergedData, trainingDataRow.getKeyToken(), tokenVectorData);
            }
            trainingDataRowAsString = br.readLine();
        }
        return mergedData;
    }

    private void populateMap(Map<String, Map<String, TokenVectorData>> mergedData, String keyToken, TokenVectorData tokenVectorData) {
        String token = tokenVectorData.getToken();
        double actualVector = tokenVectorData.getVector();
        if (mergedData.containsKey(keyToken)) {
            if (mergedData.get(keyToken).containsKey(token)) {
                double vector = mergedData.get(keyToken).get(token).getVector();
                double newVector = vector + actualVector;
                mergedData.get(keyToken).get(token).setVector(newVector);
            } else {
                Map<String, TokenVectorData> map = new HashMap<>();
                map.put(token, tokenVectorData);
                mergedData.get(keyToken).put(token, tokenVectorData);
            }
        } else {
            Map<String, TokenVectorData> map = new HashMap<>();
            map.put(token, tokenVectorData);
            mergedData.put(keyToken, map);
        }
    }

}