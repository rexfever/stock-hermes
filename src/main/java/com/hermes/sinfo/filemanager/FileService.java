package com.hermes.sinfo.filemanager;

import java.util.List;

public interface FileService {
    public List<String> getFileList();
    public List<List<String>> readFile(String fileName);
    void saveData();

}
