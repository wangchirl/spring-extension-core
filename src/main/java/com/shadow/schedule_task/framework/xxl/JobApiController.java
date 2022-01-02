package com.shadow.schedule_task.framework.xxl;

import com.xxl.job.core.biz.AdminBiz;
import com.xxl.job.core.biz.model.HandleCallbackParam;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.util.GsonTool;
import com.xxl.job.core.util.XxlJobRemotingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobApiController {

    @Autowired
    private AdminBiz localAdminBiz;

    @Autowired
    private XxlCoreProperties xxlCoreProperties;

    /**
     * api
     *
     * @param uri
     * @param data
     * @return
     */
    @RequestMapping("/callback")
    public ReturnT<String> api(HttpServletRequest request, @RequestBody(required = false) String data) {

        if (xxlCoreProperties.getAccessToken() != null
                && xxlCoreProperties.getAccessToken().trim().length() > 0
                && !xxlCoreProperties.getAccessToken().equals(request.getHeader(XxlJobRemotingUtil.XXL_JOB_ACCESS_TOKEN))) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "The access token is wrong.");
        }
        List<HandleCallbackParam> callbackParamList = GsonTool.fromJson(data, List.class, HandleCallbackParam.class);
        return localAdminBiz.callback(callbackParamList);
    }

}