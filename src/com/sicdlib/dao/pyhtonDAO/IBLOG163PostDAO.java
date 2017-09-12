package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.Blog163PostEntity;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOG163PostDAO {
    Boolean saveBLOG163Post(Blog163PostEntity blog163Post);
    Blog163PostEntity getBlog163Post(String id);
}
