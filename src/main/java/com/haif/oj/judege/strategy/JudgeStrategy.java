package com.haif.oj.judege.strategy;

import com.haif.oj.judege.codesandbox.model.JudgeInfo;

/**
 * 判题策略
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     */
    JudgeInfo doJudge(JudgeContetxt judgeContetxt);

}
