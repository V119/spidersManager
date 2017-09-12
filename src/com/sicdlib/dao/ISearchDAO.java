package com.sicdlib.dao;

import com.sicdlib.dto.TbSentimentInflucenceEntity;

import java.util.List;

/**
 * Created by init on 2017/6/26.
 */
public interface ISearchDAO {
    List<TbSentimentInflucenceEntity> getSentimentByDateTime(String dateTime);
}
