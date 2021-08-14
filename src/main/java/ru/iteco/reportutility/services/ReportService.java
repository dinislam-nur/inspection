package ru.iteco.reportutility.services;

import ru.iteco.reportutility.models.Report;

import java.io.IOException;

/**
 * ReportService.
 *
 * @author Ilya_Sukhachev
 */
public interface ReportService {

    Report createReport() throws IOException;
}
