package com.hermes.sinfo.filemanager;

import java.util.List;

public interface FileService {
    public List<List<String>> readFile();
    void saveData();

}
