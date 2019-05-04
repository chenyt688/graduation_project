package com.cyt.graduation_project.business.entry.position;

public class Selection {
    private String label;
    private long value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Selection(String label, int value) {

        this.label = label;
        this.value = value;
    }

    public Selection() {

    }
}
