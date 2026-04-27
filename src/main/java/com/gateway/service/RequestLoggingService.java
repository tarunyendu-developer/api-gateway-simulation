package com.gateway.service;

import com.gateway.entity.RequestLog;
import com.gateway.repository.RequestLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RequestLoggingService {

    private final RequestLogRepository requestLogRepository;

    //  Save request log
    public void log(String url, String method, int status) {

        RequestLog log = RequestLog.builder()
                .requestUrl(url)
                .httpMethod(method)
                .requestTime(LocalDateTime.now())
                .responseStatus(status)
                .build();

        requestLogRepository.save(log);
    }
}