package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.MoeDataEntity;

/**
 * Created by init on 2017/6/4.
 */
public interface IMOEDataService {
    //更新或新增教育部
    boolean saveMOEData(MoeDataEntity moeData);
}
