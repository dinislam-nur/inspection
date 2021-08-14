package ru.iteco.reportutility.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import ru.iteco.reportutility.models.DataRow;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

/**
 * CsvReportService.
 *
 * @author Ilya_Sukhachev
 */
public class CsvReportService extends ReportServiceBase {

    public CsvReportService(List<String> config) {
        super(config);
    }

    @Override
    protected DataRow[] getDataRows(String text) {
        //Промежуточный список, который форматируем в массив
//        var dataRows = new ArrayList<>();
        text = text.substring(text.indexOf("\n") + 1);
        var in = new StringReader(text);
        CSVParser parser;
        List<CSVRecord> list = emptyList();
        try {
            parser = new CSVParser(in, CSVFormat.EXCEL);
            list = parser.getRecords();
        } catch (IOException e) {
            System.out.println(e);
        }

        DataRow[] result = null;
        if (list.size() > 0) {
            result = new DataRow[list.size()];
            for (int i = 0; i < list.size(); i++) {
                var items = list.get(i).get(0).split(";");
                result[i] = new DataRow(new BigDecimal(items[3]), new BigDecimal(items[4]), items[0],
                    new BigDecimal(items[1]), new BigDecimal(items[2]));
            }
        }

//        //NPE
//        for (CSVRecord csvRecord : list) {
//            var items = csvRecord.get(0).split(";");
//            dataRows.add(new DataRow(new BigDecimal(items[3]), new BigDecimal(items[4]), items[0],
//                    new BigDecimal(items[1]), new BigDecimal(items[2])));
//        }
//
//        var result = new DataRow[dataRows.size()];
//        result = dataRows.toArray(result);
        return result;
    }
}
