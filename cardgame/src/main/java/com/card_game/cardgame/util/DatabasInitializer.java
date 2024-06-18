package com.card_game.cardgame.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabasInitializer implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        executeSqlScript("db_setup.sql");
    }

    private void executeSqlScript(String scriptPath) {
        // Execute the SQL script
        try {
            ClassPathResource resource = new ClassPathResource(scriptPath);
            ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), resource);
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute SQL script: " + scriptPath, e);
        }
    }
}
