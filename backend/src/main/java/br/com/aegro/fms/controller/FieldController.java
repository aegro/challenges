package br.com.aegro.fms.controller;

import br.com.aegro.fms.domain.Field;
import br.com.aegro.fms.domain.FieldRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/fields")
public class FieldController {

    private final FieldRepository fieldRepository;

    public FieldController(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    @GetMapping
    public List<Field> get() {
        return fieldRepository.findAll();
    }

    @GetMapping("/{id}")
    public Field getById(@PathVariable Long id) {
        return fieldRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Field save(@RequestBody Field field) {
        return fieldRepository.save(field);
    }

}
