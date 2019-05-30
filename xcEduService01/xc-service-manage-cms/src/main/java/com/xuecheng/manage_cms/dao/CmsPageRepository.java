package com.xuecheng.manage_cms.dao;


import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;
//返回类型与组件
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {
    //根据页面名称查询
    CmsPage findByPageName(String pageName);
}
