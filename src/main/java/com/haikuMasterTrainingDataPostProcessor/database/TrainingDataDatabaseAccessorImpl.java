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
        String sql = "insert into jos_haiku_master_word2vec_model (token, " +
                "neighbour1," +
                "neighbour2," +
                "neighbour3," +
                "neighbour4," +
                "neighbour5," +
                "neighbour6," +
                "neighbour7," +
                "neighbour8," +
                "neighbour9," +
                "neighbour10, " +
                "neighbour11, " +
                "neighbour12, " +
                "neighbour13, " +
                "neighbour14, " +
                "neighbour15, " +
                "neighbour16, " +
                "neighbour17, " +
                "neighbour18, " +
                "neighbour19, " +
                "neighbour20, " +
                "neighbour21, " +
                "neighbour22, " +
                "neighbour23, " +
                "neighbour24, " +
                "neighbour25, " +
                "neighbour26, " +
                "neighbour27, " +
                "neighbour28, " +
                "neighbour29, " +
                "neighbour30, " +
                "neighbour31, " +
                "neighbour32, " +
                "neighbour33, " +
                "neighbour34, " +
                "neighbour35, " +
                "neighbour36, " +
                "neighbour37, " +
                "neighbour38, " +
                "neighbour39, " +
                "neighbour40, " +
                "neighbour41, " +
                "neighbour42, " +
                "neighbour43, " +
                "neighbour44, " +
                "neighbour45, " +
                "neighbour46, " +
                "neighbour47, " +
                "neighbour48, " +
                "neighbour49," +
                "neighbour50) " +
                "values (?," +
                "?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{keyToken,
                databaseList.get(0),
                databaseList.get(1),
                databaseList.get(2),
                databaseList.get(3),
                databaseList.get(4),
                databaseList.get(5),
                databaseList.get(6),
                databaseList.get(7),
                databaseList.get(8),
                databaseList.get(9),
                databaseList.get(10),
                databaseList.get(11),
                databaseList.get(12),
                databaseList.get(13),
                databaseList.get(14),
                databaseList.get(15),
                databaseList.get(16),
                databaseList.get(17),
                databaseList.get(18),
                databaseList.get(19),
                databaseList.get(20),
                databaseList.get(21),
                databaseList.get(22),
                databaseList.get(23),
                databaseList.get(24),
                databaseList.get(25),
                databaseList.get(26),
                databaseList.get(27),
                databaseList.get(28),
                databaseList.get(29),
                databaseList.get(30),
                databaseList.get(31),
                databaseList.get(32),
                databaseList.get(33),
                databaseList.get(34),
                databaseList.get(35),
                databaseList.get(36),
                databaseList.get(37),
                databaseList.get(38),
                databaseList.get(39),
                databaseList.get(40),
                databaseList.get(41),
                databaseList.get(42),
                databaseList.get(43),
                databaseList.get(44),
                databaseList.get(45),
                databaseList.get(46),
                databaseList.get(47),
                databaseList.get(48),
                databaseList.get(49),
        });
    }

    @Override
    public void insertTokenTagData(TokenTagData tokenTagData) {
        String sql = "insert into jos_haiku_master_token_tag_data (token, is_noun, is_verb, is_adjective, is_adverb) values (?,?,?,?,?)";
        System.out.println("Inserting token: " + tokenTagData.getToken());
        jdbcTemplate.update(sql, new Object[]{tokenTagData.getToken(), tokenTagData.isNoun(),
                tokenTagData.isVerb(), tokenTagData.isAdjective(), tokenTagData.isAdverb()});
    }

}
