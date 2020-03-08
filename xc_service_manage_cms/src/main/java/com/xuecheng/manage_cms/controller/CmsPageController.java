package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageResult;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.service.CmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {


    @Autowired
    CmsPageService cmsPageService;

    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable int size, @PathVariable int page, QueryPageResult pageResult) {


        QueryResponseResult result = cmsPageService.findPage(page, size, pageResult);


        return result;
    }

    @PostMapping("/list/add")
    public CmsPageResult save(@RequestBody CmsPage cmsPage){

       return cmsPageService.add(cmsPage);

    }

    @PostMapping("/list/del")
    public CmsPageResult del(@RequestBody CmsPage cmsPage){

        return cmsPageService.del(cmsPage);

    }
}
