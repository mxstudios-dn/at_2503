package utlis;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import modals.Address;
import utils.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;

public class CSVHelper extends Helper {
    List<String[]> csvData = new ArrayList<>();

    public CSVHelper(String filePath) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(filePath));
        csvReader.skip(1);
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            csvData.add(nextRecord);
        }
    }
    public List<Address> getAddress () {
        List<Address> addresses = new ArrayList<>();
        for(String[] row: csvData){
            //System.out.println(row[0]);
            String[] tmpRow = row[0].split("\t");
            addresses.add(new Address(Integer.parseInt(tmpRow[0]),tmpRow[1],tmpRow[2],tmpRow[3],tmpRow[4],tmpRow[5],tmpRow[6],tmpRow[7]));
        }
        return addresses;
    }

    public List<String[]> getCsvData() {
        return this.csvData;
    }
}

