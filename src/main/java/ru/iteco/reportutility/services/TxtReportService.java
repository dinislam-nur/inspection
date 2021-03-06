package ru.iteco.reportutility.services;

import ru.iteco.reportutility.models.DataRow;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * TxtReportService.
 *
 * @author Ilya_Sukhachev
 */
public class TxtReportService extends ReportServiceBase {

    public TxtReportService(List<String> config) {
        super(config);
    }

    @Override
    protected DataRow[] getDataRows(String text) {
        //Промежуточный список
        var dataRows = new ArrayList<>();
        //NPE text.split
        var lines = text.split("\n");

        for (int i = 1; i < lines.length; i++) {
            var items = lines[i].split("\t");
            //Название переменной. Переписать на стримы
            List<String> arrayList = new ArrayList<>();
            for (String item : items) {
                if (!item.isEmpty()) {
                    arrayList.add(item);
                }
            }
            if (arrayList.size() >= 5) {
                dataRows.add(new DataRow(new BigDecimal(arrayList.get(3)), new BigDecimal(arrayList.get(4)),
                        arrayList.get(0), new BigDecimal(arrayList.get(1)), new BigDecimal(arrayList.get(2))));
            }
        }
        var result = new DataRow[dataRows.size()];
        result = dataRows.toArray(result);
        return result;
    }
}
