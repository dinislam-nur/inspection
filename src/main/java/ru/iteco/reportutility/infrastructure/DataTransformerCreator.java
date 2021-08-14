package ru.iteco.reportutility.infrastructure;

import ru.iteco.reportutility.dictionary.AggregateFunction;
import ru.iteco.reportutility.infrastructure.transformers.CostSumReportTransformer;
import ru.iteco.reportutility.infrastructure.transformers.CountSumReportTransformer;
import ru.iteco.reportutility.infrastructure.transformers.VolumeSumReportTransformer;
import ru.iteco.reportutility.infrastructure.transformers.WeightSumReportTransformer;
import ru.iteco.reportutility.infrastructure.transformers.WithDataReportTransformer;
import ru.iteco.reportutility.models.ReportConfig;

import java.util.List;

/**
 * DataTransformerCreator.
 *
 * @author Ilya_Sukhachev
 */
public class DataTransformerCreator {

    public static DataTransformer createTransformer(List<String> config) {
        return AggregateFunction.getFinalOperator(config)
                .apply(new ConfigDataTransformer());

//        //Декоратор
//        if (config.isWithData()) {
//            service = new WithDataReportTransformer(service);
//        }
//
//        if (config.isVolumeSum()) {
//            service = new VolumeSumReportTransformer(service);
//        }
//
//        if (config.isWeightSum()) {
//            service = new WeightSumReportTransformer(service);
//        }
//
//        if (config.isCostSum()) {
//            service = new CostSumReportTransformer(service);
//        }
//
//        if (config.isCountSum()) {
//            service = new CountSumReportTransformer(service);
//        }
//
//        return service;
    }

}
