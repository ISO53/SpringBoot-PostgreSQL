package com.kirala.kiralama;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Type-C
 */
@Repository
public interface SehirRepository extends JpaRepository<Sehir, Long>{
}
