package com.xuanjia.xuanjiazerocode.ai.model;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

@Data
@Description("生成多个代码文件的代码结果")
public class MultiFileResult {

    @Description("html 代码")
    String htmlCode;

    @Description("css 代码")
    String cssCode;

    @Description("js 代码")
    String jsCode;

    @Description("描述")
    String descrition;
}
