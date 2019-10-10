package com.myself.springboot.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudyMapper {

    List<Map> listAll();

}
