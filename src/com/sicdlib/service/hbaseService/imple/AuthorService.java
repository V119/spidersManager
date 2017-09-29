package com.sicdlib.service.hbaseService.imple;

import com.sicdlib.dao.hbaseDAO.IAuthorDAO;
import com.sicdlib.service.hbaseService.IAuthorService;
import com.sicdlib.util.HBaseUtil.HBPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        return null;
    }

   /* @Override
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
    }*/

    @Override
    public int getAllAuthorNum(String tableName) {
        return authorDAO.getAllAuthorNum(tableName);
    }


   /* @Override
    public List<Object[]> getAuthorList(String tableName, HBPage page,List pageEntityList) {
        return authorDAO.getAuthorList(tableName,page,pageEntityList);
    }*/

    @Override
    public List<Object[]> getAuthorList(String tableName, HBPage page) {
        return authorDAO.getAuthorList(tableName,page);
    }

    @Override
    public Object getAuthorInfo(String condition, String conditionValue, String tableName) {
        return authorDAO.getAuthorInfo(condition,conditionValue,tableName);
    }

    @Override
    public List<Object[]> getMoeAuthorList(String tableName, HBPage page,String condition) {
        return authorDAO.getMoeAuthorList(tableName,page,condition);
    }
}
