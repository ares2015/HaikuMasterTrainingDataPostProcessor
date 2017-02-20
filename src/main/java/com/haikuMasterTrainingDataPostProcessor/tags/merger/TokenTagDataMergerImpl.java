package com.haikuMasterTrainingDataPostProcessor.tags.merger;

import com.haikuMasterTrainingDataPostProcessor.data.TokenTagData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oliver on 2/2/2017.
 */
public class TokenTagDataMergerImpl implements TokenTagDataMerger {

    private String inputFilePath = "C:\\Users\\Oliver\\Documents\\NlpTrainingData\\TokenTagData.txt";

    @Override
    public Map<String, TokenTagData> merge() throws IOException {
        Map<String, TokenTagData> mergedData = new HashMap<>();
        int rowsCount = 1;
        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
        String trainingDataRowAsString = br.readLine();
        while (trainingDataRowAsString != null) {
            String[] split = trainingDataRowAsString.split("#");
            System.out.println(trainingDataRowAsString);
            System.out.println(rowsCount);
            String token = split[0];
            String tag = split[1];
            if (mergedData.containsKey(token)) {
                convertStringTagToBoolean(mergedData.get(token), tag);
            } else {
                TokenTagData tokenTagData = new TokenTagData();
                convertStringTagToBoolean(tokenTagData, tag);
                tokenTagData.setToken(token);
                mergedData.put(token, tokenTagData);
            }
            rowsCount++;
            trainingDataRowAsString = br.readLine();
        }
//        PrintWriter pw = new PrintWriter("C:\\Users\\Oliver\\Documents\\NlpTrainingData\\TokenTagData.txt");
//        pw.close();
        return mergedData;
    }

    private void convertStringTagToBoolean(TokenTagData tokenTagData, String tag) {
        if ("N".equals(tag)) {
            tokenTagData.setNoun(true);
        } else if ("V".equals(tag)) {
            tokenTagData.setVerb(true);
        } else if ("AJ".equals(tag)) {
            tokenTagData.setAdjective(true);
        } else if ("AV".equals(tag)) {
            tokenTagData.setAdverb(true);
        }
    }

}