package ru.iteco.reportutility;

import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.presenter.PresenterImpl;
import ru.iteco.reportutility.view.ConsoleViewer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Main.
 *
 * @author Ilya_Sukhachev
 */
public class Main {

//    private static final String TAB = "\t";

    // C:\Users\dinis\IdeaProjects\DesignPatterns\inspection\src\main\resources\table.txt -withData -weightSum -costSum
    // C:\Users\dinis\IdeaProjects\DesignPatterns\inspection\src\main\resources\table.csv -withData -weightSum -costSum
    // C:\Users\dinis\IdeaProjects\DesignPatterns\inspection\src\main\resources\table.csv -withData -weightSum -costSum -withTotalVolume -withTotalWeight
    public static void main(String[] args) {
//        ReportService service;
        try {
            System.out.println("");
            System.out.println("Enter the data for the report.");
            var input = new Scanner(System.in);
            // Неинформативное название переменной
            var str = input.nextLine();
            System.out.println(str);
            // Неинформативное название переменной
            var array = str.split(" ");

            //Проблема в добавлении огромного числа расширения файлов.
//            service = getReportService(array);
//            var report = service.createReport(); //Фабричный метод
//            printReport(report);
            //Класс main не должен быть отвественным за выбор сервиса, создания отчета и его
            //прорисовку. Следует разделить функционал на классы по MVP
            final List<String> config = Arrays.asList(array);
            final Report report = new PresenterImpl(config).getReport();
            new ConsoleViewer(config).printReport(report);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    private static ReportService getReportService(String[] args) throws Exception {
//        var filename = args[0];
//
//        if (filename.endsWith(".txt")) {
//            return new TxtReportService(args);
//        }
//
//        if (filename.endsWith(".csv")) {
//            return new CsvReportService(args);
//        }
//
//        if (filename.endsWith(".xlsx")) {
//            return new XlsxReportService(args);
//        }
//
//        throw new Exception("this extension not supported");
//    }

    //Если появится требование выводить отчет не на консоль, а в файл, потребуется добалять новый метод.
    //TODO вынести в отдельный интерфейс рисующий отчеты
//    private static void printReport(Report report) {
//        if (report.getConfig().isWithData() && report.getData() != null && report.getData().length != 0) {
//            var headerRow = "Наименование\tОбъём упаковки\tМасса упаковки\tСтоимость\tКоличество";
//
//            if (report.getConfig().isWithIndex()) {
//                headerRow = "№\t" + headerRow;
//            }
//            if (report.getConfig().isWithTotalVolume()) {
//                headerRow = headerRow + "\tСуммарный объём";
//            }
//            if (report.getConfig().isWithTotalWeight()) {
//                headerRow = headerRow + "\tСуммарный вес";
//            }
//
//            System.out.println(headerRow);
//            for (int i = 0; i < report.getData().length; i++) {
//                var dataRow = report.getData()[i];
//                var str = (i + 1 + TAB + dataRow.getName() + ((i != 0) ? StringUtils.repeat(TAB, 2) : TAB)
//                        + dataRow.getVolume() + StringUtils.repeat(TAB, 4) + dataRow.getWeight()
//                        + StringUtils.repeat(TAB, 4) + dataRow.getCost() + StringUtils.repeat(TAB, 3)
//                        + dataRow.getCount() + StringUtils.repeat(TAB, 3) + dataRow.getVolume().multiply(dataRow.getCount())
//                        + StringUtils.repeat(TAB, 2) + dataRow.getWeight().multiply(dataRow.getCount()));
//                System.out.println(str);
//            }
//
//            System.out.println();
//        }
//
//        if (report.getRows() != null && report.getRows().size() != 0) {
//            System.out.println("Summary:");
//            for (ReportRow reportRow : report.getRows()) {
//                System.out.println(reportRow.getName() + TAB + reportRow.getValue());
//            }
//        }
//    }


}
