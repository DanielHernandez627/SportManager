package com.sportmanager.application.repository;

import com.sportmanager.application.entity.Estudiante;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    @Query("SELECT u FROM estudiantes u WHERE u.email=?1")
    Estudiante findByEmailPass(String email);

    @Override
    <S extends Estudiante> S save(S entity);

    @Override
    List<Estudiante> findAll();

    @Query("SELECT u FROM estudiantes u WHERE u.id=?1")
    Estudiante findById(int id);

  /*  @Query("SELECT u FROM estudiantes u WHERE u.fecha_inscripcion=?1")
    Estudiante findByFecha(String fechaingreso);*/
}
