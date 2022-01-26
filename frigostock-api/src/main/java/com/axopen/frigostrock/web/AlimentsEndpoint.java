package com.axopen.frigostrock.web;

import com.axopen.frigostrock.AlimentService;
import com.axopen.frigostrock.model.tables.pojos.Aliment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/aliment")
public class AlimentsEndpoint {

    private final AlimentService alimentService;

    public AlimentsEndpoint(AlimentService alimentService) {
        this.alimentService = alimentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Aliment>> getAliments() {
        return ResponseEntity.ok().body(alimentService.getAliment());
    }

    @PostMapping("/")
    public ResponseEntity<Aliment> createAliment(@RequestBody Aliment aliment) {
        return ResponseEntity.ok().body(alimentService.createAliment(aliment.getName(), aliment.getPrice()));
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteAliment(@RequestBody Aliment aliment) {
        alimentService.deleteAliment(aliment.getId());
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/")
    public ResponseEntity<Aliment> modifyAliment(@RequestBody Aliment aliment) {

        return ResponseEntity.ok().body(alimentService.createAliment("carte",100));

    }
}
