package com.mybatis.Student.dtos;


public class StudentSearchDTO {
    String studentFirstName;
    String studentLastName;
    Long departmentId;
    Long studentCity;

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(Long studentCity) {
        this.studentCity = studentCity;
    }
}
