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

public class test {

    public static void main(String[] args) {
        //Crawler crawler = new Crawler();
        String path = System.getProperty("user.home") + "/Downloads";
        ArrayList<String> fileNames = new ArrayList<>();
        File[] files = new File(path).listFiles();
        String EXTENSIONS = ".csv";
        for(File file : files){
            if(file.isFile()){
                if(EXTENSIONS.contains(file.getName().substring(file.getName().lastIndexOf(".")))){
                    System.out.println("file = " + file);
                    fileNames.add(file.toString());
                }
            }
        }
        Collections.sort(fileNames);
        for(String name : fileNames){
            System.out.println("name = " + name);
        }

    }
}
