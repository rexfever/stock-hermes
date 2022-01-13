package com.hermes.sinfo.service;

import com.hermes.sinfo.domain.Stock;
import com.hermes.sinfo.repository.JdbcTemplateTradeLogRepository;
import com.hermes.sinfo.repository.TradeLogRepository;

import javax.sql.DataSource;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileService {

    public List<String> getFileList() {
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
        return fileNames;
    }

    public List<Stock> readFile(String fileName, Integer fileOrder) {
        List<Stock> stocks = new ArrayList<>();
        File csv = new File(fileName);
        BufferedReader br = null;
        String line = "";
        String market = "KOSPI";
        String buyer = "기관";
        if( fileOrder > 1) {
            market = "KOSDAQ";
        }
        if(fileOrder%2 == 1){
            buyer = "외국인";
        }
        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                Stock stock = new Stock();
                String[] values = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                stock.setValues(values[0],values[1],"20220110", values[2],values[3],values[4],values[5],values[6],values[7],market,buyer);
                stocks.add(stock);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close(); // 사용 후 BufferedReader를 닫아준다.
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return stocks;
    }

}

