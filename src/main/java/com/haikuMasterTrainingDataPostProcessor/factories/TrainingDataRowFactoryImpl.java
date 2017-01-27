package com.haikuMasterTrainingDataPostProcessor.factories;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;
import com.haikuMasterTrainingDataPostProcessor.data.TrainingDataRow;

/**
 * Created by oliver.eder on 1/24/2017.
 */
public class TrainingDataRowFactoryImpl implements TrainingDataRowFactory {

    @Override
    public TrainingDataRow create(String trainingDataRowString) {
        TrainingDataRow trainingDataRow = new TrainingDataRow();
        String[] split = trainingDataRowString.split("#");
        trainingDataRow.setKeyToken(split[0]);
        String[] vectors = split[1].split("@");
        for (String vector : vectors) {
            String[] tokenVectorDataTmp = vector.split("%");
            TokenVectorData tokenVectorData = new TokenVectorData();
            tokenVectorData.setToken(tokenVectorDataTmp[0]);
            tokenVectorData.setVector(Double.valueOf(tokenVectorDataTmp[1]));
            trainingDataRow.getTokenVectorDataList().add(tokenVectorData);
        }
        return trainingDataRow;
    }

}
