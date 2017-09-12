package com.sicdlib.service.pythonService;

import com.sicdlib.dto.entity.Xinwen110NewsEntity;

/**
 * Created by init on 2017/6/5.
 */
public interface IXINWEN110NewsService {
    //更新或新增中国社会新闻网
    public  boolean saveXINWEN110News(Xinwen110NewsEntity xinwen110News);
    Xinwen110NewsEntity getXinwen110News(String id);
}
