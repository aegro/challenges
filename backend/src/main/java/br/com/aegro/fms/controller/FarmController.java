package br.com.aegro.fms.controller;

import br.com.aegro.fms.domain.Farm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/farms")
public class FarmController {

    @GetMapping
    public List<Farm> get() {
        return List.of();
    }

    @GetMapping("/{id}")
    public Farm getById(@PathVariable("id") long id) {
        Farm farm = new Farm();
        farm.setId(id);
        farm.setName("Fazenda Aegro");
        return farm;
    }
}
