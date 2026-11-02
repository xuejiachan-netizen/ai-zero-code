package com.xuanjia.xuanjiazerocode.ai.core;

import com.xuanjia.xuanjiazerocode.ai.AICodeGenerateService;
import com.xuanjia.xuanjiazerocode.ai.model.HtmlCodeResult;
import com.xuanjia.xuanjiazerocode.ai.model.MultiFileResult;
import com.xuanjia.xuanjiazerocode.ai.model.enums.CodeGenTypeEnum;
import com.xuanjia.xuanjiazerocode.exception.BusinessException;
import com.xuanjia.xuanjiazerocode.exception.ErrorCode;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class AICodeGeneratorFacade {

    @Resource
    private AICodeGenerateService aiCodeGenerateService;

    public File aiCodeGeneratorFacade(CodeGenTypeEnum codeGenTypeEnum, String userMessage){
        if (codeGenTypeEnum == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请选择正确的文档生成格式!");
        }

        switch (codeGenTypeEnum){
            case HTML -> {return generateHtml(userMessage);}
            case MULTI_FILE -> {return generateMultiFile(userMessage);}
            default -> throw new IllegalStateException("Unexpected value: " + codeGenTypeEnum);
        }

    }

    private File generateHtml(String userMessage){

        HtmlCodeResult htmlCodeResult = aiCodeGenerateService.codeGenerateHtml(userMessage);

        CodeFileSaver codeFileSaver = new CodeFileSaver();

        File file = codeFileSaver.saveHtmlCodeResult(htmlCodeResult);

        return file;
    }

    private File generateMultiFile(String userMessage) {
        MultiFileResult multiFileResult = aiCodeGenerateService.codeMultiGenerateHtml(userMessage);

        CodeFileSaver codeFileSaver = new CodeFileSaver();

        File file = codeFileSaver.saveMultiFileCodeResult(multiFileResult);

        return file;
    }
}
