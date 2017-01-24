package com.haikuMasterTrainingDataPostProcessor.factory;

import com.haikuMasterTrainingDataPostProcessor.data.TrainingDataRow;

/**
 * Created by oliver.eder on 1/24/2017.
 */
public interface TrainingDataRowFactory {

    TrainingDataRow create(String trainingDataRowString);
}
