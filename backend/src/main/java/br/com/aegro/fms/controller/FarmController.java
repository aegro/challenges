package br.com.aegro.fms.controller;

import br.com.aegro.fms.domain.Farm;
import br.com.aegro.fms.domain.FarmRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/farms")
public class FarmController {

    private final FarmRepository farmRepository;

    public FarmController(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @GetMapping
    public List<Farm> get() {
        return farmRepository.findAll();
    }

    @GetMapping("/{id}")
    public Farm getById(@PathVariable Long id) {
        return farmRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Farm save(@RequestBody Farm farm) {
        return farmRepository.save(farm);
    }
}
