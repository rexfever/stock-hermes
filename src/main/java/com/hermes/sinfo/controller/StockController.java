package com.hermes.sinfo.controller;

import com.hermes.sinfo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StockController {

        private final StockService stockService;

        @Autowired
        public StockController(StockService stockService){
            this.stockService = stockService;
        }
}
