package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dao.pyhtonDAO.IXINWEN110NewsDAO;
import com.sicdlib.dto.entity.Xinwen110NewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by init on 2017/6/5.
 */
@Repository("xinwen110NewsDAO")
public class XINWEN110NewsDAO  implements IXINWEN110NewsDAO{
    @Autowired
    private IBaseDAO baseDAO;
    @Override
    public Boolean saveXINWEN110News(Xinwen110NewsEntity xinwen110News) {
        try{
            baseDAO.save(xinwen110News);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Xinwen110NewsEntity getXinwen110News(String id) {
        String hql = "from Xinwen110NewsEntity xw where xw.id = '"+ id +"'";
        return (Xinwen110NewsEntity) baseDAO.get(hql);
    }
}
