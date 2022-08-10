package com.example.MakeAnything.domain.comment.service;

import com.example.MakeAnything.domain.comment.service.dto.CreateCommentRequest;
import com.example.MakeAnything.domain.comment.service.dto.CreateCommentResponse;
import com.example.MakeAnything.domain.comment.service.dto.UpdateCommentRequest;
import com.example.MakeAnything.domain.comment.service.dto.UpdateCommentResponse;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    // 댓글 생성
    CreateCommentResponse createComment(Long modelId,Long userId, CreateCommentRequest createCommentRequest);

    UpdateCommentResponse updateComment(Long modelId, Long userId, UpdateCommentRequest updateCommentRequest);
}
