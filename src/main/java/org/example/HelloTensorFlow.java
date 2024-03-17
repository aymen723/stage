package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.tensorflow.TensorFlow;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloTensorFlow {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello TensorFlow " + TensorFlow.version());
        List<Object[]> data = new ArrayList<>();

        try (Reader reader = new FileReader("C:\\All_projects\\table_a.csv");
                CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL)) {
            for (CSVRecord record : csvParser) {
                Object[] row = new Object[record.size()];
                System.out.println(record.size());
                for (int i = 0; i < record.size(); i++) {
                    if (i == 0) {
                        row[i] = Float.parseFloat(record.get(i)); // Numeric
                    } else if (i == 1) {
                        row[i] = record.get(i); // Textual
                    } else if (i == 2) {
                        row[i] = record.get(i); // date
                    } else if (i == 3) {
                        row[i] = record.get(i); // nbr
                    } else {
                        row[i] = record.get(i); // nbr
                    }
                }
                data.add(row);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}