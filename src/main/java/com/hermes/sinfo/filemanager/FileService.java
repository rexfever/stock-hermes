package com.hermes.sinfo.filemanager;

import java.util.ArrayList;
import java.util.List;

public interface FileService {
    public ArrayList<String> getFileNames();
    public List<List<String>> readCSV(String fileName);
    void saveData();

}
