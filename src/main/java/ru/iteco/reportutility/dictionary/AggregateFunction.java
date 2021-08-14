package ru.iteco.reportutility.dictionary;

import ru.iteco.reportutility.infrastructure.DataTransformer;
import ru.iteco.reportutility.infrastructure.transformers.*;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public enum AggregateFunction {

    WITH_DATA("-withData", WithDataReportTransformer::new),
    VOLUME_SUM("-volumeSum", VolumeSumReportTransformer::new),
    WEIGHT_SUM("-weightSum", WeightSumReportTransformer::new),
    COST_SUM("-costSum", CostSumReportTransformer::new),
    COUNT_SUM("-countSum", CountSumReportTransformer::new);

    private final String flag;
    private final UnaryOperator<DataTransformer> operator;

    AggregateFunction(String flag, UnaryOperator<DataTransformer> operator) {
        this.flag = flag;
        this.operator = operator;
    }

    public String getFlag() {
        return flag;
    }

    public UnaryOperator<DataTransformer> getOperator() {
        return operator;
    }

    public static Function<DataTransformer, DataTransformer> getFinalOperator(List<String> config) {
        Function<DataTransformer, DataTransformer> operator = UnaryOperator.identity();
        for (AggregateFunction function : AggregateFunction.values()) {
            if (config.contains(function.getFlag())) {
                operator = operator.andThen(function.getOperator());
            }
        }
        return operator;
    }
}
