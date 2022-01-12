package com.hermes.sinfo.service;

import com.hermes.sinfo.domain.Stock;
import com.hermes.sinfo.repository.JdbcTemplateTradeLogRepository;
import com.hermes.sinfo.repository.TradeLogRepository;

import java.util.List;

public class StockService {

    private final TradeLogRepository tradeLogRepository;

    public StockService(TradeLogRepository tradeLogRepository){
        this.tradeLogRepository = tradeLogRepository;
    }

    public int logging(List<Stock> stocks){
        int[] result = tradeLogRepository.save(stocks);
        return result.length;
    }
}
