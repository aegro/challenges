package br.com.aegro.fms.controller;

import br.com.aegro.fms.domain.Field;
import br.com.aegro.fms.domain.FieldRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/fields")
public class FieldController {

    private final FieldRepository fieldRepository;

    public FieldController(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    @GetMapping
    public ResponseEntity<List<Field>> get() {
        List<Field> fields = fieldRepository.findAll();
        if (fields.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fieldRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Field> getById(@PathVariable Long id) {
        Optional<Field> field = fieldRepository.findById(id);
        if (field.isPresent()) {
            return ResponseEntity.ok(field.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Field> save(@RequestBody Field field) {
        return new ResponseEntity<>(fieldRepository.save(field), HttpStatus.CREATED);
    }

}
