package com.xuanjia.xuanjiazerocode.ai.core;

import com.xuanjia.xuanjiazerocode.ai.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AICodeGeneratorFacadeTest {

    @Resource
    private AICodeGeneratorFacade aiCodeGeneratorFacade;

    @Test
    void generateHtml(){
        CodeGenTypeEnum html = CodeGenTypeEnum.HTML;
        String userMessage = "生产一个简单的日历网页";
//        String userMessage = "你好，只用回复你好，目前处于测试阶段";
        File file = aiCodeGeneratorFacade.aiCodeGeneratorFacade(html, userMessage);

        Assertions.assertNotNull(file);
    }

    @Test
    void generateMultiply(){
        CodeGenTypeEnum multiFile = CodeGenTypeEnum.MULTI_FILE;
        String userMessage = "生成一个简单的签到网页";

        File file = aiCodeGeneratorFacade.aiCodeGeneratorFacade(multiFile, userMessage);

        Assertions.assertNotNull(file);
    }


}