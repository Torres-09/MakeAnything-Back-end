package com.example.MakeAnything.domain.comment.controller;

import com.example.MakeAnything.domain.auth.service.JwtService;
import com.example.MakeAnything.domain.comment.service.CommentService;
import com.example.MakeAnything.domain.comment.service.dto.CreateCommentRequest;
import com.example.MakeAnything.domain.comment.service.dto.CreateCommentResponse;
import com.example.MakeAnything.domain.comment.service.dto.UpdateCommentRequest;
import com.example.MakeAnything.domain.comment.service.dto.UpdateCommentResponse;
import com.example.MakeAnything.domain.common.ApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    private final JwtService jwtService;

    @ResponseBody
    @PostMapping("/{modelId}")
    @ApiOperation(value = "댓글 등록")
    public ApiResponse<CreateCommentResponse> createComment(@PathVariable("modelId") Long modelId, @RequestBody CreateCommentRequest createCommentRequest) {
        return ApiResponse.success(commentService.createComment(modelId, createCommentRequest));
    }

    @ResponseBody
    @PatchMapping("/{modelId}")
    @ApiOperation(value = "댓글 수정")
    public ApiResponse<UpdateCommentResponse> updateComment(@PathVariable("modelId") Long modelId, @RequestBody UpdateCommentRequest updateCommentRequest) {
        Long userId = jwtService.getUserId();
        return ApiResponse.success(commentService.updateComment(modelId,userId, updateCommentRequest));
    }
}