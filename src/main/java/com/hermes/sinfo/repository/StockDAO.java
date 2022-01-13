package com.hermes.sinfo.repository;

import com.hermes.sinfo.domain.Stock;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StockDAO {

    private JdbcTemplate jdbcTemplate;

    public StockDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int[] save(List<Stock> stocks) {
        String sql = "INSERT INTO TRADE_LOG( LOG_CODE, LOG_DATE, LOG_NAME, LOG_SVOLUME, LOG_BVOLUME, LOG_PSVOLUME, LOG_PBVOLUME, LOG_SPAYENNT, LOG_BPAYMENT, LOG_MARKET, LOG_BUYER) values (?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Stock stock = stocks.get(i);
                ps.setString(1, stock.getCode());
                ps.setString(2, stock.getDate());
                ps.setString(3, stock.getName());
                ps.setString(4, stock.getSvoluem());
                ps.setString(5, stock.getBvolume());
                ps.setString(6, stock.getPsvolume());
                ps.setString(7, stock.getPbvolume());
                ps.setString(8, stock.getSpayment());
                ps.setString(9, stock.getBpayment());
                ps.setString(10, stock.getMarket());
                ps.setString(11, stock.getBuyer());
            }

            @Override
            public int getBatchSize() {
                return stocks.size();
            }
        });
    }
}
