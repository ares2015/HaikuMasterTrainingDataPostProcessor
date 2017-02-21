package com.haikuMasterTrainingDataPostProcessor.database;

import java.util.List;

/**
 * Created by Oliver on 2/20/2017.
 */
public final class DatabaseUtil {

    public static String createWord2VecInsertStatement() {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into jos_haiku_master_word2vec_model (token,");
        for (int i = 1; i <= 309; i++) {
            if (i == 309) {
                sql.append("neighbour" + i + ") ");
            } else {
                sql.append("neighbour" + i + ",");
            }
        }
        sql.append("values (");
        for (int i = 1; i <= 309; i++) {
            sql.append("?, ");
        }
        sql.append("? )");
        return sql.toString();
    }

    public static Object[] createParameterObjectArray(String keyToken, List<String> databaseList) {
        Object[] parameterArray = new Object[310];
        parameterArray[0] = keyToken;
        for (int i = 0; i <= 308; i++) {
            parameterArray[i + 1] = databaseList.get(i);
        }
        return parameterArray;
    }
}
