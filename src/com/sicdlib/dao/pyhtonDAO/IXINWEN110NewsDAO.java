package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.Xinwen110NewsEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IXINWEN110NewsDAO {
    Boolean saveXINWEN110News(Xinwen110NewsEntity xinwen110News);
    Xinwen110NewsEntity getXinwen110News(String id);
}
