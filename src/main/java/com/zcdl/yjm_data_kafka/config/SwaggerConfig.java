package com.zcdl.yjm_data_kafka.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2018/12/5.
 * Use to
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
//    @Value("${swagger.enabled}")
//    Boolean swaggerEnabled;

    @Bean
    public Docket Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
//                .pathMapping("/school")
                .apiInfo(apiInfo())
                .enable(true);
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger2")
                .contact("xiaoying")
                .description("</br>" +
                        "one" +
                        "</br>"
                )
                .version("0.1.1")
                .build();
    }
}
