package ru.iteco.reportutility.services;

import ru.iteco.reportutility.models.DataRow;

import java.util.List;

/**
 * XlsxReportService.
 *
 * @author Ilya_Sukhachev
 */
public class XlsxReportService extends ReportServiceBase {

    public XlsxReportService(List<String> config) {
        super(config);
    }

    @Override
    protected DataRow[] getDataRows(String text) {
        return new DataRow[0];
    }
}
