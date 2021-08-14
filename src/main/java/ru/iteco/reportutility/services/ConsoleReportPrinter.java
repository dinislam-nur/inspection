package ru.iteco.reportutility.services;

import org.apache.commons.lang.StringUtils;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportRow;

import java.util.List;

public class ConsoleReportPrinter implements ReportPrinter {

    private static final String TAB = "\t";

    private final List<String> config;

    public ConsoleReportPrinter(List<String> config) {
        this.config = config;
    }

    @Override
    public void printReport(Report report) {
        if (report.getData() != null && report.getData().length != 0) {
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
            for (int i = 0; i < report.getData().length; i++) {
                var dataRow = report.getData()[i];
                var str = (i + 1 + TAB + dataRow.getName() + ((i != 0) ? StringUtils.repeat(TAB, 2) : TAB)
                        + dataRow.getVolume() + StringUtils.repeat(TAB, 4) + dataRow.getWeight()
                        + StringUtils.repeat(TAB, 4) + dataRow.getCost() + StringUtils.repeat(TAB, 3)
                        + dataRow.getCount() + StringUtils.repeat(TAB, 3) + dataRow.getVolume().multiply(dataRow.getCount())
                        + StringUtils.repeat(TAB, 2) + dataRow.getWeight().multiply(dataRow.getCount()));
                System.out.println(str);
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