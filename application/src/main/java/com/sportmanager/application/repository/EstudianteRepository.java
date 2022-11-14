package com.sportmanager.application.repository;

import com.sportmanager.application.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    @Query("SELECT u FROM estudiantes u WHERE u.email=?1")
    Estudiante findByEmailPass(String email);

}
