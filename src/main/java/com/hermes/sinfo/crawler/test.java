package com.hermes.sinfo.crawler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test {

    public static void main(String[] args) {
        System.out.println("Buyer name : " + Market.KOSPI.getCodeOfMarket());
        System.out.println("Buyer name : " + Market.KOSDAQ.getCodeOfMarket());
        System.out.println("Buyer name : " + Buyer.INSTITUTIONAL.getCodeOfBuyer());
        System.out.println("Buyer name : " + Buyer.FOREIGN.getCodeOfBuyer());
        System.out.println("Dirver  : " + Crawler.WEB_DRIVER_PATH);

        //new Crawler();
        for(Market m : Market.values()){
            System.out.println("m = " + m);
        }
    }
}
