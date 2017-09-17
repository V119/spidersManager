package com.sicdlib.dao.pyhtonDAO;

import com.sicdlib.dto.entity.Blog163AuthorEntity;

import java.util.List;

/**
 * Created by init on 2017/6/3.
 */
public interface IBLOG163AuthorDAO {
    Boolean saveBLOG163Author(Blog163AuthorEntity blog163Author);

    List<Blog163AuthorEntity> getBlog163Author();

}
