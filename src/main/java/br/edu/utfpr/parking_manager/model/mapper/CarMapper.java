package br.edu.utfpr.parking_manager.model.mapper;

import br.edu.utfpr.parking_manager.model.domain.Car;
import br.edu.utfpr.parking_manager.model.domain.Brand;
import br.edu.utfpr.parking_manager.model.dto.CarDTO;
import br.edu.utfpr.parking_manager.model.dto.BrandDTO;


public class CarMapper{

    public CarMapper getInstance(){
        return new CarMapper();
    }

    public Car toEntity(CarDTO dto){
        Brand brand = BrandMapper.toEntity(dto.getBrand());
        Car entity = new Car(dto.getModel(), dto.getCode(), dto.getColor(), brand);
        return entity;
    }

    public CarDTO toDTO(Car entity){
        BrandDTO brandDTO = BrandMapper.toDTO(entity.getBrand());
        CarDTO dto = new CarDTO(entity.getModel(), entity.getCode(), entity.getColor(), brandDTO);
        return dto;
    }
}
