package br.edu.utfpr.parking_manager.service;

import br.edu.utfpr.parking_manager.model.dao.BrandDAO;
import br.edu.utfpr.parking_manager.model.domain.Brand;

public class BrandService extends AbstractService<Long, Brand>{

    public BrandService() {
        dao = new BrandDAO();
    }
}
