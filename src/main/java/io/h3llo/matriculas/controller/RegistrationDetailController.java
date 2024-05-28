package io.h3llo.matriculas.controller;

import io.h3llo.matriculas.dto.GenericResponse;
import io.h3llo.matriculas.dto.RegistrationDetailDTO;
import io.h3llo.matriculas.model.RegistrationDetail;
import io.h3llo.matriculas.service.IRegistrationDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/registrationDetails")
@RequiredArgsConstructor
public class RegistrationDetailController {


    private final IRegistrationDetailService service;

    @Qualifier("registrationDetailMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<RegistrationDetailDTO>> readAll() throws Exception {

        List<RegistrationDetailDTO> list = service.readAll().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(new GenericResponse<>(200, "success", new ArrayList<>(list)));
    }


    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<RegistrationDetailDTO>> readById(@PathVariable("id") Integer id) throws Exception {
        RegistrationDetailDTO dto = convertToDto(service.readById(id));
        //return ResponseEntity.ok(new RegistrationDetail());
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(dto)));
    }


    @PostMapping
    public ResponseEntity<RegistrationDetailDTO> save(@Valid @RequestBody RegistrationDetailDTO dto) throws Exception {
        RegistrationDetail obj =  service.save(modelMapper.map(dto, RegistrationDetail.class));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<RegistrationDetailDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody RegistrationDetailDTO dto) throws Exception {
        RegistrationDetail obj = service.update(convertToEntity(dto), id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    ///////////////////////////////// AUXILIARY FUNCTIONS /////////////////////////////////

    private RegistrationDetailDTO convertToDto(RegistrationDetail obj) {
        return modelMapper.map(obj, RegistrationDetailDTO.class);
    }

    private RegistrationDetail convertToEntity(RegistrationDetailDTO dto) {
        return modelMapper.map(dto, RegistrationDetail.class);
    }




}
