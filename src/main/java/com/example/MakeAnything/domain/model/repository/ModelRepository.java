package com.example.MakeAnything.domain.model.repository;

import com.example.MakeAnything.domain.category.model.Category;
import com.example.MakeAnything.domain.model.model.Model;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findAllByUserId(Long userId);
    Model findModelById(Long modelId);
    List<Model> findModelsByModelName(String modelName);
    
    List<Model> findModelsByModelNameIsContaining(Pageable pageable, String modelName);

    @Query(value = "select m from Model m where m.category = :category")
    List<Model> findByCategory(@Param(value = "category") Category category);
}