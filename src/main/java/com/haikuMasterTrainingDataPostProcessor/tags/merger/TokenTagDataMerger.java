package com.haikuMasterTrainingDataPostProcessor.tags.merger;

import com.haikuMasterTrainingDataPostProcessor.data.TokenTagData;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Oliver on 2/2/2017.
 */
public interface TokenTagDataMerger {

    Map<String, TokenTagData> merge() throws IOException;
}
