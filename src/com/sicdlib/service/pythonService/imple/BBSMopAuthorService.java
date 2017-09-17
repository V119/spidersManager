package com.sicdlib.service.pythonService.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSMopAuthorDAO;
import com.sicdlib.dto.entity.BbsMopAuthorEntity;
import com.sicdlib.service.pythonService.IBBSMopAuthorService;
import com.sicdlib.util.UUIDUtil.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;


/**
 * Created by init on 2017/5/26.
 */
@Service("bbsMopAuthorService")
public class BBSMopAuthorService implements IBBSMopAuthorService {
    @Autowired
    @Qualifier("bbsMopAuthorDAO")
    private IBBSMopAuthorDAO bbsMopAuthorDAO;

    @Override
    public boolean saveBBSMopAuthor(BbsMopAuthorEntity bbsMopAuthor) {
        if(bbsMopAuthor.getId()==null){
            String uuid = UUIDUtil.getUUID();
            bbsMopAuthor.setId(uuid);
        }
        return bbsMopAuthorDAO.saveBBSMopAuthor(bbsMopAuthor);
    }

    @Override
    public void normalizeSexAgeBirthdayRegisterDate() throws ParseException {
        bbsMopAuthorDAO.batchNormalizeSexAgeBirthdayRegisterDate();
    }

    @Override
    public List<BbsMopAuthorEntity> getBbsMopAuthor() {
        return bbsMopAuthorDAO.getBbsMopAuthor();
    }


}
