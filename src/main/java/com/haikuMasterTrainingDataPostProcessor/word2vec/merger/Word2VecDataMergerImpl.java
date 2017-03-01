package com.haikuMasterTrainingDataPostProcessor.word2vec.merger;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;
import com.haikuMasterTrainingDataPostProcessor.data.Word2VecTrainingDataRow;
import com.haikuMasterTrainingDataPostProcessor.word2vec.factories.Word2VecTrainingDataRowFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oliver on 1/26/2017.
 */
public class Word2VecDataMergerImpl implements Word2VecDataMerger {

    private String inputFilePath = "C:\\Users\\Oliver\\Documents\\NlpTrainingData\\HaikuMasterTrainingData\\Word2VecModelData.txt";

    private Word2VecTrainingDataRowFactory word2VecTrainingDataRowFactory;

    public Word2VecDataMergerImpl(Word2VecTrainingDataRowFactory word2VecTrainingDataRowFactory) {
        this.word2VecTrainingDataRowFactory = word2VecTrainingDataRowFactory;
    }

    @Override

    public Map<String, Map<String, Word2VecData>> merge() throws IOException {
        Map<String, Map<String, Word2VecData>> mergedData = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
        String trainingDataRowAsString = br.readLine();
        while (trainingDataRowAsString != null) {
            System.out.println("Merging: " + trainingDataRowAsString);
            Word2VecTrainingDataRow word2VecTrainingDataRow = word2VecTrainingDataRowFactory.create(trainingDataRowAsString);
            List<Word2VecData> word2VecDataList = word2VecTrainingDataRow.getWord2VecDataList();
            for (Word2VecData word2VecData : word2VecDataList) {
                populateMap(mergedData, word2VecTrainingDataRow.getKeyToken(), word2VecData);
            }
            trainingDataRowAsString = br.readLine();
        }
//        PrintWriter pw = new PrintWriter("C:\\Users\\Oliver\\Documents\\NlpTrainingData\\Word2VecModelData.txt");
//        pw.close();
        return mergedData;
    }

    private void populateMap(Map<String, Map<String, Word2VecData>> mergedData, String keyToken, Word2VecData word2VecData) {
        String token = word2VecData.getToken();
        double actualVector = word2VecData.getVector();
        System.out.println("Merging: " + keyToken + " -> vector values: " + token + "*" + actualVector);
        if (mergedData.containsKey(keyToken)) {
            if (mergedData.get(keyToken).containsKey(token)) {
                double vector = mergedData.get(keyToken).get(token).getVector();
                double newVector = vector + actualVector;
                mergedData.get(keyToken).get(token).setVector(newVector);
            } else {
                Map<String, Word2VecData> map = new HashMap<>();
                map.put(token, word2VecData);
                mergedData.get(keyToken).put(token, word2VecData);
            }
        } else {
            Map<String, Word2VecData> map = new HashMap<>();
            map.put(token, word2VecData);
            mergedData.put(keyToken, map);
        }
    }

}