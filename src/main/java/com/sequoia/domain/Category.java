package com.sequoia.domain;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private int id;

    private String code;

    private String name;

    private String parentCode;

    private int level;

    private int status;

    private String creator;

    private Date creationDate;

    private String lastUpdator;

    private Date lastupdateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdator() {
        return lastUpdator;
    }

    public void setLastUpdator(String lastUpdator) {
        this.lastUpdator = lastUpdator;
    }

    public Date getLastupdateDate() {
        return lastupdateDate;
    }

    public void setLastupdateDate(Date lastupdateDate) {
        this.lastupdateDate = lastupdateDate;
    }
}
