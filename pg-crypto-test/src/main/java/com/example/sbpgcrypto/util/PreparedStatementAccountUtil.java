package com.example.sbpgcrypto.util;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

@Component
public class PreparedStatementAccountUtil {

    private static String query = "INSERT INTO ACCT_TABLE (ACCOUNT_ID, ACCOUNT_NUMBER, ACCOUNT_TYPE, CREATED_DATE, STS) " +
            "VALUES (nextval('ACCOUNT_SEQUENCE'), pgp_sym_encrypt(?, '${pgcrypto.secret}'), ?, ?, ?)";

    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement(query);
    }

    public PreparedStatement populatePreparedStatementInsert(
            PreparedStatement preparedStatement, String account_number, String account_type, String status)
            throws SQLException {
        preparedStatement.setString(1, account_number);
        preparedStatement.setString(2, account_type);
        preparedStatement.setTimestamp(3, Timestamp.from(Instant.now()));
        preparedStatement.setString(4, status);
        return preparedStatement;
    }
}
