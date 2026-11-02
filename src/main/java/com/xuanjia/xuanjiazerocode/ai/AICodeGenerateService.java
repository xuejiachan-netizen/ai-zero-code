package com.xuanjia.xuanjiazerocode.ai;

import com.xuanjia.xuanjiazerocode.ai.model.HtmlCodeResult;
import com.xuanjia.xuanjiazerocode.ai.model.MultiFileResult;
import dev.langchain4j.service.SystemMessage;
import reactor.core.publisher.Flux;

public interface AICodeGenerateService {

    @SystemMessage(fromResource = "prompt/codegen-html-multi-system-prompt.txt")
    HtmlCodeResult codeGenerateHtml(String userMessage);

    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    MultiFileResult codeMultiGenerateHtml(String userMessage);

    @SystemMessage(fromResource = "prompt/codegen-html-multi-system-prompt.txt")
    Flux<String> codeGenerateHtmlFlux(String userMessage);

    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    Flux<String>  codeMultiGenerateHtmlFlux(String userMessage);

    String demo(String userMessage);
}
