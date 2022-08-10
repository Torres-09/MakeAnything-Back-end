package com.example.MakeAnything.domain.comment.service;

import com.example.MakeAnything.domain.comment.service.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    // 댓글 생성
    CreateCommentResponse createComment(Long modelId,Long userId, CreateCommentRequest createCommentRequest);

    // 댓글 수정
    UpdateCommentResponse updateComment(Long modelId, Long userId, UpdateCommentRequest updateCommentRequest);

    // 댓글 삭제
    DeleteCommentResponse deleteComment(Long modelId, Long userId, Long commentId);
}
