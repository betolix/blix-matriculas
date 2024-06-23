package io.h3llo.matriculas.controller;

import io.h3llo.matriculas.dto.CourseDTO;
import io.h3llo.matriculas.dto.QueryDTO;
import io.h3llo.matriculas.dto.RegistrationDetailDTO;
import io.h3llo.matriculas.model.Course;
import io.h3llo.matriculas.model.RegistrationDetail;
import io.h3llo.matriculas.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service; // = new CourseService();

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> readAll() throws Exception {
        // List<CourseDTO> list = service.readAll().stream().map( e -> new CourseDTO(e.getId_course(), e.getName(), e.getAbbr(), e.isStatus())).toList();
        List<CourseDTO> list = service.readAll().stream().map( e -> modelMapper.map(e, CourseDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> readById(@PathVariable("id") Integer id) throws Exception {
        CourseDTO dto = convertToDto(service.readById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@RequestBody CourseDTO dto) throws Exception {
        Course obj =  service.save(modelMapper.map(dto, Course.class));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable("id") Integer id, @RequestBody CourseDTO dto) throws Exception {
        Course obj = service.update(convertToEntity(dto), id);
        return ResponseEntity.ok(convertToDto(obj));
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

///////////////////////////////// AUXILIARY FUNCTIONS /////////////////////////////////

    private CourseDTO convertToDto(Course obj) {
        return modelMapper.map(obj, CourseDTO.class);
    }

    private Course convertToEntity(CourseDTO dto) {
        return modelMapper.map(dto, Course.class);
    }




}











