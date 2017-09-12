package com.sicdlib.service.imple;

import com.sicdlib.dao.ISearchDAO;
import com.sicdlib.dto.TbSentimentInflucenceEntity;
import com.sicdlib.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by init on 2017/6/26.
 */
@Service("searchService")
public class SearchService implements ISearchService{
    @Autowired
    @Qualifier("searchDAO")
    private ISearchDAO searchDAO;
    @Override
    public List<TbSentimentInflucenceEntity> getSentimentByDateTime(String dateTime) {
        return searchDAO.getSentimentByDateTime(dateTime);
    }
}
