package com.sofrog.project.tool;

import java.nio.file.Paths;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create(
                "jdbc:mysql://localhost:3306/sodb?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8",
                "root", "123456")
                .globalConfig(builder -> builder
                        .author("sofrog")
                        .enableSwagger()
                        .enableSpringdoc()
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java/")
                        .commentDate("yyyy-MM-dd"))
                .packageConfig(builder -> builder
                        .parent("com.sofrog.project.biz")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml"))
                .strategyConfig(builder -> builder
                        .addInclude("t_test")
                        .addTablePrefix("t_")
                        .entityBuilder()
                        .enableLombok())
                .execute();
    }
}
