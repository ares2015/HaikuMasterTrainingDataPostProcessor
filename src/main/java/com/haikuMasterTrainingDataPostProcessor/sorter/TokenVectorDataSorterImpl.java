package com.haikuMasterTrainingDataPostProcessor.sorter;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;

import java.util.*;

/**
 * Created by Oliver on 1/26/2017.
 */
public class TokenVectorDataSorterImpl implements TokenVectorDataSorter {

    @Override
    public Map<String, List<TokenVectorData>> sort(Map<String, Map<String, TokenVectorData>> mergedData) {
        Map<String, List<TokenVectorData>> sortedData = new HashMap<>();
        Iterator mergedDataMapIterator = mergedData.entrySet().iterator();
        while (mergedDataMapIterator.hasNext()) {
            Map.Entry mergedDataMapPair = (Map.Entry) mergedDataMapIterator.next();
            String keyToken = (String) mergedDataMapPair.getKey();
            List<TokenVectorData> tokenVectorDataList = new ArrayList<>();
            Map<String, TokenVectorData> tokenVectorDataMap = (Map<String, TokenVectorData>) mergedDataMapPair.getValue();
            Iterator tokenVectorDataMapIterator = tokenVectorDataMap.entrySet().iterator();
            while (tokenVectorDataMapIterator.hasNext()) {
                Map.Entry tokenVectorMapPair = (Map.Entry) tokenVectorDataMapIterator.next();
                TokenVectorData tokenVectorData = (TokenVectorData) tokenVectorMapPair.getValue();
                tokenVectorDataList.add(tokenVectorData);
//                System.out.println(keyToken + " -> " + tokenVectorData.getToken() + " " + tokenVectorData.getVector());
            }
            Collections.sort(tokenVectorDataList, (o1, o2) -> {
                if (o1.getVector() > o2.getVector()) {
                    return -1;
                } else if (o1.getVector() < o2.getVector()) {
                    return 1;
                } else {
                    return 0;
                }
            });
            sortedData.put(keyToken, tokenVectorDataList);
        }
        return sortedData;
    }
}