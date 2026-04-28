package com.gateway.controller;

import com.gateway.entity.RequestLog;
import com.gateway.repository.RequestLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class RequestLogController {

    private final RequestLogRepository requestLogRepository;

    //  GET all logs
    @GetMapping
    public List<RequestLog> getAllLogs() {
        return requestLogRepository.findAll();
    }
}