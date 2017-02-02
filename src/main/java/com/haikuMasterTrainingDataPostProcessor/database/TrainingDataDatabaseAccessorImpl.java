package com.haikuMasterTrainingDataPostProcessor.database;

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
                "neighbour20) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                databaseList.get(19)
        });
    }
}
