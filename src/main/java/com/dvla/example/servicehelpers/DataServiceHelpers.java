package com.dvla.example.servicehelpers;

import java.io.*;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

public class DataServiceHelpers {

    public List<File> files;

    public DataServiceHelpers() throws IOException {
    	File folder = new File("src//main//resources//testdatafiles");
    	File filesArray[] = folder.listFiles();
    	files = Arrays.asList(filesArray);
    }

    public File getSpecificFileFromAllFilesWithinFolder(String fileName){

        File fileToReturn = null;
        for (File file: files) {
            if(file.getName().matches(fileName)){
                fileToReturn = file;
            }

        }
        return fileToReturn;

    }

    public List<List<String>> readFileDataRecord(String filename) throws IOException{

        List<List<String>> records = new ArrayList<List<String>>();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getSpecificFileFromAllFilesWithinFolder(filename)));
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return records;

    }

    public String getMimeTypeOfFileInDirectory(String filename) {
        return URLConnection.guessContentTypeFromName(getSpecificFileFromAllFilesWithinFolder(filename).getName());
    }

    public String getFileSizeInKbWithinDirectory(String filename) {
        return (int) getSpecificFileFromAllFilesWithinFolder(filename).length() / 1024 + " kb";
    }

    public String getFileExtensionOfFileWithinDirectory(String filename) {
        return FilenameUtils.getExtension(this.getSpecificFileFromAllFilesWithinFolder(filename).getName());
    }
}
