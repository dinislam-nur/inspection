package ru.iteco.reportutility.presenter;

import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.services.*;

import java.util.List;

public class PresenterImpl implements Presenter {

    private final List<String> config;

    public PresenterImpl(List<String> config) {
        this.config = config;
    }

    @Override
    public Report getReport() throws Exception {
        return getReportService().createReport();
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
