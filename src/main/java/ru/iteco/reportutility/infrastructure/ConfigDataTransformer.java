package ru.iteco.reportutility.infrastructure;

import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportConfig;

import java.util.ArrayList;

/**
 * ConfigDataTransformer.
 *
 * @author Ilya_Sukhachev
 */
public class ConfigDataTransformer implements DataTransformer {

    private final ReportConfig config;

    public ConfigDataTransformer(ReportConfig config) {
        this.config = config;
    }

    @Override
    public Report transformData(DataRow[] data) {
        return new Report(config, new DataRow[0], new ArrayList<>());
    }
}
