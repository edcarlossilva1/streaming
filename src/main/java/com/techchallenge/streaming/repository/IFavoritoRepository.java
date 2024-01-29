package com.techchallenge.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techchallenge.streaming.entities.Favorito;
@Repository
public interface IFavoritoRepository extends JpaRepository <Favorito, Long>{


}
