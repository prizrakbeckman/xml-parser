package com.epam.xmlparser.model.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "epaper")
public class EPaper {

    @Id
    @GeneratedValue
    private Long id;
    private String newspaperName;
    private Double width;
    private Double height;
    private Double dpi;
    private String filename;
    private Double timeElapsed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewspaperName() {
        return newspaperName;
    }

    public void setNewspaperName(String newspaperName) {
        this.newspaperName = newspaperName;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDpi() {
        return dpi;
    }

    public void setDpi(Double dpi) {
        this.dpi = dpi;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Double getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Double timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}