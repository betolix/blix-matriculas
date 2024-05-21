package io.h3llo.matriculas.controller;

import io.h3llo.matriculas.dto.GenericResponse;
import io.h3llo.matriculas.dto.StudentDTO;
import io.h3llo.matriculas.dto.StudentRecord;
import io.h3llo.matriculas.model.Student;
import io.h3llo.matriculas.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    //@Autowired // ESTE ESTEREOTIPO O ANOTACIÓN BUSCA UNA INSTANCIA O BEAN DE LA CLASE EN EL IOC CONTAINER E INYECTA LA DEPENDENCIA
    private final IStudentService service; // = new StudentService();
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<StudentDTO>> readAll() throws Exception {

        // List<StudentRecord> list = service.readAll().stream().map(e -> new StudentRecord(e.getId_student(), e.getName(), e.getLastname(), e.getDni(), e.getAge())).toList();
        List<StudentDTO> list = service.readAll().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(new GenericResponse<>(200, "success", new ArrayList<>(list)));
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception {
        StudentDTO dto = convertToDto(service.readById(id));
        //return ResponseEntity.ok(new Student());
        return ResponseEntity.ok(dto);
    }
     */

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>> readById(@PathVariable("id") Integer id) throws Exception {
        StudentDTO dto = convertToDto(service.readById(id));
        //return ResponseEntity.ok(new Student());
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(dto)));
    }


    @PostMapping
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO dto) throws Exception {
        Student obj =  service.save(modelMapper.map(dto, Student.class));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @RequestBody StudentDTO dto) throws Exception {
        // dto.setId_student(id);
        Student obj = service.update(convertToEntity(dto), id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    ///////////////////////////////// AUXILIARY FUNCTIONS /////////////////////////////////

    private StudentDTO convertToDto(Student obj) {
        return modelMapper.map(obj, StudentDTO.class);
    }

    private Student convertToEntity(StudentDTO dto) {
        return modelMapper.map(dto, Student.class);
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
