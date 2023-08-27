package com.haif.oj.judege.codesandbox.impl;

import com.haif.oj.judege.codesandbox.CodeSandbox;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeRequest;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeResponse;
import com.haif.oj.model.dto.question.JudgeCase;
import com.haif.oj.model.dto.questionsubmit.JudgeInfo;
import com.haif.oj.model.enums.JudgeInfoMessageEnum;
import com.haif.oj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 示例代码沙箱（仅为了跑通流程测试专用）
 */
public class ExampleCodeSandbox implements CodeSandbox
{
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<JudgeCase> judgeCaseList = executeCodeRequest.getInputList();
        List<String> outputList = judgeCaseList.stream().map(JudgeCase::getOutput).collect(Collectors.toList());
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(outputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
