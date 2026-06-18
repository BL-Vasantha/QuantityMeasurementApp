package main.repository;

import main.entity.QuantityMeasurementEntity;
import main.repository.IQuantityMeasurementRepository;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository {

    @Override
    public void save(QuantityMeasurementEntity entity) {

        String sql = """
            INSERT INTO quantity_measurement
            (operation, result, error)
            VALUES (?, ?, ?)
        """;

        ;
        Statement DBConnection = null;
        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    entity.getOperation()
            );

            ps.setString(
                    2,
                    entity.getResult()
            );

            ps.setString(
                    3,
                    entity.hasError()
                            ? "ERROR"
                            : null
            );

            ps.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                    "DB Save Failed",
                    e
            );
        }
    }
}