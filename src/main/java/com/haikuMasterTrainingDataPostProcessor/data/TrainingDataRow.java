package com.haikuMasterTrainingDataPostProcessor.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliver.eder on 1/24/2017.
 */
public class TrainingDataRow {

    private String keyToken;

    private List<TokenVectorData> tokenVectorDataList = new ArrayList<>();

    public String getKeyToken() {
        return keyToken;
    }

    public void setKeyToken(String keyToken) {
        this.keyToken = keyToken;
    }

    public List<TokenVectorData> getTokenVectorDataList() {
        return tokenVectorDataList;
    }

    public void setTokenVectorDataList(List<TokenVectorData> tokenVectorDataList) {
        this.tokenVectorDataList = tokenVectorDataList;
    }
}
