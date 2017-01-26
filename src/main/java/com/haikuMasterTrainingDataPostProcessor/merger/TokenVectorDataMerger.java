package com.haikuMasterTrainingDataPostProcessor.merger;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Oliver on 1/26/2017.
 */
public interface TokenVectorDataMerger {

    Map<String, Map<String, TokenVectorData>> merge() throws IOException;
}
