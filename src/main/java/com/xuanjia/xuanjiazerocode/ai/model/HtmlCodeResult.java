package com.xuanjia.xuanjiazerocode.ai.model;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

@Data
@Description("生成 HTML 的代码结果")
public class HtmlCodeResult {

    @Description("html 代码")
    String htmlCode;

    @Description("描述")
    String description;
}
