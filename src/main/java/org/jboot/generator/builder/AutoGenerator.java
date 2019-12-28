package org.jboot.generator.builder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jboot.generator.constants.Constants;
import org.jboot.generator.utils.FreemarkerUtil;
import org.jboot.generator.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.util.IOUtils;

import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 自动生成代码构造器
 * 
 * @author liwen
 *
 */
public class AutoGenerator {

    private final static Logger logger = LoggerFactory.getLogger(AutoGenerator.class);

    public void generatorAttr(TableInfo tableInfo) {
        FileWriter write = null;
        try {
            if (StringUtils.isNotBlank(tableInfo.getPackageName())) {
                String path = tableInfo.getPackageName().replace(".", "/");
                File file = new File(Constants.java + File.separator + path + "/attr");
                if (!file.exists()) {
                    file.mkdirs();
                }
                write =
                    new FileWriter(new File(file, StringUtils.toUpperCaseFirst(tableInfo.getEntityName()) + ".java"));
                Template template = FreemarkerUtil.getTemplate("Attr.ftl");
                template.process(tableInfo, write);
                write.flush();
            }
        } catch (IOException | TemplateException e) {
            logger.error("auto dao fail:", e);
        } finally {
            IOUtils.close(write);
        }
    }

    public void generatorEntity(TableInfo tableInfo) {
        FileWriter write = null;
        try {
            if (StringUtils.isNotBlank(tableInfo.getPackageName())) {
                String path = tableInfo.getPackageName().replace(".", "/");
                File file = new File(Constants.java + File.separator + path + "/entity");
                if (!file.exists()) {
                    file.mkdirs();
                }
                write =
                    new FileWriter(new File(file, StringUtils.toUpperCaseFirst(tableInfo.getEntityName()) + "VO.java"));
                Template template = FreemarkerUtil.getTemplate("Entity.ftl");
                template.process(tableInfo, write);
                write.flush();
            }
        } catch (IOException | TemplateException e) {
            logger.error("auto dao fail:", e);
        } finally {
            IOUtils.close(write);
        }
    }

    public void generatorDao(TableInfo tableInfo) {
        FileWriter write = null;
        try {
            if (null != tableInfo.getPackageName() && !"".equals(tableInfo.getPackageName().trim())) {
                String path = tableInfo.getPackageName().replace(".", "/");
                File file = new File(Constants.java + File.separator + path + "/dao");
                if (!file.exists()) {
                    file.mkdirs();
                }
                write = new FileWriter(
                    new File(file, "I" + StringUtils.toUpperCaseFirst(tableInfo.getEntityName()) + "Dao.java"));
                Template template = FreemarkerUtil.getTemplate("IDao.ftl");
                template.process(tableInfo, write);
                write.flush();
            }
        } catch (IOException | TemplateException e) {
            logger.error("auto dao fail:", e);
        } finally {
            IOUtils.close(write);
        }
    }

    public void generatorIService(TableInfo tableInfo) {
        FileWriter write = null;
        try {
            if (null != tableInfo.getPackageName() && !"".equals(tableInfo.getPackageName().trim())) {
                String path = tableInfo.getPackageName().replace(".", "/");
                File file = new File(Constants.java + File.separator + path + "/service");
                if (!file.exists()) {
                    file.mkdirs();
                }
                write = new FileWriter(
                    new File(file, "I" + StringUtils.toUpperCaseFirst(tableInfo.getEntityName()) + "Service.java"));
                Template template = FreemarkerUtil.getTemplate("IService.ftl");
                template.process(tableInfo, write);
                write.flush();
            }
        } catch (IOException | TemplateException e) {
            logger.error("auto dao fail:", e);
        } finally {
            IOUtils.close(write);
        }
    }

    public void generatorService(TableInfo tableInfo) {
        FileWriter write = null;
        try {
            if (null != tableInfo.getPackageName() && !"".equals(tableInfo.getPackageName().trim())) {
                String path = tableInfo.getPackageName().replace(".", "/");
                File file = new File(Constants.java + File.separator + path + "/service/impl");
                if (!file.exists()) {
                    file.mkdirs();
                }
                write = new FileWriter(
                    new File(file, StringUtils.toUpperCaseFirst(tableInfo.getEntityName()) + "Service.java"));
                Template template = FreemarkerUtil.getTemplate("Service.ftl");
                template.process(tableInfo, write);
                write.flush();
            }
        } catch (IOException | TemplateException e) {
            logger.error("auto dao fail:", e);
        } finally {
            IOUtils.close(write);
        }
    }

    public void generatorController(TableInfo tableInfo) {
        FileWriter write = null;
        try {
            if (null != tableInfo.getPackageName() && !"".equals(tableInfo.getPackageName().trim())) {
                String path = tableInfo.getPackageName().replace(".", "/");
                File file = new File(Constants.java + File.separator + path + "/controller");
                if (!file.exists()) {
                    file.mkdirs();
                }
                write = new FileWriter(
                    new File(file, StringUtils.toUpperCaseFirst(tableInfo.getEntityName()) + "Controller.java"));
                Template template = FreemarkerUtil.getTemplate("Controller.ftl");
                template.process(tableInfo, write);
                write.flush();
            }
        } catch (IOException | TemplateException e) {
            logger.error("auto dao fail:", e);
        } finally {
            IOUtils.close(write);
        }
    }

    public void generatorMapper(TableInfo tableInfo) {
        FileWriter write = null;
        try {
            if (null != tableInfo.getPackageName() && !"".equals(tableInfo.getPackageName().trim())) {
                File file = new File(Constants.resources + File.separator + "/mappers");
                if (!file.exists()) {
                    file.mkdirs();
                }
                write = new FileWriter(
                    new File(file, "I" + StringUtils.toUpperCaseFirst(tableInfo.getEntityName()) + "Dao.xml"));
                Template template = FreemarkerUtil.getTemplate("Mapper.ftl");
                template.process(tableInfo, write);
                write.flush();
            }
        } catch (IOException | TemplateException e) {
            logger.error("auto dao fail:", e);
        } finally {
            IOUtils.close(write);
        }
    }

    public void generatorMapper(List<TableInfo> talbes, String packageName) {
        for (TableInfo tableInfo : talbes) {
            generatorMapper(tableInfo);
        }
    }

    public void generatorAttr(List<TableInfo> talbes, String packageName) {
        for (TableInfo tableInfo : talbes) {
            tableInfo.setPackageName(packageName);
            generatorAttr(tableInfo);
        }
    }

    public void generatorEntity(List<TableInfo> talbes, String packageName) {
        for (TableInfo tableInfo : talbes) {
            tableInfo.setPackageName(packageName);
            generatorEntity(tableInfo);
        }
    }

    public void generatorDao(List<TableInfo> talbes, String packageName) {
        for (TableInfo tableInfo : talbes) {
            tableInfo.setPackageName(packageName);
            generatorDao(tableInfo);
        }
    }

    public void generatorIService(List<TableInfo> talbes, String packageName) {
        for (TableInfo tableInfo : talbes) {
            tableInfo.setPackageName(packageName);
            generatorIService(tableInfo);
        }
    }

    public void generatorService(List<TableInfo> talbes, String packageName) {
        for (TableInfo tableInfo : talbes) {
            tableInfo.setPackageName(packageName);
            generatorService(tableInfo);
        }
    }

    public void generatorController(List<TableInfo> talbes, String packageName) {
        for (TableInfo tableInfo : talbes) {
            tableInfo.setPackageName(packageName);
            generatorController(tableInfo);
        }
    }

}
