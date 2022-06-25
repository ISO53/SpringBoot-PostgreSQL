package com.kirala.kiralama;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Type-C
 */
@Repository
public interface KullanıcıRepository extends JpaRepository<Kullanici, Long>{
}
