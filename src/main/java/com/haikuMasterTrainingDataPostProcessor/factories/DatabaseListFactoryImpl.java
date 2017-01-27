package com.haikuMasterTrainingDataPostProcessor.factories;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliver on 1/27/2017.
 */
public class DatabaseListFactoryImpl implements DatabaseListFactory {

    @Override
    public List<String> create(List<TokenVectorData> tokenVectorDataList) {
        List<String> databaseList = new ArrayList<>(20);
        if (tokenVectorDataList.size() < 20) {
            int listSize = tokenVectorDataList.size();
            for (int i = 0; i < listSize; i++) {
                databaseList.add(tokenVectorDataList.get(i).getToken());
            }
            for (int i = listSize; i < 20; i++) {
                databaseList.add(i, "");
            }
        } else {
            for (int i = 0; i < 20; i++) {
                databaseList.add(tokenVectorDataList.get(i).getToken());
            }
        }
        return databaseList;
    }

}
