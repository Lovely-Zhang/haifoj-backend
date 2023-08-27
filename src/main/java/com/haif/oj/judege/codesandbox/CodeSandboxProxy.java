package com.haif.oj.judege.codesandbox;

import com.haif.oj.judege.codesandbox.model.ExecuteCodeRequest;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 代码沙箱工厂类（根据字符串参数创建指定的代码沙箱实例）
 */
@Slf4j
@AllArgsConstructor
public class CodeSandboxProxy implements CodeSandbox {

    private final CodeSandbox codeSandbox;

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("日志输出：{}","代码沙箱请求信息");
        return codeSandbox.executeCode(executeCodeRequest);
    }
}
