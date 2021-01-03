package com.mybatis.Student.mongoDB;

public class StudentResultDto {
        String standard;
        String subject;
        Float averageMarks;

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Float getAverageMarks() {
        return averageMarks;
    }

    public void setAverageMarks(Float averageMarks) {
        this.averageMarks = averageMarks;
    }
}
