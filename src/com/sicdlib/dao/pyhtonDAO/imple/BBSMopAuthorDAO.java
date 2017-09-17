package com.sicdlib.dao.pyhtonDAO.imple;

import com.sicdlib.dao.pyhtonDAO.IBBSMopAuthorDAO;
import com.sicdlib.dao.IBaseDAO;
import com.sicdlib.dto.entity.BbsChinaCommentEntity;
import com.sicdlib.dto.entity.BbsMopAuthorEntity;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by init on 2017/5/26.
 */
@Repository("bbsMopAuthorDAO")
public class BBSMopAuthorDAO implements IBBSMopAuthorDAO{
    @Autowired
    private IBaseDAO baseDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean saveBBSMopAuthor(BbsMopAuthorEntity bbsMopAuthor) {
       try{
           baseDAO.save(bbsMopAuthor);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }

    @Override
    public void batchNormalizeSexAgeBirthdayRegisterDate() throws ParseException {
        StatelessSession session = sessionFactory.openStatelessSession();
        Transaction tx = session.beginTransaction();

        ScrollableResults authors = session.createQuery("from BbsMopAuthorEntity")
                .scroll(ScrollMode.FORWARD_ONLY);
        while (authors.next()) {
            BbsMopAuthorEntity author = (BbsMopAuthorEntity)authors.get(0);

            //性别
            String sex = author.getSex();
            if (!sex.equals("男") && !sex.equals("女")) {
                sex = "其他";
            }
            author.setSex(sex);

            //年龄
            String age = author.getAge();
            author.setAge(age.substring(0, age.length() - 1));

            //birthday
            DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String birthday = author.getBirthday();
            if (birthday != null && !birthday.equals("") && !birthday.equals("无")) {
                DateFormat sourceFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日");

                author.setBirthday(destFormat.format(sourceFormat.parse(birthday)));
            } else {
                author.setBirthday("");
            }

            //设置注册日期
            String registerDate = author.getRegisterDate();
            if (registerDate != null && !registerDate.equals("")) {
                DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");

                author.setRegisterDate(destFormat.format(sourceFormat.parse(registerDate)));
            } else {
                author.setRegisterDate("");
            }

            session.update(author);
        }

        tx.commit();
        session.close();
    }

    @Override
    public List<BbsMopAuthorEntity> getBbsMopAuthor() {
        String hql = "FROM BbsMopAuthorEntity BbsMopAuthorEntity";
        return baseDAO.find(hql);
    }
}
