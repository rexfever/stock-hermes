package com.hermes.sinfo.crawler;

import com.hermes.sinfo.filemanager.FileService;
import com.hermes.sinfo.filemanager.FileServiceImpl;
import com.hermes.sinfo.repository.JdbcTemplateTradeLogRepository;
import com.hermes.sinfo.repository.TradeLogRepository;
import org.springframework.jdbc.datasource.DelegatingDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {

    public static void main(String[] args) {
        //Crawler crawler = new Crawler();
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



        List<List<String>> csvList = new ArrayList<>();
        FileService fileService = new FileServiceImpl();


        for(String name : fileNames){
            csvList = fileService.readFile(name);
            System.out.println("name = " + name);
        }
        System.out.println("csvList = " + csvList.toArray().length);
    }
}
