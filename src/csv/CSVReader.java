package csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {

    public static ArrayList<String[]> readCSV(File csv) throws FileNotFoundException {
        Scanner scan = new Scanner(csv);
        ArrayList<String[]> records = new ArrayList<String[]>();
        String[] record = new String[2];
        while(scan.hasNext())
        {
            record = scan.nextLine().split(",");
            records.add(record);
        }

        return records;
    }
}
