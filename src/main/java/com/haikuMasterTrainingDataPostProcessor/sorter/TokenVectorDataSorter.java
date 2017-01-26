package com.haikuMasterTrainingDataPostProcessor.sorter;

import com.haikuMasterTrainingDataPostProcessor.data.TokenVectorData;

import java.util.List;
import java.util.Map;

/**
 * Created by Oliver on 1/26/2017.
 */
public interface TokenVectorDataSorter {

    Map<String, List<TokenVectorData>> sort(Map<String, Map<String, TokenVectorData>> mergedData);
}
