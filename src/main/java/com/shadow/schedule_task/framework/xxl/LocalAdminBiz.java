package com.shadow.schedule_task.framework.xxl;

import com.xxl.job.core.biz.AdminBiz;
import com.xxl.job.core.biz.model.HandleCallbackParam;
import com.xxl.job.core.biz.model.RegistryParam;
import com.xxl.job.core.biz.model.ReturnT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class LocalAdminBiz  implements AdminBiz {

    @Autowired
    private XxlJobLogMapper xxlJobLogMapper;

    @Override
    public ReturnT<String> callback(List<HandleCallbackParam> list) {
        for (HandleCallbackParam handleCallbackParam : list) {
            ReturnT<String> returnT = callback(handleCallbackParam);
        }
        return ReturnT.SUCCESS;
    }

    private ReturnT<String> callback(HandleCallbackParam handleCallbackParam) {
        XxlJobLog xxlJobLog = xxlJobLogMapper.load(handleCallbackParam.getLogId());
        if(null == xxlJobLog) {
            return new ReturnT<>(ReturnT.FAIL_CODE,"log item not found");
        }
        if(xxlJobLog.getHandleCode() > 0) {
            return new ReturnT<>(ReturnT.FAIL_CODE,"log repeate callback");
        }
        StringBuffer handleMsg = new StringBuffer();
        if(xxlJobLog.getHandleMsg() != null) {
            handleMsg.append(xxlJobLog.getHandleMsg()).append("<br>");
        }
        if(handleCallbackParam.getHandleMsg() != null) {
            handleMsg.append(handleCallbackParam.getHandleMsg());
        }

        xxlJobLog.setHandleTime(new Date());
        xxlJobLog.setHandleCode(handleCallbackParam.getHandleCode());
        xxlJobLog.setHandleMsg(handleMsg.toString());

        if(xxlJobLog.getHandleMsg().length() > 15000) {
            xxlJobLog.setHandleMsg(xxlJobLog.getHandleMsg().substring(0,15000));
        }
        // 子任务
        finishJob(xxlJobLog);

        xxlJobLogMapper.updateHandleInfo(xxlJobLog);

        return ReturnT.SUCCESS;
    }

    private void finishJob(XxlJobLog xxlJobLog) {
        // do nothing
    }

    @Override
    public ReturnT<String> registry(RegistryParam registryParam) {
        // do nothing
        return null;
    }

    @Override
    public ReturnT<String> registryRemove(RegistryParam registryParam) {
        // do nothing
        return null;
    }
}
