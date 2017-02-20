package com.haikuMasterTrainingDataPostProcessor.database;

import com.haikuMasterTrainingDataPostProcessor.data.TokenTagData;
import com.haikuMasterTrainingDataPostProcessor.data.Word2VecData;
import com.haikuMasterTrainingDataPostProcessor.word2vec.factories.Word2VecDatabaseListFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Oliver on 1/26/2017.
 */
public class TrainingDataDatabaseAccessorImpl implements TrainingDataDatabaseAccessor {

    private JdbcTemplate jdbcTemplate;

    private Word2VecDatabaseListFactory word2VecDatabaseListFactory;

    public TrainingDataDatabaseAccessorImpl(final JdbcTemplate jdbcTemplate, Word2VecDatabaseListFactory word2VecDatabaseListFactory) {
        this.jdbcTemplate = jdbcTemplate;
        this.word2VecDatabaseListFactory = word2VecDatabaseListFactory;
    }

    @Override
    public void clearWord2VecDatabase() {
        String sqlDelete = "DELETE FROM jos_haiku_master_word2vec_model WHERE 1";
        jdbcTemplate.update(sqlDelete);
    }

    @Override
    public void clearTokenTagDataDatabase() {
        String sqlDelete = "DELETE FROM jos_haiku_master_token_tag_data WHERE 1";
        jdbcTemplate.update(sqlDelete);
    }

    @Override
    public void insertWord2VecData(String keyToken, List<Word2VecData> word2VecDataList) {
        List<String> databaseList = word2VecDatabaseListFactory.create(word2VecDataList);
        System.out.println("Inserting -> keyToken: " + keyToken + " -> " + databaseList.get(0) + " | "
                + databaseList.get(1) + " | "
                + databaseList.get(2) + " | "
                + databaseList.get(3) + " | "
                + databaseList.get(4) + " | "
                + databaseList.get(5) + " | "
                + databaseList.get(6) + " | "
                + databaseList.get(7) + " | "
                + databaseList.get(8) + " | "
                + databaseList.get(9) + " | "
                + databaseList.get(10) + " | "
                + databaseList.get(11) + " | "
                + databaseList.get(12) + " | "
                + databaseList.get(13) + " | "
                + databaseList.get(14) + " | "
                + databaseList.get(15) + " | "
                + databaseList.get(16) + " | "
                + databaseList.get(17) + " | "
                + databaseList.get(18) + " | "
                + databaseList.get(19) + " | "
        );
        String sql = DatabaseUtil.createWord2VecInsertStatement();
        Object[] parameterObjectArray = DatabaseUtil.createParameterObjectArray(keyToken, databaseList);
        jdbcTemplate.update(sql, parameterObjectArray);
    }

    @Override
    public void insertTokenTagData(TokenTagData tokenTagData) {
        String sql = "insert into jos_haiku_master_token_tag_data (token, is_noun, is_verb, is_adjective, is_adverb) values (?,?,?,?,?)";
        System.out.println("Inserting token: " + tokenTagData.getToken());
        jdbcTemplate.update(sql, new Object[]{tokenTagData.getToken(), tokenTagData.isNoun(),
                tokenTagData.isVerb(), tokenTagData.isAdjective(), tokenTagData.isAdverb()});
    }

}
