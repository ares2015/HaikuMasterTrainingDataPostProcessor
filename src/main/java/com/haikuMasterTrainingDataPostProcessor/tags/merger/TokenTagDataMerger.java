package com.haikuMasterTrainingDataPostProcessor.tags.merger;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by Oliver on 2/2/2017.
 */
public interface TokenTagDataMerger {

    Map<String, Set<String>> merge() throws IOException;
}
