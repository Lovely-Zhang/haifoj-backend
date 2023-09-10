package com.haif.oj.judege.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.haif.oj.common.ErrorCode;
import com.haif.oj.exception.BusinessException;
import com.haif.oj.judege.codesandbox.CodeSandbox;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeRequest;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * 远程代码沙箱（正式使用）
 */
public class RemoteCodeSandbox implements CodeSandbox
{

    /**
     * 自定义 鉴权请求头和密钥
     */
    public static final String AUTH_REQUEST_HEADER = "auth";
    public static final String AUTH_REQUEST_SECRET = "secretKey";


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱" );
        String url = "http://localhost:8090/test/executeCode";
        String jsonStr = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(jsonStr)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error，message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }

}
