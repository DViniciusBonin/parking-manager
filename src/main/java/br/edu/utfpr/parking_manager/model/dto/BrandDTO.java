package br.edu.utfpr.parking_manager.model.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class BrandDTO {
    @NonNull
    private String name;
}
