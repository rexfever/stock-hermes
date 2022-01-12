package com.hermes.sinfo;

import com.hermes.sinfo.repository.JdbcTemplateTradeLogRepository;
import com.hermes.sinfo.repository.StockDAO;
import com.hermes.sinfo.repository.TradeLogRepository;
import com.hermes.sinfo.service.FileService;
import com.hermes.sinfo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    private final DataSource dataSource;

    public DBConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public StockService stockService(){
        return new StockService(tradeLogRepository());
    }

    @Bean
    public TradeLogRepository tradeLogRepository(){
        return new JdbcTemplateTradeLogRepository(dataSource);
    }

    @Bean
    StockDAO stockDAO(){
        return new StockDAO(dataSource);
    }
}
