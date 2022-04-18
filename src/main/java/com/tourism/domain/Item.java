package com.tourism.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String name;
    private double weightGrams;
    private long Value;

    public Double toKg(){
        return this.weightGrams / 1000;
    }
}
