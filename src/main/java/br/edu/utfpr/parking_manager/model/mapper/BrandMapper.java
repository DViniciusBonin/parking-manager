package br.edu.utfpr.parking_manager.model.mapper;

import br.edu.utfpr.parking_manager.model.domain.Brand;
import br.edu.utfpr.parking_manager.model.dto.BrandDTO;


public class BrandMapper {

    public BrandMapper getInstance(){
        return new BrandMapper();
    }

    public static Brand toEntity(BrandDTO dto){
        Brand entity = new Brand(dto.getName());
        return entity;
    }

    public static BrandDTO toDTO(Brand entity){
        BrandDTO dto = new BrandDTO(entity.getName());
        return dto;
    }
}
