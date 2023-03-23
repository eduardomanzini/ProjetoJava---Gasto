package com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.teste.entidade.Gasto;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long>{

}
