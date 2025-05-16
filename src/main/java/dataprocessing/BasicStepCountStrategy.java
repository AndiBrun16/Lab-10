package dataprocessing;


import storage.DataRepository;
import storage.SensorData;

import java.util.List;

public class BasicStepCountStrategy implements StepCountStrategy {

    private final DataRepository repository;

    public BasicStepCountStrategy(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void consumeMessage(SensorData sample) {

    }

    @Override
    public int getTotalSteps() {
        int total = 0;
        List<SensorData> records = repository.getRecords();
        for (SensorData data : records) {
            total += data.getStepsCount();
        }
        return total;
    }

    @Override
    public String getStrategyDescription() {
        return "";
    }
}