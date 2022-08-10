package com.example.MakeAnything.domain.comment.service;

import com.example.MakeAnything.domain.auth.service.JwtService;
import com.example.MakeAnything.domain.comment.model.Comment;
import com.example.MakeAnything.domain.comment.repository.CommentRepository;
import com.example.MakeAnything.domain.comment.service.dto.CreateCommentRequest;
import com.example.MakeAnything.domain.comment.service.dto.CreateCommentResponse;
import com.example.MakeAnything.domain.comment.service.dto.UpdateCommentRequest;
import com.example.MakeAnything.domain.comment.service.dto.UpdateCommentResponse;
import com.example.MakeAnything.domain.model.model.Model;
import com.example.MakeAnything.domain.model.repository.ModelRepository;
import com.example.MakeAnything.domain.user.model.User;
import com.example.MakeAnything.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    private final ModelRepository modelRepository;

    private final UserRepository userRepository;

    // 댓글 생성
    @Override
    @Transactional
    public CreateCommentResponse createComment(Long modelId, CreateCommentRequest createCommentRequest) {
        Model model = modelRepository.findModelById(modelId);
        User user = model.getUser();

        Comment newComment = Comment.builder()
                .model(model)
                .user(user)
                .content(createCommentRequest.getContent())
                .build();

        commentRepository.save(newComment);
        return CreateCommentResponse.builder()
                .resultMessage("success")
                .build();
    }

    // 댓글 수정
    @Override
    @Transactional
    public UpdateCommentResponse updateComment(Long modelId, Long userId, UpdateCommentRequest updateCommentRequest) {
        Model model = modelRepository.findModelById(modelId);
        User user = userRepository.findUserById(userId);
        Comment comment = commentRepository.findCommentById(updateCommentRequest.getId());

        comment.updateComment(updateCommentRequest.getContent());

        return UpdateCommentResponse.builder()
                .resultMessage("success")
                .build();
    }
}
