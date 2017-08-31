package io.cucumber.samples.dw;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by stlv for developerworks article
 */
@Configuration
@ImportResource(value = "classpath*:spring-jdbc.xml")
@ComponentScan({"io.cucumber.samples.dw.service.impl", "io.cucumber.samples.dw.controller"})
@EnableAutoConfiguration
@Scope(scopeName = "singleton")
public class AppStarter implements ApplicationContextAware {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) throws Exception {
        System.setProperty("server.port", "8080");
        System.setProperty("server.contextPath", "/dw");
        SpringApplication.run(AppStarter.class, args);

    }

    public void initDatabase(String initScript) throws Exception {
        String ddlContent = IOUtils.toString(this.getClass().getResourceAsStream(initScript));
        String[] sqlStatements = ddlContent.split(";");
        sqlStatements = ArrayUtils.remove(sqlStatements, sqlStatements.length - 1);
        for (int i = 0; i < sqlStatements.length; i++) {
            System.err.println("\n\nBelow SQL statement is gonna being added into batch execution:" + sqlStatements[i]);
            sqlStatements[i] = sqlStatements[i].replaceAll("\n", "").replaceAll("\r", "");
        }
        jdbcTemplate.batchUpdate(sqlStatements);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        try {
            this.initDatabase("/db/init.ddl");
        } catch (Exception e) {
            throw new RuntimeException("Error while initializing the database environment!", e);
        }
    }
}
