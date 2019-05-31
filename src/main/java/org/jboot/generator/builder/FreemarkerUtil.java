package org.jboot.generator.builder;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * freemarker工具类
 * 
 * @author liwen
 * @version V1.0
 */
public class FreemarkerUtil {

    private final static Logger logger = LoggerFactory.getLogger(FreemarkerUtil.class);

    private static Configuration cfg = null;

    static {
        try {
            if (null == cfg) {
                cfg = new Configuration(Configuration.VERSION_2_3_27);
                cfg.setDefaultEncoding("UTF-8");
                cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
                cfg.setLogTemplateExceptions(false);
                cfg.setWrapUncheckedExceptions(true);
                cfg.setDirectoryForTemplateLoading(new File(FreemarkerUtil.class.getResource("/templates").getPath()));
            }
        } catch (IOException e) {
            logger.error("Freemaker Error:", e);
        }

    }

    /**
     * 获取模板内容
     *
     * @param template
     *            模板文件
     * @param map
     *            模板参数
     * @return 渲染后的模板内容
     * @throws IOException
     *             Io异常
     * @throws TemplateException
     *             template 异常
     */
    public static Template getTemplate(String templateName) {
        Template template = null;
        try {
            template = cfg.getTemplate(templateName);
        } catch (IOException e) {
            logger.error("Failed to get template.", e);
        }
        return template;
    }

}
