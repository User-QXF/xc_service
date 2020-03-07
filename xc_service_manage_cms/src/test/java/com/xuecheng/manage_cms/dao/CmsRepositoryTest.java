package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.ManageCmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageCmsApplication.class)
public class CmsRepositoryTest {

    @Autowired
    CmsRepository cmsRepository;


    @Test
    public void test1(){


        Pageable pageable = PageRequest.of(0,2);

        Page<CmsPage> all = cmsRepository.findAll(pageable);

        System.out.println(all);

    }

}
