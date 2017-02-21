package com.haikuMasterTrainingDataPostProcessor.word2vec.database;

import com.haikuMasterTrainingDataPostProcessor.database.DatabaseUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 2/21/2017.
 */
public class DatabaseUtilTest {

    @Test
    public void test() {
        int numberOfQuestionMarks = 0;
        String sql = DatabaseUtil.createWord2VecInsertStatement();
        char[] chars = sql.toCharArray();

        for (char c : chars) {
            if ("?".equals(String.valueOf(c))) {
                numberOfQuestionMarks++;
            }
        }

        assertEquals(310, numberOfQuestionMarks);
    }
}
