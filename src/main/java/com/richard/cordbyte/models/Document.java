package com.richard.cordbyte.models;

public class Document {

    private String name;
    private String MimeType;
    private long size;
    private String extension;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return MimeType;
    }

    public void setMimeType(String mimeType) {
        MimeType = mimeType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", MimeType='" + MimeType + '\'' +
                ", size=" + size +
                ", extension='" + extension + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
