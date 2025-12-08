package utils;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper extends Helper {

    List<String[]> csvData = new ArrayList<>();

    public CSVHelper(String filePath) throws IOException, CsvException {
        logger.info("Loading CSV file: {}", filePath);
        FileReader filereader = new FileReader(filePath);
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;

        this.csvData = csvReader.readAll();
        logger.debug("CSV data loaded: {} rows", csvData.size());

        // we are going to read data line by line
        while ((nextRecord = csvReader.readNext()) != null) {
            
        }
    }

    public List<String[]> getCsvData() {
        return this.csvData;
    }
}
