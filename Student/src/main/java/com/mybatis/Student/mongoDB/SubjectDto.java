package com.mybatis.Student.mongoDB;

public class SubjectDto {
    String subject;

    public SubjectDto(String paperName) {
        this.subject=paperName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
