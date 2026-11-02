package com.xuanjia.xuanjiazerocode.ai.core;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.xuanjia.xuanjiazerocode.ai.model.HtmlCodeResult;
import com.xuanjia.xuanjiazerocode.ai.model.MultiFileResult;
import com.xuanjia.xuanjiazerocode.ai.model.enums.CodeGenTypeEnum;

import java.io.File;

public class CodeFileSaver {

    //文件保存根目录
    private static final String FILE_SAVE_ROOT_PATH_DIR = System.getProperty("user.dir") + "/tmp/code_output";

    /**
     * 保存 htmlCodeResult
     */
    public File saveHtmlCodeResult(HtmlCodeResult codeResult){

        String dirPath = buildUniqueDir(CodeGenTypeEnum.HTML.getValue());

        writeTofile(dirPath, "index.html" ,codeResult.getHtmlCode());

        return new File(dirPath);
    }

    public File saveMultiFileCodeResult(MultiFileResult multiFileResult){

        String dirPath = buildUniqueDir(CodeGenTypeEnum.MULTI_FILE.getValue());

        writeTofile(dirPath, "index.html", multiFileResult.getHtmlCode());
        writeTofile(dirPath, "style.css", multiFileResult.getCssCode());
        writeTofile(dirPath,"script.js", multiFileResult.getJsCode());

        return new File(dirPath);
    }

    /**
     * 通过雪花算法构建项目的唯一路径
     * @param bizType
     * @return
     */
    private static String buildUniqueDir(String bizType){

        String uniqueName = StrUtil.format("{}/{}", bizType, IdUtil.getSnowflakeNextIdStr());

        String dirPath = FILE_SAVE_ROOT_PATH_DIR + File.separator + uniqueName;

        FileUtil.mkdir(dirPath);

        return dirPath;
    }


    private static void writeTofile(String dirPath, String fileName, String content){

        String filePath = dirPath + File.separator + fileName;

        FileUtil.writeUtf8String(content, filePath);
    }

}
