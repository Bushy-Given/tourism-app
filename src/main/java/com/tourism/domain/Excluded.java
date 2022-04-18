package com.tourism.domain;

import com.tourism.controller.util.ItemUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Excluded {
    private List<Item> items = new ArrayList<>();
    private Double totalKGs;

    public void add(Item item){
        items.add(item);
    }

    public Double getTotalKGs(){
        this.totalKGs = ItemUtil.getItemsSumInKGs(getItems());;
        return totalKGs;
    }

}
