package dataprocessing;

import dataprocessing.StepCountStrategy;
import storage.DataRepository;
import storage.SensorData;

import java.util.List;

public class FilteredStepCountStrategy implements StepCountStrategy  {
    @Override
    public void consumeMessage(SensorData sample) {

    }

    @Override
    public String getStrategyDescription() {
        return "";
    }

    private final DataRepository repository;

    public FilteredStepCountStrategy(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public int getTotalSteps() {
        List<SensorData> records = repository.getRecords();
        int total = 0;
        long lastValidTimestamp = -1;

        for (SensorData data : records) {
            int steps = data.getStepsCount();
            long timestamp = data.getTimestamp();

            if (steps > 0) {
                if (steps <= 1000) {
                    if (lastValidTimestamp == -1 || timestamp - lastValidTimestamp >= 60000) {
                        total += steps;
                        lastValidTimestamp = timestamp;
                    }
                }
            }
        }

        return total;
    }
}