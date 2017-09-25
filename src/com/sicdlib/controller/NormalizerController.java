package com.sicdlib.controller;

import com.sicdlib.dao.pyhtonDAO.IBBSMopPostDAO;
import com.sicdlib.dao.pyhtonDAO.INormalizeData;
import com.sicdlib.service.hbaseService.IAuthorService;
import com.sicdlib.util.HTableToMysqlUtil.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by YH on 2017/6/22.
 */
@Controller
public class NormalizerController {
    @Autowired
    @Qualifier("authorService")
    private IAuthorService authorService;

    @Autowired
    @Qualifier("bbsMopPostDAO")
    private IBBSMopPostDAO mopPostDAO;

    @Autowired
    @Qualifier("normalizeDataDAO")
    private INormalizeData normalizeData;


    @RequestMapping("normalize")
    public void normalize(HttpServletRequest req) throws Exception {
//        NormalizeDate.normalizeBbsChinaComment();

//        bbsMopAuthorService.normalizeSexAgeBirthdayRegisterDate();

        mopPostDAO.batchNormalizeContent();
    }

    @RequestMapping("normalizeMopPost")
    public void normalizeMopPost(HttpServletRequest req) throws Exception {
        INormalizeProcess process = new NormalizeMopPost();
        String entityName = "BbsMopPostEntity";

        normalizeData.normalizeData(process, entityName);
    }

    @RequestMapping("normalizePeoplePost")
    public void normalizePeoplePost(HttpServletRequest req) throws Exception {
        INormalizeProcess process = new NormalizeBbsPeoplePost();
        String entityName = "BbsPeoplePostEntity";

        normalizeData.normalizeData(process, entityName);
    }

    @RequestMapping("normalizeBbsSohuComment")
    public void normalizeBbsSohuComment() {
        INormalizeProcess process = new NormalizeBbsSohuComment();
        String entityName = "BbsSohuCommentEntity";

        normalizeData.normalizeData(process, entityName);
    }

    @RequestMapping("normalizeBbsSohuPost")
    public void normalizeBbsSohuPost() {
        INormalizeProcess process = new NormalizeBbsSohuPost();
        String name = "BbsSohuPostEntity";

        normalizeData.normalizeData(process, name);
    }

    @RequestMapping("normalizeEntity")
    public void normalize() {
        INormalizeProcess process = new NormalizeBbsTianyaPost();
        String name = "BbsTianyaPostEntity";

        normalizeData.normalizeData(process, name);

//        INormalizeProcess process1 = new NormalizeBbsTianyaComment();
//        String tianyaComment = "BbsTianyaCommentEntity";
//        normalizeData.normalizeData(process1, tianyaComment);

//        INormalizeProcess process2 = new NormalizeXiciComment();
//        String xiciComment = "BbsXiciCommentEntity";
//        normalizeData.normalizeData(process2, xiciComment);
//
//        INormalizeProcess process3 = new NormalizeXiciPost();
//        String xiciPost = "BbsXiciPostEntity";
//        normalizeData.normalizeData(process3, xiciPost);
//
//        INormalizeProcess processn = new NormalizeBbsSohuPost();
//        String sohuPost = "BbsSohuPostEntity";
//        normalizeData.normalizeData(processn, sohuPost);
//
//        INormalizeProcess processm = new NormalizeBbsSohuComment();
//        String sohuComment = "BbsSohuCommentEntity";
//        normalizeData.normalizeData(processm, sohuComment);

        //sssssssssssssssssssssss
//        INormalizeProcess process = new NormalizeBlogSinaPost();
//        String entityName = "BlogSinaPostEntity";
//        normalizeData.normalizeData(process, entityName);

//        INormalizeProcess process1 = new NormalizeKdnetPost();
//        String kdPostName = "KdnetPostEntity";
//        normalizeData.normalizeData(process1, kdPostName);
//
//        INormalizeProcess process2 = new NormalizeKdnetAuthor();
//        String kdAuthorName = "KdnetAuthorEntity";
//        normalizeData.normalizeData(process2, kdAuthorName);
//
//        INormalizeProcess process = new NormalizeBlogSinaComment();
//        String bsCommentName = "BlogSinaCommentEntity";
//        normalizeData.normalizeData(process, bsCommentName);

//        INormalizeProcess process = new NormalizeXinhuaNews();
//        String xinhuaName = "XinhuaNewsEntity";
//        normalizeData.normalizeData(process, xinhuaName);
    }
}
