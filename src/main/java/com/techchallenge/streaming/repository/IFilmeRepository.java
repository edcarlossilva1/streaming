package com.techchallenge.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techchallenge.streaming.entities.Filme;

public interface IFilmeRepository extends JpaRepository<Filme, Long> {

}
