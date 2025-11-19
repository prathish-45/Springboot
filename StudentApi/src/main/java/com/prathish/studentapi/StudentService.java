package com.prathish.studentapi;

import com.prathish.studentapi.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Students createData (Students students) {
        return studentRepository.save(students);
    }

    public Students getId (Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student is not found"));
    }

    public Page<Students> getAllStudentsPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findAll(pageable);
    }

    public List<Students> getAll () {
        return studentRepository.findAll();
    }

    public Students updateData (Students students) {
        return studentRepository.save(students);
    }

    public void DeleteDataById (Long id) {
        studentRepository.delete(getId(id));
    }

    public void DeleteAllData () {
        studentRepository.deleteAll();
    }
}
