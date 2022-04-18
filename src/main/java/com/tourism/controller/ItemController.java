package com.tourism.controller;

import com.tourism.domain.Item;
import com.tourism.domain.ItemResponse;
import com.tourism.domain.ItemsRequest;
import com.tourism.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/items")
    public ItemResponse getItemResponse(@RequestBody ItemsRequest itemsRequest){
        return itemService.getItemResponse(itemsRequest);
    }
}
