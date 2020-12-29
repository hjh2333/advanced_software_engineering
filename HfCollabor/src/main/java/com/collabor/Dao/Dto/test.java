package com.collabor.Dao.Dto;

import com.collabor.Entity.Dto.testDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface test {
    List<testDTO> testFun();
}
