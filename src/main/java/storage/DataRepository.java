package storage;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    // Instanța unică
    private static final DataRepository INSTANCE = new DataRepository();

    // Lista care stochează datele senzorului
    private final List<SensorData> dataRecords;

    // Constructor privat
    private DataRepository() {
        dataRecords = new ArrayList<>();
    }

    // Metodă publică pentru acces la instanță
    public static DataRepository getInstance() {
        return INSTANCE;
    }

    // Adaugă o înregistrare de date
    public void addData(SensorData dataRecord) {
        dataRecords.add(dataRecord);
    }

    // Returnează toate înregistrările
    public List<SensorData> getRecords() {
        return new ArrayList<>(dataRecords); // copie defensivă
    }
}