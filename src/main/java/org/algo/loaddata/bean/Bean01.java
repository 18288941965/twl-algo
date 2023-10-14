package org.algo.loaddata.bean;

import java.time.LocalDate;

public class Bean01 {
    private String type;
    private Integer number;
    private String document;
    private Integer description;
    private LocalDate date;
    private Double amount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bean01{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", document='" + document + '\'' +
                ", description=" + description +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
