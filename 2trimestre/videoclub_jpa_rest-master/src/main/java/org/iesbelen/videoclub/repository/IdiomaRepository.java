package org.iesbelen.videoclub.repository;

import jdk.jfr.Registered;
import org.iesbelen.videoclub.domain.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface IdiomaRepository extends JpaRepository<Idioma, Long> {
}
