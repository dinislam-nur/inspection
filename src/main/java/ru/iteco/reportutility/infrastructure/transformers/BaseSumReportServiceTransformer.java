package ru.iteco.reportutility.infrastructure.transformers;

import ru.iteco.reportutility.infrastructure.DataTransformer;
import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportRow;

import java.math.BigDecimal;

public abstract class BaseSumReportServiceTransformer extends ReportServiceTransformerBase {

    protected BaseSumReportServiceTransformer(DataTransformer dataTransformer) {
        super(dataTransformer);
    }

    @Override
    public Report transformData(DataRow[] data) {
        var report = dataTransformer.transformData(data);

        var value = new BigDecimal(0);
        for (var element : data) {
            var result = element.getCount().multiply(getValue(element));
            value = value.add(result);
        }
        report.getRows().add(new ReportRow(getName(), value));

        return report;
    }

    protected abstract BigDecimal getValue(DataRow element);

    protected abstract String getName();
}
