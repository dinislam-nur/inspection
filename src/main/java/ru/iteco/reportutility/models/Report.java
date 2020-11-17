package ru.iteco.reportutility.models;

import java.util.List;

/**
 * Report.
 *
 * @author Ilya_Sukhachev
 */
public class Report {

    private ReportConfig config;
    private DataRow[] data;
    private List<ReportRow> rows;

    public Report(ReportConfig config, DataRow[] data, List<ReportRow> rows) {
        this.config = config;
        this.data = data;
        this.rows = rows;
    }

    public ReportConfig getConfig() {
        return config;
    }

    public void setConfig(ReportConfig config) {
        this.config = config;
    }

    public DataRow[] getData() {
        return data;
    }

    public void setData(DataRow[] data) {
        this.data = data;
    }

    public List<ReportRow> getRows() {
        return rows;
    }

    public void setRows(List<ReportRow> rows) {
        this.rows = rows;
    }
}
