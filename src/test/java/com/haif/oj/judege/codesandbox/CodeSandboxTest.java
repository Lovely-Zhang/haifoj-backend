package com.haif.oj.judege.codesandbox;

import com.haif.oj.judege.codesandbox.impl.ExampleCodeSandbox;
import com.haif.oj.judege.codesandbox.impl.RemoteCodeSanbox;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeRequest;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeResponse;
import com.haif.oj.model.dto.question.JudgeCase;
import com.haif.oj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
class CodeSandboxTest {


    @Value("${codesandbox.type:example}")
    private String type;

    /**
     * 测试代码沙箱测试
     */
    @Test
    void executeCodeValue() {
        CodeSandbox codeSandbox = new ExampleCodeSandbox();
        String code = "init main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<JudgeCase> list = Collections.singletonList(new JudgeCase("1,2", "3, 4"));
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder().code(code).language(language).inputList(list).build();
        ExecuteCodeResponse executeCodeRespone = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeRespone);
    }

    /**
     * 远程示例是沙箱测试
     */
    @Test
    void executeCodeValue2() {
        CodeSandbox codeSandbox = new RemoteCodeSanbox();
        String code = "init main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<JudgeCase> list = Collections.singletonList(new JudgeCase("1,2", "3, 4"));
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(list)
                .build();
        ExecuteCodeResponse executeCodeRespone = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeRespone);
    }

    /**
     * 自定义输入测试
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        String code = "init main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<JudgeCase> list = Collections.singletonList(new JudgeCase("1,2", "3, 4"));
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(list)
                .build();
        ExecuteCodeResponse executeCodeRespone = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeRespone);
    }

    /**
     * @Value 注解测试
     */
    @Test
    void executeCodeByValue() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        String code = "init main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<JudgeCase> list = Collections.singletonList(new JudgeCase("1,2", "3, 4"));
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(list)
                .build();
        ExecuteCodeResponse executeCodeRespone = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeRespone);
    }


    /**
     * 使用代理类做额外功能的增强
     */
    @Test
    void executeCodeProxy() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        // 增强
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "init main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<JudgeCase> list = Collections.singletonList(new JudgeCase("1,2", "3, 4"));
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(list)
                .build();
        ExecuteCodeResponse executeCodeRespone = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeRespone);
    }

}