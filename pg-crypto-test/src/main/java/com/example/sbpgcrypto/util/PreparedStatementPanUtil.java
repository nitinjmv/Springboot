package com.example.sbpgcrypto.util;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

@Component
public class PreparedStatementPanUtil {

    private static String query = "INSERT INTO PAN_TABLE (PAN_ID, PAN_NUMBER, PAN_TYPE, CREATED_DATE, STS) " +
            "VALUES (nextval('PAN_SEQUENCE'), pgp_sym_encrypt(?, '${pgcrypto.secret}'), ?, ?, ?)";

    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement(query);
    }

    public PreparedStatement populatePreparedStatementInsert(
            PreparedStatement preparedStatement, String pan_number, String pan_type, String status)
            throws SQLException {
        preparedStatement.setString(1, pan_number);
        preparedStatement.setString(2, pan_type);
        preparedStatement.setTimestamp(3, Timestamp.from(Instant.now()));
        preparedStatement.setString(4, status);
        return preparedStatement;
    }
}
