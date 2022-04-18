package com.tourism.service;

import com.tourism.domain.Item;
import com.tourism.domain.ItemResponse;
import com.tourism.domain.ItemsRequest;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class ItemService {

    public ItemResponse getItemResponse(ItemsRequest itemsRequest) {
        ItemResponse itemResponse = new ItemResponse();
        itemsRequest.getItems()
                .stream()
                .sorted(Comparator.comparing(Item::getValue).reversed())
                .forEach(itemResponse.consume);

        return itemResponse;
    }
}
