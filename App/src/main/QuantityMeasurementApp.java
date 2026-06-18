package main;
import main.util.DatabaseInitializer;
import main.controller.QuantityMeasurementController;
import main.dto.QuantityDTO;

import main.repository.IQuantityMeasurementRepository;
import main.repository.QuantityMeasurementDatabaseRepository;
import main.service.IQuantityMeasurementService;
import main.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        //  Initialize DB
        DatabaseInitializer.init();

        IQuantityMeasurementRepository repo =
                new QuantityMeasurementDatabaseRepository();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        controller.performComparison(
                new QuantityDTO(1, "FEET", "LENGTH"),
                new QuantityDTO(12, "INCHES", "LENGTH")
        );
    }
}