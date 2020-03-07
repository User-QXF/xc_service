package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CmsPageService {

    @Autowired
    CmsRepository cmsRepository;


    public QueryResponseResult findPage(int page, int size, QueryPageResult pageResult){

        if(size<=0){
            size = 10;
        }

        if(page<=0){
            page = 1;
        }
        page = page -1;

        Pageable pageable = PageRequest.of(page,size);

        CmsPage cmsPage = new CmsPage();

        cmsPage.setTemplateId(pageResult.getTemplateId());
        cmsPage.setPageId(pageResult.getPageId());


        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());

        if(pageResult.getPageAliase()!=null){

            cmsPage.setPageAliase(pageResult.getPageAliase());

        }

        Example<CmsPage> example = Example.of(cmsPage,exampleMatcher);



        Page<CmsPage> all = cmsRepository.findAll(example,pageable);

        QueryResult<CmsPage> queryResult = new QueryResult<>();

        queryResult.setTotal(all.getTotalElements());
        queryResult.setList(all.getContent());

        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);

    }

}
