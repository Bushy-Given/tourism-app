package com.tourism.controller.util;

import com.tourism.domain.Item;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ItemUtil {

    public static Double getItemsSumInKGs(List<Item> items) {
        return items.stream().mapToDouble(Item::toKg).sum();
    }
}
