package com.prathish.studentapi.contoller;

import com.prathish.studentapi.service.StudentService;
import com.prathish.studentapi.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    ResponseEntity<Students> createStudent (@RequestBody Students students) {
        return new ResponseEntity<>(studentService.createData(students), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Students> getStudentById (@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getId(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    ResponseEntity<List<Students>> getAllId () {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity<Page<Students>> getStudentPage (@RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(studentService.getAllStudentsPage(page, size), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Students> updateStudent (@PathVariable Long id, @RequestBody Students students) {
        students.setId(id);
        return new ResponseEntity<>(studentService.updateData(students), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Students> deleteStudentById (@PathVariable Long id) {
        studentService.DeleteDataById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all")
    ResponseEntity<Students> deleteAllStudents () {
        studentService.DeleteAllData();
        return ResponseEntity.noContent().build();
    }
}
