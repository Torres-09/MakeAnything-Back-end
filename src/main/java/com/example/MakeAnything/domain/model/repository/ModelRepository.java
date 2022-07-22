package com.example.MakeAnything.domain.model.repository;

import com.example.MakeAnything.domain.model.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Long, Model> {
}
