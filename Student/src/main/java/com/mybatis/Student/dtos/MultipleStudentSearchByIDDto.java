package com.mybatis.Student.dtos;

import java.util.List;

public class MultipleStudentSearchByIDDto {
    List<Integer> studentIds;

    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }
}
