package com.sicdlib.dao.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.ISearchDAO;
import com.sicdlib.dto.TbSentimentInflucenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by init on 2017/6/26.
 */
@Repository("searchDAO")
public class SearchDAO implements ISearchDAO {
    @Autowired
    @Qualifier("baseDAO")
    private IBaseDAO baseDAO;
    @Override
    public List<TbSentimentInflucenceEntity> getSentimentByDateTime(String dateTime) {
        String hql = " From  TbSentimentInflucenceEntity s where s.dateTime =  '" + dateTime + "'";
        return  baseDAO.find(hql);
    }
}
