package com.haikuMasterTrainingDataPostProcessor.word2vec.factories;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliver on 1/27/2017.
 */
public class Word2VecDatabaseListFactoryImpl implements Word2VecDatabaseListFactory {

    private final int VECTOR_SIZE = 50;

    @Override
    public List<String> create(List<Word2VecData> word2VecDatabaseList) {
        List<String> databaseList = new ArrayList<>(VECTOR_SIZE);
        if (word2VecDatabaseList.size() < VECTOR_SIZE) {
            int listSize = word2VecDatabaseList.size();
            for (int i = 0; i < listSize; i++) {
                databaseList.add(word2VecDatabaseList.get(i).getToken());
            }
            for (int i = listSize; i < VECTOR_SIZE; i++) {
                databaseList.add(i, "");
            }
        } else {
            for (int i = 0; i < VECTOR_SIZE; i++) {
                databaseList.add(word2VecDatabaseList.get(i).getToken());
            }
        }
        return databaseList;
    }

}
