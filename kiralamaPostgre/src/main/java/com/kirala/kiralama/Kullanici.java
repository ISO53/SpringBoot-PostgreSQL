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
@Table(name = "kullanici")
public class Kullanici implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String kullaniciID;
    
    @Column(name = "kullaniciadsoyad")
    private String adSoyad;
    
    @Column(name = "kullanicisifre")
    private String sifre;
    
    @Column(name = "kullanicimail")
    private String mail;
    
    @Column(name = "kullanicisehirid")
    private Integer sehirID;
    
    @Column(name = "kullaniciurunid")
    private Integer urunID;
    
    public Kullanici(String kullaniciID, String adSoyad, String sifre, String mail, int sehirID, int urunID) {
        this.kullaniciID = kullaniciID;
        this.adSoyad = adSoyad;
        this.sifre = sifre;
        this.mail = mail;
        this.sehirID = sehirID;
        this.urunID = urunID;
    }

    public Kullanici() {
    }

    /**
     * @return the kullaniciID
     */
    public String getKullaniciID() {
        return kullaniciID;
    }

    /**
     * @param kullaniciID the kullaniciID to set
     */
    public void setKullaniciID(String kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    /**
     * @return the adSoyad
     */
    public String getAdSoyad() {
        return adSoyad;
    }

    /**
     * @param adSoyad the adSoyad to set
     */
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    /**
     * @return the sifre
     */
    public String getSifre() {
        return sifre;
    }

    /**
     * @param sifre the sifre to set
     */
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the sehirID
     */
    public int getSehirID() {
        return sehirID;
    }

    /**
     * @param sehirID the sehirID to set
     */
    public void setSehirID(int sehirID) {
        this.sehirID = sehirID;
    }

    /**
     * @return the urunID
     */
    public int getUrunID() {
        return urunID;
    }

    /**
     * @param urunID the urunID to set
     */
    public void setUrunID(int urunID) {
        this.urunID = urunID;
    }
    
    @Override
    public String toString() {
        return "\n Ad Soyad: " + this.getAdSoyad() + 
                "\n Kullanıcı ID: " + this.getKullaniciID() +
                "\n Mail ID" + this.getMail() + 
                "\n Sifre" + this.getSifre() + 
                "\n Sehir ID" + this.getSehirID() + 
                "\n Urun ID" + this.getUrunID();
    }
    
}
