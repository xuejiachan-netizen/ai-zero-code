package com.xuanjia.xuanjiazerocode.ai;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AICodeGenerateFactory {

    @Resource
    private ChatModel chatModel;

    @Bean
    public AICodeGenerateService aiCodeGenerate(){
        AICodeGenerateService aiCodeGenerateService = AiServices.create(AICodeGenerateService.class, chatModel);

        return aiCodeGenerateService;
    }
}
