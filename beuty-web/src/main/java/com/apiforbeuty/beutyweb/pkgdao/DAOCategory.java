package com.apiforbeuty.beutyweb.pkgdao;

import com.apiforbeuty.beutyweb.pkgobj.ObjCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOCategory extends JpaRepository<ObjCategory,Integer> {
}
