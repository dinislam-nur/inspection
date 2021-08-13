package ru.iteco.reportutility.infrastructure.transformers;

import ru.iteco.reportutility.infrastructure.DataTransformer;
import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;
import ru.iteco.reportutility.models.ReportRow;

import java.math.BigDecimal;

/**
 * CostSumReportTransformer.
 *
 * @author Ilya_Sukhachev
 */
public class CostSumReportTransformer extends BaseSumReportServiceTransformer {

    public CostSumReportTransformer(DataTransformer dataTransformer) {
        super(dataTransformer);
    }

    @Override
    protected BigDecimal getValue(DataRow element) {
        return element.getCost();
    }

    @Override
    protected String getName() {
        return "Суммарная стоимость";
    }

//    @Override
//    public Report transformData(DataRow[] data) {
//        var report = dataTransformer.transformData(data);
//
//        //Огромное количество повторяющегося кода
//        //TODO вынести в абстрактный класс с использованием Шаблонного метода
//        var value = new BigDecimal(0);
//        for (var element : data) {
//            var result = element.getCount().multiply(element.getCost());
//            value = value.add(result);
//        }
//        report.getRows().add(new ReportRow("Суммарная стоимость", value));
//
//        return report;
//    }
}
