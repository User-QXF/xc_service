package com.xuecheng.framework.domain.cms.request;

import com.xuecheng.framework.model.request.RequestData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class QueryPageResult extends RequestData {

    @ApiModelProperty("站点ID")
    private  String siteId;

    @ApiModelProperty("页面ID")
    private String pageId;

    @ApiModelProperty("页面名称")
    private String pageName;

    @ApiModelProperty("页面别名")
    private String pageAliase;

    @ApiModelProperty("模版ID")
    private String templateId;




}
