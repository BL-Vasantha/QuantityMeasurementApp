package main;

import main.controller.QuantityMeasurementController;
import main.dto.QuantityDTO;
import main.repository.IQuantityMeasurementRepository;
import main.repository.QuantityMeasurementCacheRepository;
import main.service.IQuantityMeasurementService;
import main.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // Factory + DI
        IQuantityMeasurementRepository repo =
                QuantityMeasurementCacheRepository.getInstance();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        // Example Usage
        controller.performComparison(
                new QuantityDTO(1, "FEET", "LENGTH"),
                new QuantityDTO(12, "INCHES", "LENGTH")
        );

        controller.performConversion(
                new QuantityDTO(100, "CELSIUS", "TEMPERATURE"),
                "FAHRENHEIT"
        );

        controller.performAddition(
                new QuantityDTO(1, "KILOGRAM", "WEIGHT"),
                new QuantityDTO(1000, "GRAM", "WEIGHT")
        );
    }
}