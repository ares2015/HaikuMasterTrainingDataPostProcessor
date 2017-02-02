package com.haikuMasterTrainingDataPostProcessor.word2vec.factories;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliver on 1/27/2017.
 */
public class Word2VecDatabaseListFactoryImpl implements Word2VecDatabaseListFactory {

    @Override
    public List<String> create(List<Word2VecData> word2VecDatabaseList) {
        List<String> databaseList = new ArrayList<>(20);
        if (word2VecDatabaseList.size() < 20) {
            int listSize = word2VecDatabaseList.size();
            for (int i = 0; i < listSize; i++) {
                databaseList.add(word2VecDatabaseList.get(i).getToken());
            }
            for (int i = listSize; i < 20; i++) {
                databaseList.add(i, "");
            }
        } else {
            for (int i = 0; i < 20; i++) {
                databaseList.add(word2VecDatabaseList.get(i).getToken());
            }
        }
        return databaseList;
    }

}
