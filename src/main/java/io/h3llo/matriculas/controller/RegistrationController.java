package io.h3llo.matriculas.controller;

import io.h3llo.matriculas.dto.RegistrationDTO;
import io.h3llo.matriculas.dto.RegistrationDetailDTO;
import io.h3llo.matriculas.model.Registration;
import io.h3llo.matriculas.model.RegistrationDetail;
import io.h3llo.matriculas.service.IRegistrationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final IRegistrationService service; // = new RegistrationService();

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RegistrationDTO>> readAll() throws Exception {
        List<RegistrationDTO> list = service.readAll().stream().map( e -> modelMapper.map(e, RegistrationDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDTO> readById(@PathVariable("id") Integer id) throws Exception {
        RegistrationDTO dto = convertToDto(service.readById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<RegistrationDTO> save(@RequestBody RegistrationDTO dto) throws Exception {
        Registration obj =  service.save(modelMapper.map(dto,Registration.class));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<RegistrationDTO> update(@PathVariable("id") Integer id, @RequestBody RegistrationDTO dto) throws Exception {
        Registration obj = service.update(convertToEntity(dto), id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



///////////////////////////////// AUXILIARY FUNCTIONS /////////////////////////////////

    private RegistrationDTO convertToDto(Registration obj) {
        return modelMapper.map(obj, RegistrationDTO.class);
    }

    private Registration convertToEntity(RegistrationDTO dto) {
        return modelMapper.map(dto, Registration.class);
    }



}









