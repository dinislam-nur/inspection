package ru.iteco.reportutility.infrastructure;

import ru.iteco.reportutility.models.DataRow;
import ru.iteco.reportutility.models.Report;

/**
 * DataTransformer.
 *
 * @author Ilya_Sukhachev
 */
public interface DataTransformer {

    Report transformData(DataRow[] data);
}
