package com.hermes.sinfo.crawler;

import com.hermes.sinfo.DBConfig;
import com.hermes.sinfo.controller.StockController;
import com.hermes.sinfo.domain.Stock;
import com.hermes.sinfo.repository.JdbcTemplateTradeLogRepository;
import com.hermes.sinfo.repository.StockDAO;
import com.hermes.sinfo.repository.TradeLogRepository;
import com.hermes.sinfo.service.FileService;
import com.hermes.sinfo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class test {

    StockController stockController;
    private static StockDAO stockDAO;
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);
        stockDAO = ctx.getBean(StockDAO.class);
        //Crawler crawler = new Crawler();
        /*
        String path = System.getProperty("user.home") + "/Downloads";
        List<String> fileNames = new ArrayList<>();
        File[] files = new File(path).listFiles();
        String EXTENSIONS = ".csv";
        for(File file : files){
            if(file.isFile()){
                if(file.getName().indexOf("data_") < 0){
                    continue;
                }
                if(EXTENSIONS.contains(file.getName().substring(file.getName().lastIndexOf(".")))){
                    System.out.println("file = " + file);
                    fileNames.add(file.toString());
                }
            }
        }
        Collections.sort(fileNames);
*/


        List<Stock> stockList = new ArrayList<>();
        FileService fileService = new FileService();
        List<String> fileNames = fileService.getFileList();
        int order = 0;
        for(String name : fileNames){
            stockList = fileService.readFile(name,order);
            order++;
            System.out.println("name = " + name);

        }
        System.out.println("stockList = " + stockList.toArray().length);

        stockDAO.save(stockList);
        ctx.close();

    }





}
