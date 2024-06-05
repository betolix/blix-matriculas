package io.h3llo.matriculas.controller;

import io.h3llo.matriculas.dto.QueryDTO;
import io.h3llo.matriculas.model.Course;
import io.h3llo.matriculas.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service; // = new CourseService();

    @GetMapping
    public ResponseEntity<List<Course>> readAll() throws Exception {
        List<Course> list = service.readAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> readById(@PathVariable("id") Integer id) throws Exception {
        Course obj = service.readById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course course) throws Exception {
        Course obj =  service.save(course);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable("id") Integer id, @RequestBody Course course) throws Exception {
        Course obj = service.update(course, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/query")
    public ResponseEntity<List<QueryDTO>> callQuery() {
        List<QueryDTO> list = service.callQuery();
        return ResponseEntity.ok(list);

    }

}
