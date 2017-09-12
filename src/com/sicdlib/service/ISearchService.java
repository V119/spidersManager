package com.sicdlib.service;

import com.sicdlib.dto.TbSentimentInflucenceEntity;

import java.util.List;

/**
 * Created by init on 2017/6/26.
 */
public interface ISearchService {
   public List<TbSentimentInflucenceEntity> getSentimentByDateTime(String dateTime);
}
