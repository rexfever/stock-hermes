package com.hermes.sinfo.repository;

import com.hermes.sinfo.domain.Stock;

import java.util.List;

public interface TradeLogRepository {
    int[] save(List<Stock> stock);
    Stock getTop5ByInstitutional(Integer today);
    Stock getTop5ByForeiger(Integer today);
    Stock getTop10ByPayment(Integer today);
}
