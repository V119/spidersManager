package com.sicdlib.util.HTableToMysqlUtil;

import com.sicdlib.dto.entity.BbsTianyaPostEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YH on 2017/6/22.
 */
public class NormalizeBbsTianyaPost implements INormalizeProcess {
    @Override
    public Object processData(Object object) {
        BbsTianyaPostEntity tianyaPost = (BbsTianyaPostEntity) object;

        //日期时间
        String dateTime = tianyaPost.getDateTime().trim();
        if (dateTime.length() > 19) {
            tianyaPost.setDateTime(dateTime.substring(0, dateTime.length() - 4));
        }

        if (dateTime.length() == 16) {
            String fmt = "yy-MM-dd hh:mm";
            try {
                tianyaPost.setDateTime(FormatDate.format(dateTime, fmt));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        tianyaPost.setContent(tianyaPost.getContent().replaceAll("[\\uE5F1]", "").trim());

        String s = tianyaPost.getCreateTime();
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(s);
        if(isNum.matches()){
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(Long.parseLong(s));
            Date date = cal.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fmt = dateFormat.format(date);
            tianyaPost.setCreateTime(fmt);
        }
        return tianyaPost;
    }
}
