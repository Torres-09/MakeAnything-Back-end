package com.example.MakeAnything.domain.download.service;

import com.example.MakeAnything.domain.download.model.Download;
import com.example.MakeAnything.domain.download.repository.DownloadRepository;
import com.example.MakeAnything.domain.order.model.Order;
import com.example.MakeAnything.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DownloadServiceImpl implements DownloadService{

    private final DownloadRepository downloadRepository;

    private final OrderRepository orderRepository;


    @Override
    @Transactional
    public Long createDownload(Long orderId) {

        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Order order = new Order();

        if (optionalOrder.isPresent()) {
            order = optionalOrder.get();
        }


        Download download = Download.builder()
                .order(order)
                .downloadStatus(false)
                .build();

        downloadRepository.save(download);

        return download.getId();
    }
}
