package com.game;

public enum ExportFormat {
    CSV("csv"),
    JSON("json"),
    TXT("txt");

    private final String extension;

    ExportFormat(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
