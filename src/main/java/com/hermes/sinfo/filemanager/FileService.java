package com.hermes.sinfo.filemanager;

import com.hermes.sinfo.domain.Stock;

import java.util.List;

public interface FileService {
    public List<String> getFileList();
    public List<Stock> readFile(String fileName, Integer fileOrder);
}
