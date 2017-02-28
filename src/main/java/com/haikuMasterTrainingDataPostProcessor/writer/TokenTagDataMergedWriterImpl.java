package com.haikuMasterTrainingDataPostProcessor.writer;

import com.haikuMasterTrainingDataPostProcessor.data.TokenTagData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Oliver on 2/28/2017.
 */
public class TokenTagDataMergedWriterImpl implements TokenTagDataMergedWriter, Runnable {

    private Map<String, TokenTagData> mergedData;

    public TokenTagDataMergedWriterImpl(Map<String, TokenTagData> mergedData) {
        this.mergedData = mergedData;
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
            fw = new FileWriter("C:\\Users\\Oliver\\Documents\\NlpTrainingData\\HaikuMasterTrainingData\\HaikuMasterMergedTokenTagData.txt", true);
            bw = new BufferedWriter(fw);
            Iterator it = mergedData.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                TokenTagData tokenTagData = (TokenTagData) pair.getValue();
                String trainingDataRow = createTrainingDataRow(tokenTagData);
                System.out.println("Writing training row: " + trainingDataRow);
                bw.write(trainingDataRow);
                bw.newLine();
            }
            System.out.println("Writing into token tags file finished");
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

    private String createTrainingDataRow(TokenTagData tokenTagData) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tokenTagData.getToken());
        stringBuilder.append("#");
        for (String tag : tokenTagData.getTags()) {
            stringBuilder.append(tag);
            stringBuilder.append("#");
        }
        return stringBuilder.toString();
    }

}