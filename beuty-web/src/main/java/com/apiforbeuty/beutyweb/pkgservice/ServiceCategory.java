package com.apiforbeuty.beutyweb.pkgservice;

import com.apiforbeuty.beutyweb.pkgdao.DAOCategory;
import com.apiforbeuty.beutyweb.pkgobj.ObjCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ServiceCategory {

    @Autowired
    DAOCategory daoCategory;

    public List<ObjCategory> getAllCategories(){
        return daoCategory.findAll();
    }

    public void addCategory(ObjCategory category){
        daoCategory.save(category);
    }

    public void removeCatById(Integer id){
        daoCategory.deleteById(id);
    }

    public Optional<ObjCategory> getCatById(Integer id){
        return daoCategory.findById(id);
    }


}
