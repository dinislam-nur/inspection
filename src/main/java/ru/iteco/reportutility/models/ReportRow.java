package ru.iteco.reportutility.models;

import java.math.BigDecimal;

/**
 * ReportRow.
 *
 * @author Ilya_Sukhachev
 */
public class ReportRow {

    private String name;
    private BigDecimal value;

    public ReportRow(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
