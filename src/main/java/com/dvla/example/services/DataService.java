package com.dvla.example.services;


import com.dvla.example.servicehelpers.DataServiceHelpers;
import cucumber.api.DataTable;
import cucumber.api.Transformer;
import cucumber.runtime.ParameterInfo;
import cucumber.runtime.table.TableConverter;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.formatter.model.Comment;
import gherkin.formatter.model.DataTableRow;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


@Service
public class DataService extends Transformer<DataTable> {

    public String readFileMimeType(String filename) throws IOException {
        DataServiceHelpers serviceHelpers = new DataServiceHelpers();
        return serviceHelpers.getMimeTypeOfFileInDirectory(filename);
    }

    public String readFileSizeInKb(String filename) throws IOException {
        DataServiceHelpers serviceHelpers = new DataServiceHelpers();
        return serviceHelpers.getFileSizeInKbWithinDirectory(filename);
    }

    public String readFileExtension(String fileName) throws IOException {
        DataServiceHelpers serviceHelpers = new DataServiceHelpers();
        return serviceHelpers.getFileExtensionOfFileWithinDirectory(fileName);
    }

    @Override
    public DataTable transform(String fileName) {
        DataServiceHelpers serviceHelpers = null;
        try {
            serviceHelpers = new DataServiceHelpers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<List<String>> csvData = new LinkedList<>();
        try {
            csvData = serviceHelpers.readFileDataRecord(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<DataTableRow> dataTableRows = new LinkedList<>();
        int line = 1;
        for(List<String> list: csvData){
            Comment comment = new Comment(line +"", line);
            DataTableRow tableRow = new DataTableRow(Arrays.asList(comment), list, line++);
            dataTableRows.add(tableRow);
        }

        ParameterInfo parInfo = new ParameterInfo(null, null, null, null);
        TableConverter tableConverter = new TableConverter(new LocalizedXStreams(Thread.currentThread().getContextClassLoader()).get(Locale.getDefault()),parInfo);
        DataTable table = new DataTable(dataTableRows, tableConverter);
        return table;
    }
}
