package com.haikuMasterTrainingDataPostProcessor.word2vec.postprocessor;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;
import com.haikuMasterTrainingDataPostProcessor.database.TrainingDataDatabaseAccessor;
import com.haikuMasterTrainingDataPostProcessor.word2vec.merger.Word2VecDataMerger;
import com.haikuMasterTrainingDataPostProcessor.word2vec.sorter.Word2VecDataSorter;
import com.haikuMasterTrainingDataPostProcessor.writer.Word2VecSortedDataWriterImpl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Oliver on 2/3/2017.
 */
public class Word2VecDataPostProcessorImpl implements Word2VecDataPostProcessor, Runnable {

    private Word2VecDataMerger word2VecDataMerger;

    private Word2VecDataSorter word2VecDataSorter;

    private TrainingDataDatabaseAccessor trainingDataDatabaseAccessor;

    public Word2VecDataPostProcessorImpl(Word2VecDataMerger word2VecDataMerger, Word2VecDataSorter word2VecDataSorter,
                                         TrainingDataDatabaseAccessor trainingDataDatabaseAccessor) {
        this.word2VecDataMerger = word2VecDataMerger;
        this.word2VecDataSorter = word2VecDataSorter;
        this.trainingDataDatabaseAccessor = trainingDataDatabaseAccessor;
    }

    @Override
    public void postProcess() throws IOException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        long startTime = System.currentTimeMillis();
        Map<String, Map<String, Word2VecData>> mergedData = word2VecDataMerger.merge();
        Map<String, List<Word2VecData>> sortedData = word2VecDataSorter.sort(mergedData);
        Runnable word2VecSortedDataWriter = new Word2VecSortedDataWriterImpl(sortedData);
        Future<?> submit = executor.submit(word2VecSortedDataWriter);
//        trainingDataDatabaseAccessor.clearWord2VecDatabase();
        Iterator it = sortedData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String keyToken = (String) pair.getKey();
            List<Word2VecData> list = (List<Word2VecData>) pair.getValue();
            try {
//                trainingDataDatabaseAccessor.insertWord2VecData(keyToken, list);
            } catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex) {
            }
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(sortedData.size() + " of word2vec training data rows processed in " + (elapsedTime / 1000) / 60 + " minutes and "
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
