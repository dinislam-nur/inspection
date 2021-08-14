package ru.iteco.reportutility.services;

import ru.iteco.reportutility.infrastructure.DataTransformerCreator;
import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * ReportServiceBase.
 *
 * @author Ilya_Sukhachev
 */
public abstract class ReportServiceBase implements ReportService {

    private final List<String> config;

    protected ReportServiceBase(List<String> config) {
        this.config = config;
    }

    @Override
    public Report createReport() throws IOException {
//        var config = parseConfig();
        var dataTransformer = DataTransformerCreator.createTransformer(config);

        var data = getDataRows(Files.readString(Paths.get(config.get(0))));
        return dataTransformer.transformData(data);
    }

    //Шаблонный метод
    protected abstract DataRow[] getDataRows(String text) throws IOException;

    //Вынести в отдельный утилитарный метод
//    private ReportConfig parseConfig() {
//        //Проблема с большим конструктором. С добавлением новых агрегаций конструктор будет только расширяться
//        //Повторяющий код - Arrays.asList(args).contains() и порождение схожих бесполезных обьектов
//        //TODO Builder
//        return new ReportConfig(Arrays.asList(args).contains("-withData"), Arrays.asList(args).contains("-withIndex"),
//                Arrays.asList(args).contains("-withTotalVolume"), Arrays.asList(args).contains("-withTotalWeight"),
//                Arrays.asList(args).contains("-volumeSum"), Arrays.asList(args).contains("-weightSum"),
//                Arrays.asList(args).contains("-costSum"), Arrays.asList(args).contains("-countSum"));
//    }

}
