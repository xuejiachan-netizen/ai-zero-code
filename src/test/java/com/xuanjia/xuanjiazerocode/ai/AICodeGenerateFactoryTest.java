package com.xuanjia.xuanjiazerocode.ai;

import com.xuanjia.xuanjiazerocode.ai.model.HtmlCodeResult;
import com.xuanjia.xuanjiazerocode.ai.model.MultiFileResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;


@SpringBootTest
class AICodeGenerateFactoryTest {

    @Resource
    private AICodeGenerateService generateService;

    @Test
    void codeGenerate(){
        String userMessage = "我想要你帮我做一个类似倒数日的日历";

        HtmlCodeResult htmlCodeResult = generateService.codeGenerateHtml(userMessage);

        Assertions.assertNotNull(htmlCodeResult);
    }


    @Test
    void multiCodeGenerate(){
        String userMessage = "我需要做一个满足签到功能的系统";

        MultiFileResult multiFileResult = generateService.codeMultiGenerateHtml(userMessage);

        Assertions.assertNotNull(multiFileResult);
    }

    @Test
    void demo(){
        String userMessage = "你好，只需要回复你好";

        HtmlCodeResult htmlCodeResult = generateService.codeGenerateHtml(userMessage);
//        Flux<String> stringFlux = generateService.codeGenerateHtmlFlux(userMessage);

        Assertions.assertNotNull(htmlCodeResult);
    }
}