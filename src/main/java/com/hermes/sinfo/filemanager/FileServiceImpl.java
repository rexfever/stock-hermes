package com.hermes.sinfo.filemanager;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileServiceImpl implements FileService{
    private String path = System.getProperty("user.home") + "/Downloads";
    @Override
    public ArrayList<String> getFileNames() {
        ArrayList<String> fileNames = new ArrayList<>();
        File[] files = new File(path).listFiles();
        String EXTENSIONS = ".csv";
        for(File file : files){
            if(file.isFile()){
                if(EXTENSIONS.contains(file.getName().substring(file.getName().lastIndexOf(".")))){
                    fileNames.add(file.toString());
                }
            }
        }
        Collections.sort(fileNames);
        return fileNames;
    }

    @Override
    public List<List<String>> readCSV(String fileName) {
        List<List<String>> csvList = new ArrayList<List<String>>();

        File csv = new File(fileName);
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                List<String> aLine = new ArrayList<String>();
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
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
        return csvList;
    }
    @Override
    public void saveData() {

    }
}
