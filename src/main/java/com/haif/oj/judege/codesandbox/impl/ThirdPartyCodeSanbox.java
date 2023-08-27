package com.haif.oj.judege.codesandbox.impl;

import com.haif.oj.judege.codesandbox.CodeSandbox;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeRequest;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeResponse;

/**
 * 第三方代码沙箱（调用别人的第三方沙箱）
 */
public class ThirdPartyCodeSanbox implements CodeSandbox
{
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱" );
        return null;
    }
}

