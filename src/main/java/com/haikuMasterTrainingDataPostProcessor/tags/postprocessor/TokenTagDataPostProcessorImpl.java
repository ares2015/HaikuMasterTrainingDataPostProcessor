package com.haikuMasterTrainingDataPostProcessor.tags.postprocessor;

import com.haikuMasterTrainingDataPostProcessor.data.TokenTagData;
import com.haikuMasterTrainingDataPostProcessor.database.TrainingDataDatabaseAccessor;
import com.haikuMasterTrainingDataPostProcessor.tags.merger.TokenTagDataMerger;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Oliver on 2/3/2017.
 */
public class TokenTagDataPostProcessorImpl implements TokenTagDataPostProcessor, Runnable {

    private TokenTagDataMerger tokenTagDataMerger;

    private TrainingDataDatabaseAccessor trainingDataDatabaseAccessor;

    public TokenTagDataPostProcessorImpl(TokenTagDataMerger tokenTagDataMerger, TrainingDataDatabaseAccessor trainingDataDatabaseAccessor) {
        this.tokenTagDataMerger = tokenTagDataMerger;
        this.trainingDataDatabaseAccessor = trainingDataDatabaseAccessor;
    }

    @Override
    public void postProcess() throws IOException {
        long startTime = System.currentTimeMillis();
        Map<String, TokenTagData> mergedData = tokenTagDataMerger.merge();
        trainingDataDatabaseAccessor.clearTokenTagDataDatabase();
        Iterator it = mergedData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            TokenTagData tokenTagData = (TokenTagData) pair.getValue();
            trainingDataDatabaseAccessor.insertTokenTagData(tokenTagData);
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(mergedData.size() + " of tokenTagData training data rows processed in " + (elapsedTime / 1000) / 60 + " minutes and "
                + (elapsedTime / 1000) % 60 + " seconds");
    }

    @Override
    public void run() {
        try {
            postProcess();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
