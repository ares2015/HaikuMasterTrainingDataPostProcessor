package com.haikuMasterTrainingDataPostProcessor.factories;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;

import java.util.List;

/**
 * Created by Oliver on 1/27/2017.
 */
public interface DatabaseListFactory {

    List<String> create(List<TokenVectorData> tokenVectorDataList);

}
