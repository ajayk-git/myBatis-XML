package com.mybatis.Student.mongoDB;
import com.mybatis.Student.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectMongoService {

    @Autowired
    SubjectMongoRepository subjectMongoRepository;


    public List<SubjectDto> getAllSubjects() {
        List<Subjects> subjectsList = subjectMongoRepository.findAll();

        List<SubjectDto> subjectDtoList = new ArrayList<>();
        subjectsList.forEach(subjects -> subjectDtoList.add(new SubjectDto(subjects.getPaperName())));
        if (subjectsList.isEmpty())
            throw new ResourceNotFound("No Subjects Found.");
        return subjectDtoList;

    }
}
