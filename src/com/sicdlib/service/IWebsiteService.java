package com.sicdlib.service;

import com.sicdlib.dto.WebsiteEntity;


/**
 * Created by haoyang on 2017/4/20.
 */
public interface IWebsiteService {
    boolean saveNoIDWebsite(WebsiteEntity website);
    boolean saveWebsite(WebsiteEntity website);
}
