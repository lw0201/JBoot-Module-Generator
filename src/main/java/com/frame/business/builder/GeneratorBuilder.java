package com.frame.business.builder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
public class GeneratorBuilder {

    private final static Logger logger = LoggerFactory.getLogger(GeneratorBuilder.class);

    public void excute() {
        List<TableInfo> talbes = DataSourceUtil.getTables();
        generatorEntity(talbes);
        generatorDao(talbes);
        generatorMapper(talbes);
        generatorIService(talbes);
        generatorService(talbes);
        generatorController(talbes);

    }

    public void generatorEntity(TableInfo tableInfo) {
        FileWriter write = null;
        try {
            if (StringUtils.isNotBlank(tableInfo.getPackageName())) {
                String path = tableInfo.getPackageName().replace(".", "/");
                File file = new File(Constant.java + File.separator + path + "/entity");
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
                File file = new File(Constant.java + File.separator + path + "/dao");
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
                File file = new File(Constant.java + File.separator + path + "/service");
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
                File file = new File(Constant.java + File.separator + path + "/service/impl");
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
                File file = new File(Constant.java + File.separator + path + "/controller");
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
                File file = new File(Constant.resources + File.separator + "/mappers");
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

    public void generatorMapper(List<TableInfo> talbes) {
        for (TableInfo tableInfo : talbes) {
            generatorMapper(tableInfo);
        }
    }

    public void generatorEntity(List<TableInfo> talbes) {
        for (TableInfo tableInfo : talbes) {
            generatorEntity(tableInfo);
        }
    }

    public void generatorDao(List<TableInfo> talbes) {
        for (TableInfo tableInfo : talbes) {
            generatorDao(tableInfo);
        }
    }

    public void generatorIService(List<TableInfo> talbes) {
        for (TableInfo tableInfo : talbes) {
            generatorIService(tableInfo);
        }
    }

    public void generatorService(List<TableInfo> talbes) {
        for (TableInfo tableInfo : talbes) {
            generatorService(tableInfo);
        }
    }

    public void generatorController(List<TableInfo> talbes) {
        for (TableInfo tableInfo : talbes) {
            generatorController(tableInfo);
        }
    }

    public static void main(String[] args) {

        GeneratorBuilder bulder = new GeneratorBuilder();
        bulder.excute();
    }

}
