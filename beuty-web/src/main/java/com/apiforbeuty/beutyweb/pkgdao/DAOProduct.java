package com.apiforbeuty.beutyweb.pkgdao;

import com.apiforbeuty.beutyweb.pkgobj.ObjProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DAOProduct extends JpaRepository<ObjProduct, Long> {

    List<ObjProduct> findAllByCategoryId(Integer id);

}
