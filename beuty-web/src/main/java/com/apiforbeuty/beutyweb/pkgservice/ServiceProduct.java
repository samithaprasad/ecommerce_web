package com.apiforbeuty.beutyweb.pkgservice;

import com.apiforbeuty.beutyweb.pkgdao.DAOProduct;
import com.apiforbeuty.beutyweb.pkgobj.ObjProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ServiceProduct {

    @Autowired
    DAOProduct daoProduct;

    public List<ObjProduct> getAllProducts(){
        return daoProduct.findAll();
    }

    public void addProduct(ObjProduct product){
        daoProduct.save(product);
    }

    public void deleteProduct(Long id){
        daoProduct.deleteById(id);
    }

    public Optional<ObjProduct> getProdutById(Long id){
        return daoProduct.findById(id);
    }

    public List<ObjProduct> findAllByCategoryId(Integer id){
        return daoProduct.findAllByCategoryId(id);
    }


}
