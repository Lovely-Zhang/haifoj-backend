package com.haif.oj.judege.codesandbox;

import com.haif.oj.judege.codesandbox.model.ExecuteCodeRequest;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeResponse;

/**
 * 实现代码沙箱的不同调用
 */
public interface CodeSandbox {

    /**
     * 代码沙箱接口
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);


}
