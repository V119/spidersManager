package com.sicdlib.service.hbaseService.imple;

import com.sicdlib.dao.hbaseDAO.ICommentDAO;
import com.sicdlib.service.hbaseService.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("commentService")
public class CommentService implements ICommentService{

    @Autowired
    @Qualifier("commentDAO")
    private ICommentDAO commentDAO;
    @Override
    public List<Object[]> getCommentList(String tableName, String condition,String conditionValue) {
        return commentDAO.getCommentList(tableName,condition,conditionValue);
    }
}
