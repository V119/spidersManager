package com.sicdlib.dao.hbaseDAO;

import com.sicdlib.dto.phoenixEntity.SpiderInfoEntity;
import com.sicdlib.dto.phoenixEntity.TbTableEntity;

import java.util.List;

/**
 * Created by haoyang on 2017/9/18.
 */
public interface ITest {
    List<SpiderInfoEntity> getTestEntity();
    List<TbTableEntity> getEntity();
    Object getEntityInfo(String tableName);

}
