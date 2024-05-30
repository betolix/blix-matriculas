package io.h3llo.matriculas.controller;

import io.h3llo.matriculas.model.Registration;
import io.h3llo.matriculas.service.IRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final IRegistrationService service; // = new RegistrationService();

    @GetMapping
    public ResponseEntity<List<Registration>> readAll() throws Exception {
        List<Registration> list = service.readAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> readById(@PathVariable("id") Integer id) throws Exception {
        Registration obj = service.readById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Registration> save(@RequestBody Registration registration) throws Exception {
        Registration obj =  service.save(registration);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Registration> update(@PathVariable("id") Integer id, @RequestBody Registration registration) throws Exception {
        Registration obj = service.update(registration, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
