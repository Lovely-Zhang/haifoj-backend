package com.haif.oj.judege.codesandbox.impl;

import com.haif.oj.judege.codesandbox.CodeSandbox;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeRequest;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeResponse;

/**
 * 远程代码沙箱（正式使用）
 */
public class RemoteCodeSanbox implements CodeSandbox
{
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱" );
        return null;
    }
}
