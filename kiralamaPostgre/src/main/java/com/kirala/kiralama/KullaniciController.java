package com.kirala.kiralama;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Type-C
 */
@CrossOrigin
@RestController
@RequestMapping("/Kullanici")
public class KullaniciController {

    @Autowired
    private KullanıcıRepository kullaniciRepository;

    @GetMapping("/getAll")
    public List<Kullanici> getAllKullanici() {
        return kullaniciRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Kullanici> getKullaniciById(@PathVariable("id") String id) {
        Kullanici kullanici = findById(id);

        if (kullanici == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(kullanici, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Kullanici> createKullanici(@RequestBody Kullanici kullanici) {
        try {
            Kullanici _kullanici = kullaniciRepository
                    .save(new Kullanici(
                            kullanici.getKullaniciID(),
                            kullanici.getAdSoyad(),
                            kullanici.getSifre(),
                            kullanici.getMail(),
                            kullanici.getSehirID(),
                            kullanici.getUrunID()));
            return new ResponseEntity<>(_kullanici, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateByID/{id}")
    public ResponseEntity<Kullanici> updateKullanici(@PathVariable("id") String id, @RequestBody Kullanici kullanici) {
        Kullanici findedKullanici = findById(id);

        if (findedKullanici != null) {
            findedKullanici.setAdSoyad(kullanici.getAdSoyad());
            findedKullanici.setSehirID(kullanici.getSehirID());
            findedKullanici.setKullaniciID(kullanici.getKullaniciID());
            findedKullanici.setSifre(kullanici.getSifre());
            findedKullanici.setMail(kullanici.getMail());
            findedKullanici.setUrunID(kullanici.getUrunID());
            return new ResponseEntity<>(kullaniciRepository.save(findedKullanici), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<HttpStatus> deleteKullanici(@PathVariable("id") String id) {

        Kullanici kullanici = findById(id);

        if (kullanici != null) {
            kullaniciRepository.delete(kullanici);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllKullanicis() {
        try {
            kullaniciRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Kullanici findById(String id) {
        List<Kullanici> kullaniciData = kullaniciRepository.findAll();

        for (Kullanici kullanici : kullaniciData) {
            if (kullanici.getKullaniciID().equals(id)) {
                return kullanici;
            }
        }
        return null;
    }
}
