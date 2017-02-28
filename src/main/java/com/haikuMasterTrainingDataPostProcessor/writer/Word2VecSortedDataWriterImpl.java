package com.haikuMasterTrainingDataPostProcessor.writer;

import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Oliver on 2/28/2017.
 */
public class Word2VecSortedDataWriterImpl implements Word2VecSortedDataWriter, Runnable {

    private Map<String, List<Word2VecData>> sortedData;

    public Word2VecSortedDataWriterImpl(Map<String, List<Word2VecData>> sortedData) {
        this.sortedData = sortedData;
    }

    @Override
    public void run() {
        write();
    }

    @Override
    public void write() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\Users\\Oliver\\Documents\\NlpTrainingData\\HaikuMasterTrainingData\\HaikuMasterSortedWord2VecData.txt", true);
            bw = new BufferedWriter(fw);
            Iterator it = sortedData.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                String keyToken = (String) pair.getKey();
                List<Word2VecData> list = (List<Word2VecData>) pair.getValue();
                String trainingDataRow = createTrainingDataRow(keyToken, list);
                System.out.println("Writing training row: " + trainingDataRow);
                bw.write(trainingDataRow);
                bw.newLine();
            }
            System.out.println("Writing into word2vec file finished");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String createTrainingDataRow(String keyToken, List<Word2VecData> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(keyToken);
        stringBuilder.append("#");
        for (Word2VecData word2VecData : list) {
            stringBuilder.append(word2VecData.getToken());
            stringBuilder.append("#");
        }
        return stringBuilder.toString();
    }

}
