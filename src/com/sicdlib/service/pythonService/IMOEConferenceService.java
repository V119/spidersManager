package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.MoeConferenceEntity;

/**
 * Created by init on 2017/6/4.
 */
public interface IMOEConferenceService {
    //更新或新增教育部
    boolean saveMOEConference(MoeConferenceEntity moeConference);
}
