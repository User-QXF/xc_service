package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springfox.documentation.service.ApiListing;

import java.util.Optional;

@Repository
public interface CmsRepository extends MongoRepository<CmsPage,String> {

    Optional<CmsPage> findBySiteIdAndPageWebPathAndPageName(String siteId, String pageWebPath,String pageName);
}
