package com.haikuMasterTrainingDataPostProcessor.tags.merger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Oliver on 2/2/2017.
 */
public class TokenTagDataMergerImpl implements TokenTagDataMerger {

    private String inputFilePath = "C:\\Users\\Oliver\\Documents\\NlpTrainingData\\TokenTagData.txt";

    @Override
    public Map<String, Set<String>> merge() throws IOException {
        Map<String, Set<String>> mergedData = new HashMap<>();
        int rowsCount = 1;
        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
        String trainingDataRowAsString = br.readLine();
        while (trainingDataRowAsString != null) {
            String[] split = trainingDataRowAsString.split("#");
            String token = split[0];
            String tag = split[1];
            if (mergedData.containsKey(token)) {
                mergedData.get(token).add(tag);
            } else {
                Set<String> tags = new HashSet<String>();
                tags.add(tag);
                mergedData.put(token, tags);
            }
            rowsCount++;
            trainingDataRowAsString = br.readLine();
        }
        return mergedData;
    }

}
