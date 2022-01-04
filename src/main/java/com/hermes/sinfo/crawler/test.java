package com.hermes.sinfo.crawler;

import com.hermes.sinfo.filemanager.FileService;
import com.hermes.sinfo.filemanager.FileServiceImpl;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {

    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        FileService fileService = new FileServiceImpl();
        crawler.getCSVfiles();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<List<List<String>>> datas = new ArrayList<>();
        ArrayList<String> fileNames = fileService.getFileNames();
        for (String name : fileNames) {
            datas.add(fileService.readCSV(name));
        }
        for (List<List<String>> data : datas){
            System.out.println("data = " + data);
        }
    }
}
