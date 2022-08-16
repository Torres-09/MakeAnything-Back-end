package com.example.MakeAnything.service;

import com.example.MakeAnything.domain.auth.service.dto.SignUpLocalRequest;
import com.example.MakeAnything.domain.category.model.Category;
import com.example.MakeAnything.domain.model.model.Model;
import com.example.MakeAnything.domain.model.repository.ModelRepository;
import com.example.MakeAnything.domain.model.service.ModelService;
import com.example.MakeAnything.domain.model.service.dto.CreateModelRequest;
import com.example.MakeAnything.domain.modelfile.model.ModelFile;
import com.example.MakeAnything.domain.modelfile.repository.ModelFileRepository;
import com.example.MakeAnything.domain.modelfile.service.ModelFileService;
import com.example.MakeAnything.domain.user.model.User;
import com.example.MakeAnything.domain.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.FileInputStream;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ModelServiceTest {

    @Autowired
    ModelService modelService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    ModelFileService modelFileService;

    @Autowired
    ModelFileRepository modelFileRepository;

    @Autowired
    EntityManager em;

    @Test
    public void 모델생성_테스트() throws Exception{

        //given
        Model model = Model.builder()
                .modelName("robot")
                .content("이것은 로봇입니다.")
                .category(Category.builder().categoryName("ROBOT").build())
                .price(1000L)
                .user(userRepository.findUserById(1L))
                .build();
        //when
        modelRepository.save(model);


        //then
    }
}