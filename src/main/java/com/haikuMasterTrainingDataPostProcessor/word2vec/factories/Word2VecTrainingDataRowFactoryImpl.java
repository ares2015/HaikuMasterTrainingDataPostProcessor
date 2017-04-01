package com.haikuMasterTrainingDataPostProcessor.word2vec.factories;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;
import com.haikuMasterTrainingDataPostProcessor.data.Word2VecTrainingDataRow;

/**
 * Created by oliver.eder on 1/24/2017.
 */
public class Word2VecTrainingDataRowFactoryImpl implements Word2VecTrainingDataRowFactory {

    @Override
    public Word2VecTrainingDataRow create(String word2vecTrainingDataRowString) {
        Word2VecTrainingDataRow word2VecTrainingDataRow = new Word2VecTrainingDataRow();
        String[] split = word2vecTrainingDataRowString.split("#");
        word2VecTrainingDataRow.setKeyToken(split[0]);
        String[] vectors = split[1].split("@");
        for (String vector : vectors) {
//            String[] tokenVectorDataTmp = vector.split("%");
            Word2VecData word2VecData = new Word2VecData();
            word2VecData.setToken(vector);
//            word2VecData.setVector(Double.valueOf(tokenVectorDataTmp[1]));
            word2VecTrainingDataRow.getWord2VecDataList().add(word2VecData);
        }
        return word2VecTrainingDataRow;
    }

}
