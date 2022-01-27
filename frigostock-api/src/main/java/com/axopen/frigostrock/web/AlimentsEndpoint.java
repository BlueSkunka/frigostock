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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/aliment")
public class AlimentsEndpoint {

    private final AlimentService alimentService;

    public AlimentsEndpoint(AlimentService alimentService) {
        this.alimentService = alimentService;
    }

    //get all aliment
    @GetMapping("/")
    public ResponseEntity<List<Aliment>> getAliments() {
        return ResponseEntity.ok().body(alimentService.getAliment());
    }

    //create aliment
    @PostMapping("/")
    public ResponseEntity<Aliment> createAliment(@RequestBody Aliment aliment) {
        return ResponseEntity.ok().body(alimentService.createAliment(aliment.getName(), aliment.getType()));
    }


    @DeleteMapping("/")
    public ResponseEntity<String> deleteAliment(@RequestBody Aliment aliment) throws Exception {
        Boolean res = alimentService.deleteAliment(aliment.getId());

        if(res) {
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.status(200).body("aliment no exist");
        }
    }

    @PutMapping("/")
    public ResponseEntity<Boolean> modifyAliment(@RequestBody Aliment aliment) {

        return ResponseEntity.ok().body(alimentService.modifyAliment(aliment.getId(),aliment.getName(), aliment.getType()));
    }
}
