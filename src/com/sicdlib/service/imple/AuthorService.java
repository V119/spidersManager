package com.sicdlib.service.imple;

import com.sicdlib.dao.IAuthorDAO;
import com.sicdlib.dto.TbAuthorEntity;
import com.sicdlib.dto.TbEventAuthorMappingEntity;
import com.sicdlib.service.IAuthorService;
import com.sicdlib.util.PageUtil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2017/6/16.
 */
@Service("authorService")
public class AuthorService implements IAuthorService {
    @Autowired
    @Qualifier("authorDAO")
    private IAuthorDAO authorDAO;

    @Override
    public void setAuthorAttributes(String eventID) {

    }

    @Override
    public Map<String, Map> getAuthorInfluenceAndActiveness(String eventID) {
        List<TbEventAuthorMappingEntity> eventAuthorList = authorDAO.getEventAuthorMappingByEventId(eventID);

        Map<String, Map> result = new HashMap<>();

        eventAuthorList.forEach(eventAuthor->{
            Map<String, Object> attributes = new HashMap<>();
            TbAuthorEntity author = eventAuthor.getAuthor();

            attributes.put("influence", author.getAuthorInfluence());
            attributes.put("activeness", author.getActiveness());

            result.put(author.getSourceAuthorName(), attributes);
        });

        return result;
    }

    @Override
    public int getAllAuthorNum(String tableName) {
        return authorDAO.getAllAuthorNum(tableName);
    }

    @Override
    public List<Object[]> getAuthorList(String tableName,  Page page) {
        return authorDAO.getAuthorList(tableName,page);
    }

    @Override
    public Object[] getAuthorInfo(String authorId, String tableName) {
        return authorDAO.getAuthorInfo(authorId,tableName);
    }
}
