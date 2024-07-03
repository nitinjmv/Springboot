package com.example.sbpgcrypto.repository;

import com.example.sbpgcrypto.config.PostgresConfig;
import com.example.sbpgcrypto.dto.BulkPansDto;
import com.example.sbpgcrypto.util.PreparedStatementAccountUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BulkPanRepository {

    private final PostgresConfig dbConfig;

    private final PreparedStatementAccountUtil preparedStatementUtil;
    private Connection connection;

    private PreparedStatement preparedStatement;

    public void savePans(BulkPansDto bulkPansDto, String account_type, String status) {
        try {
            List<String> accounts = bulkPansDto.getPans();
            Collections.sort(accounts);

            connection = dbConfig.pgDataSource().getConnection();
            connection.setAutoCommit(false);

            preparedStatement = preparedStatementUtil.createPreparedStatement(connection);

            for (String account : accounts) {
                preparedStatement = preparedStatementUtil.populatePreparedStatementInsert(preparedStatement,
                        account, account_type, status);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

            connection.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
