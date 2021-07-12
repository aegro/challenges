package br.com.aegro.fms.controller;

import br.com.aegro.fms.domain.Farm;
import br.com.aegro.fms.domain.FarmRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/farms")
public class FarmController {

    private final FarmRepository farmRepository;

    public FarmController(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @GetMapping
    public ResponseEntity<List<Farm>> get() {
        List<Farm> farms = farmRepository.findAll();
        if (farms.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(farmRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getById(@PathVariable Long id) {
        Optional<Farm> farm = farmRepository.findById(id);
        if (farm.isPresent()) {
            return ResponseEntity.ok(farm.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Farm> save(@RequestBody Farm farm) {
        return new ResponseEntity<>(farmRepository.save(farm), HttpStatus.CREATED);
    }
}
