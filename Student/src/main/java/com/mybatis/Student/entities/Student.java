package com.mybatis.Student.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

//@Getter
//@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    Long studentId;

//    @NotNull(message = "firstName can not be null.")
    String firstName;

//    @NotNull(message = "firstName can not be null.")
    String lastName;

    @NotNull(message = "firstName can not be null.")
    String fatherName;

    @NotNull(message = "firstName can not be null.")
    String city;

    @NotNull(message = "firstName can not be null.")
    String contactNumber;

    @NotNull(message = "firstName can not be null.")
    Integer standard;

    Boolean isDeleted;

    Boolean isActive;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
