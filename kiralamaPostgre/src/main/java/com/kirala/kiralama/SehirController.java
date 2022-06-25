package com.kirala.kiralama;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Type-C
 */
@CrossOrigin
@RestController
@RequestMapping("/Sehir")
public class SehirController {

    @Autowired
    private SehirRepository sehirRepository;

    @GetMapping("/getAll")
    public List<Sehir> getAllSehirs() {
        return sehirRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Sehir> getSehirById(@PathVariable("id") Long id) {
        Sehir sehir = findById(id);
        
        if (sehir == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(sehir, HttpStatus.OK);
        }
    }
    
    public Sehir findById(Long id) {
        List<Sehir> sehirData = sehirRepository.findAll();

        for (Sehir sehir : sehirData) {
            if (Objects.equals(sehir.getSehirId(), id)) {
                return sehir;
            }
        }
        return null;
    }
}
