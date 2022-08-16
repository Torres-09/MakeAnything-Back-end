package com.example.MakeAnything.service;

import com.example.MakeAnything.domain.category.model.Category;
import com.example.MakeAnything.domain.category.repository.CategoryRepository;
import com.example.MakeAnything.domain.category.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class CategoryServiceTest {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void 카테고리생성_테스트() throws Exception{
        //given
        String categoryName = "robot";
        Category category = Category.builder().categoryName(categoryName).build();

        //when

        //then
    }
}
