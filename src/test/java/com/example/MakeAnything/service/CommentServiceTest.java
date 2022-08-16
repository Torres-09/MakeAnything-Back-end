package com.example.MakeAnything.service;

import com.example.MakeAnything.domain.comment.service.CommentService;
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
public class CommentServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    CommentService commentService;

    @Test
    @Transactional
    public void 게시물댓글생성_테스트() throws Exception{
        //given

        //when

        //then
    }
}
