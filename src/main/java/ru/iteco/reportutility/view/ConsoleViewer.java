package ru.iteco.reportutility.view;

import org.apache.commons.lang.StringUtils;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportRow;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleViewer implements Viewer {

    private static final String TAB = "\t";

    private final List<String> config;

    public ConsoleViewer(List<String> config) {
        this.config = config;
    }

    @Override
    public void printReport(Report report) {
        if (report.getData() != null && report.getData().length != 0) {
            //Жесткая связанность с элементами заколовков. Сложно расширять и управлять выводом столбцов
            //TODO Builder заголовка по параметрам
            var headerRow = "Наименование\tОбъём упаковки\tМасса упаковки\tСтоимость\tКоличество";

            if (config.contains("-withIndex")) {
                headerRow = "№\t" + headerRow;
            }
            if (config.contains("-withTotalVolume")) {
                headerRow = headerRow + "\tСуммарный объём";
            }
            if (config.contains("-withTotalWeight")) {
                headerRow = headerRow + "\tСуммарный вес";
            }

            System.out.println(headerRow);
            //NPE report.getData().length
            if (report.getData() != null) {
                for (int i = 0; i < report.getData().length; i++) {
                    var dataRow = report.getData()[i];
                    //Конкантенация строк.
                    //TODO StringBuilder
                    var str = (i + 1 + TAB + dataRow.getName() + ((i != 0) ? StringUtils.repeat(TAB, 2) : TAB)
                            + dataRow.getVolume() + StringUtils.repeat(TAB, 4) + dataRow.getWeight()
                            + StringUtils.repeat(TAB, 4) + dataRow.getCost() + StringUtils.repeat(TAB, 3)
                            + dataRow.getCount() + StringUtils.repeat(TAB, 3) + dataRow.getVolume().multiply(dataRow.getCount())
                            + StringUtils.repeat(TAB, 2) + dataRow.getWeight().multiply(dataRow.getCount()));
                    System.out.println(str);
                }
            }

            System.out.println();
        }

        if (report.getRows() != null && report.getRows().size() != 0) {
            System.out.println("Summary:");
            for (ReportRow reportRow : report.getRows()) {
                System.out.println(reportRow.getName() + TAB + reportRow.getValue());
            }
        }
    }
}
