package com.haif.oj.judege.codesandbox;

import com.haif.oj.judege.codesandbox.impl.ExampleCodeSandbox;
import com.haif.oj.judege.codesandbox.impl.RemoteCodeSanbox;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeRequest;
import com.haif.oj.judege.codesandbox.model.ExecuteCodeResponse;
import com.haif.oj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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
        List<String> list = Arrays.asList("1,2", "3, 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder().code(code).language(language).inputList(list).build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    /**
     * 远程示例是沙箱测试
     */
    @Test
    void executeCodeValue2() {
        CodeSandbox codeSandbox = new RemoteCodeSanbox();
        String code = "init main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> list = Arrays.asList("1,2", "3, 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(list)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
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
        List<String> list = Arrays.asList("1,2", "3, 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(list)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    /**
     * @Value 注解测试
     */
    @Test
    void executeCodeByValue() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        String code = "init main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> list = Arrays.asList("1,2", "3, 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(list)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }


    /**
     * 使用代理类做额外功能的增强
     */
    @Test
    void executeCodeProxy() {
        // 静态工厂实现方法
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        // 增强
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "init main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> list = Arrays.asList("1,2", "3, 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(list)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

}