package com.haikuMasterTrainingDataPostProcessor.word2vec.sorter;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;

import java.util.*;

/**
 * Created by Oliver on 1/26/2017.
 */
public class Word2VecDataSorterImpl implements Word2VecDataSorter {

    @Override
    public Map<String, List<Word2VecData>> sort(Map<String, Map<String, Word2VecData>> mergedData) {
        Map<String, List<Word2VecData>> sortedData = new HashMap<>();
        Iterator mergedDataMapIterator = mergedData.entrySet().iterator();
        while (mergedDataMapIterator.hasNext()) {
            Map.Entry mergedDataMapPair = (Map.Entry) mergedDataMapIterator.next();
            String keyToken = (String) mergedDataMapPair.getKey();
            List<Word2VecData> word2VecDataList = new ArrayList<>();
            Map<String, Word2VecData> tokenVectorDataMap = (Map<String, Word2VecData>) mergedDataMapPair.getValue();
            Iterator tokenVectorDataMapIterator = tokenVectorDataMap.entrySet().iterator();
            while (tokenVectorDataMapIterator.hasNext()) {
                Map.Entry tokenVectorMapPair = (Map.Entry) tokenVectorDataMapIterator.next();
                Word2VecData word2VecData = (Word2VecData) tokenVectorMapPair.getValue();
                word2VecDataList.add(word2VecData);
                System.out.println(keyToken + " -> " + word2VecData.getToken() + " " + word2VecData.getVector());
            }
            Collections.sort(word2VecDataList, (o1, o2) -> {
                if (o1.getVector() > o2.getVector()) {
                    return -1;
                } else if (o1.getVector() < o2.getVector()) {
                    return 1;
                } else {
                    return 0;
                }
            });
            sortedData.put(keyToken, word2VecDataList);
        }
        return sortedData;
    }
}