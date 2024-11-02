package com.example.ParcialPractico.repository;

/**
 *
 * @author Victus
 */
import com.example.ParcialPractico.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}

