package org.jboot.generator.builder;

import java.sql.Connection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitBean implements InitializingBean {

    private final static Logger logger = LoggerFactory.getLogger(InitBean.class);

    @Autowired
    private SpringDataSource springDataSource;

    @Autowired
    private Generator generator;

    @Override
    public void afterPropertiesSet() throws Exception {
        Connection conn = JdbcUtil.getConnection(springDataSource.getUrl(), springDataSource.getUsername(),
            springDataSource.getPassword());
        List<TableInfo> talbes = JdbcUtil.getTables(conn);
        GeneratorBuilder builder = new GeneratorBuilder();
        builder.generatorEntity(talbes, generator.getPackageName());
        builder.generatorDao(talbes, generator.getPackageName());
        builder.generatorMapper(talbes, generator.getPackageName());
        builder.generatorIService(talbes, generator.getPackageName());
        builder.generatorService(talbes, generator.getPackageName());
        builder.generatorController(talbes, generator.getPackageName());
        logger.info("auto code  generator complete.......");
        System.exit(0);
    }

}
