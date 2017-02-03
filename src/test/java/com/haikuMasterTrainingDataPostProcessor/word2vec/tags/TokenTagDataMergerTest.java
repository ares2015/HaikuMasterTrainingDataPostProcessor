package com.haikuMasterTrainingDataPostProcessor.word2vec.tags;

import com.haikuMasterTrainingDataPostProcessor.data.TokenTagData;
import com.haikuMasterTrainingDataPostProcessor.tags.merger.TokenTagDataMerger;
import com.haikuMasterTrainingDataPostProcessor.tags.merger.TokenTagDataMergerImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by Oliver on 2/2/2017.
 */
public class TokenTagDataMergerTest {

    @Test
    public void testMerge() throws IOException {
        TokenTagDataMerger tokenTagDataMerger = new TokenTagDataMergerImpl();
        Map<String, TokenTagData> mergedData = tokenTagDataMerger.merge();
        assertTrue(mergedData.get("love").isNoun());
        assertTrue(mergedData.get("love").isVerb());
    }
}