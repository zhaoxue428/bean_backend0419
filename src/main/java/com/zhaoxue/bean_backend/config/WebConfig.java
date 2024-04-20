package com.zhaoxue.bean_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // 允许跨域请求的路径
						.allowedOrigins("http://127.0.0.1:5500") // 允许跨域请求的来源
						.allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的HTTP方法
						.allowedHeaders("*") // 允许的请求头
						.allowCredentials(true); // 是否允许发送Cookie
			}
		};
	}
}
