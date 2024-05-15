package io.h3llo.matriculas.controller;

import io.h3llo.matriculas.model.Student;
import io.h3llo.matriculas.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    //@Autowired // ESTE ESTEREOTIPO O ANOTACIÓN BUSCA UNA INSTANCIA O BEAN DE LA CLASE EN EL IOC CONTAINER E INYECTA LA DEPENDENCIA
    private final IStudentService service; // = new StudentService();

    @GetMapping
    public ResponseEntity<List<Student>> readAll() throws Exception {
        List<Student> list = service.readAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> readById(@PathVariable("id") Integer id) throws Exception {
        Student obj = service.readById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) throws Exception {
        Student obj =  service.save(student);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Integer id, @RequestBody Student student) throws Exception {
        Student obj = service.update(student, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    /*public StudentController(IStudentService service) {
        this.service = service;
    }*/

    /*
    @GetMapping
    public Student save(){
        Student student = new Student(0, "Alberto", "Lazo", "12345678", 25);

        return service.saveAndValid(student);
    }*/


     /*@GetMapping
        public Student getStudents() {
            return new Student(1, "Alberto", "Lazo", "12345678", 25);
        }*/

}
