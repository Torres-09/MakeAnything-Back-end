package com.example.MakeAnything.domain.order.controller;

import com.example.MakeAnything.domain.auth.service.JwtService;
import com.example.MakeAnything.domain.common.ApiResponse;
import com.example.MakeAnything.domain.order.service.OrderService;
import com.example.MakeAnything.domain.order.service.dto.CreateOrderRequest;
import com.example.MakeAnything.domain.order.service.dto.CreateOrderResponse;
import com.example.MakeAnything.domain.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    private final JwtService jwtService;

    @ResponseBody
    @PostMapping("/{modelId}")
    @ApiOperation(value = "주문 생성")
    public ApiResponse<CreateOrderResponse> createOrder(@PathVariable ("modelId") Long modelId, @RequestBody CreateOrderRequest createOrderRequest ) {
        Long userId = jwtService.getUserId();

        CreateOrderResponse createOrderResponse = orderService.createOrder(userId, modelId, createOrderRequest);
        return ApiResponse.success(createOrderResponse);
    }
}
