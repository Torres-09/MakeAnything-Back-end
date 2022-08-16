package com.example.MakeAnything.domain.order.service;

import com.example.MakeAnything.domain.model.model.Model;
import com.example.MakeAnything.domain.model.repository.ModelRepository;
import com.example.MakeAnything.domain.order.model.Order;
import com.example.MakeAnything.domain.order.repository.OrderRepository;
import com.example.MakeAnything.domain.order.service.dto.CreateOrderRequest;
import com.example.MakeAnything.domain.order.service.dto.CreateOrderResponse;
import com.example.MakeAnything.domain.user.model.User;
import com.example.MakeAnything.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final ModelRepository modelRepository;

    @Transactional
    @Override
    public CreateOrderResponse createOrder(Long userId, Long modelId, CreateOrderRequest createOrderRequest) {

        Model model = modelRepository.findModelById(modelId);
        User user = userRepository.findUserById(userId);

        Order order = Order.builder()
                .amount(model.getPrice())
                .imp_uid(createOrderRequest.getImp_uid())
                .merchant_uid(createOrderRequest.getMerchant_uid())
                .model(model)
                .user(user)
                .build();

        Order saveOrder = orderRepository.save(order);

        CreateOrderResponse createOrderResponse = CreateOrderResponse.builder()
                .orderId(saveOrder.getId())
                .resultMessage("success")
                .build();

        return createOrderResponse;
    }
}
