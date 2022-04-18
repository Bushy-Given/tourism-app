package com.tourism.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tourism.controller.util.ItemUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Data
@NoArgsConstructor
public class ItemResponse {
    private List<Item> items = new ArrayList<>();
    private Double totalKGs;
    private Excluded excluded = new Excluded();

    public Double getTotalKGs() {
        this.totalKGs = ItemUtil.getItemsSumInKGs(getItems());
        return totalKGs;
    }

    @JsonIgnore
    @ToString.Exclude
    public Consumer<Item> consume = item -> {
        if (getTotalKGs() + item.toKg() < 4D) {
            items.add(item);
        } else {
            getExcluded().add(item);
        }
    };
}
