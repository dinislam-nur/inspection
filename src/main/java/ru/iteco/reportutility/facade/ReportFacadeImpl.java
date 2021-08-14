package ru.iteco.reportutility.facade;

import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.services.*;

import java.util.List;

public class ReportFacadeImpl implements ReportFacade {

    private final List<String> config;
    private final ReportPrinter printer;

    public ReportFacadeImpl(List<String> config, ReportPrinter printer) {
        this.config = config;
        this.printer = printer;
    }

    @Override
    public void printReport() {
        try {
            final Report report = getReportService().createReport();
            printer.printReport(report);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private ReportService getReportService() throws Exception {
        var fileName = config.get(0);

        if (fileName.endsWith(".txt")) {
            return new TxtReportService(config);
        }

        if (fileName.endsWith(".csv")) {
            return new CsvReportService(config);
        }

        if (fileName.endsWith(".xlsx")) {
            return new XlsxReportService(config);
        }

        throw new Exception("this extension not supported");
    }

}
