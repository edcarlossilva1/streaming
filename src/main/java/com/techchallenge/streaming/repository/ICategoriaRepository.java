package com.techchallenge.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techchallenge.streaming.entities.Categoria;

public interface ICategoriaRepository extends JpaRepository <Categoria, Long>{

}
