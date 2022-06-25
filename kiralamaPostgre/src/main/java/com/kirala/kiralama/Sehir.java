package com.kirala.kiralama;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Type-C
 */
@Entity
@Table(name = "sehirler")
public class Sehir implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sehirId;

    @Column(name = "il")
    private String il;

    public Sehir(Long sehirId, String il) {
        this.sehirId = sehirId;
        this.il = il;
    }

    public Sehir() {
    }

    /**
     * @return the sehirId
     */
    public Long getSehirId() {
        return sehirId;
    }

    /**
     * @param sehirId the sehirId to set
     */
    public void setSehirId(Long sehirId) {
        this.sehirId = sehirId;
    }

    /**
     * @return the il
     */
    public String getIl() {
        return il;
    }

    /**
     * @param il the il to set
     */
    public void setIl(String il) {
        this.il = il;
    }
    
}
