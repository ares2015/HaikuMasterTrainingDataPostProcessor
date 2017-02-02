package com.haikuMasterTrainingDataPostProcessor.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliver.eder on 1/24/2017.
 */
public class Word2VecTrainingDataRow {

    private String keyToken;

    private List<Word2VecData> word2VecDataList = new ArrayList<>();

    public String getKeyToken() {
        return keyToken;
    }

    public void setKeyToken(String keyToken) {
        this.keyToken = keyToken;
    }

    public List<Word2VecData> getWord2VecDataList() {
        return word2VecDataList;
    }

    public void setWord2VecDataList(List<Word2VecData> word2VecDataList) {
        this.word2VecDataList = word2VecDataList;
    }

}
