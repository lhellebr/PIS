package org.fit.pis.enums;

public enum Opravneni{
	ADMINISTRATOR("Administrátor"), UREDNIK("Úředník"), POLICISTA("Policista");
    private String label;

    private Opravneni(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}