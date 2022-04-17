package br.edu.utfpr.parking_manager.model.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CarDTO {
    @NonNull
    private String model;

    @NonNull
    private String code;

    @NonNull
    private String color;

    @NonNull
    private BrandDTO brand;
}
