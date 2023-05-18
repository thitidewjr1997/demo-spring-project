package com.example.demo.utils;

import com.example.demo.response.Response;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ResponseUtil {
    public Response getSuccessResponse(String key, Object data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(key, data);
        return Response.builder().data(hashMap).build();
    }
}
