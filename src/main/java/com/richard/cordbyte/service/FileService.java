package com.richard.cordbyte.service;

import com.richard.cordbyte.models.Document;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileService {

    public List<Document> getAllDocsFromDirectory(String path) {

        File directory = new File(path);
        List<Document> dirDocs = new ArrayList<Document>();
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    dirDocs.add(createDoc(file));
                }
            }
        }
        return dirDocs;
    }


    public List<Document> getExelDocsFromDirectory(String path) {

        File directory = new File(path);
        List<Document> excelDocs = new ArrayList<Document>();
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                String fileExt = getFileExt(file.getAbsolutePath());
                if (file.isFile() && isExcelFileExt(fileExt)) {
                    excelDocs.add(createDoc(file));
                }
            }
        }
        return excelDocs;
    }

    public List<Document> getCSVDocsFromDirectory(String path) {

        File directory = new File(path);
        List<Document> csvDocs = new ArrayList<Document>();

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".csv"));

        if (files != null) {
            for (File file : files) {

                csvDocs.add(createDoc(file));
            }
        }
        return csvDocs;
    }


    private Document createDoc(File file) {

        Document doc = new Document();
        doc.setName(file.getName());
        doc.setMimeType(getMimeType(file.getPath()));
        doc.setSize(file.length());
        doc.setExtension(getFileExt(file.getName()));
        doc.setPath(file.getAbsolutePath());

        return doc;

    }

    private String getMimeType(String filePath) {

        MimetypesFileTypeMap mimeType = new MimetypesFileTypeMap();

        return mimeType.getContentType(filePath);
    }

    private String getFileExt(String fileName) {

        int indexOfExtDot = fileName.lastIndexOf(".");

        //extension name starts right after the dot
        return fileName.substring(indexOfExtDot + 1);
    }

    private boolean isExcelFileExt(String ext) {

        String[] excelExts = new String[]{"xls", "xlt", "xlm", "xlsx", "xlsm", "xltm", "xslb", "xla", "xlam", "xll", "xlw"};

        List<String> excelFormats = Arrays.asList(excelExts);

        return excelFormats.contains(ext);
    }

}
