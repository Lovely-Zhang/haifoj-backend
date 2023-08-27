package com.haif.oj.judege.strategy;

import com.haif.oj.model.dto.question.JudgeCase;
import com.haif.oj.model.dto.questionsubmit.JudgeInfo;
import com.haif.oj.model.entity.Question;
import com.haif.oj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

@Data
public class JudgeContetxt {

    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;

    /**
     * 判题用例
     */
    private List<JudgeCase> judgeCaseList;

    /**
     * 输入用例
     */
    private List<String> inputList;

    /**
     * 输出用例
     */
    private List<String> outputList;

    /**
     * 题目
     */
    private Question question;

    /**
     * 题目提交信息
     */
    private QuestionSubmit questionSubmit;

}
