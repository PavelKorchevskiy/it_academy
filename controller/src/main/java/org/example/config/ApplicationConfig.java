package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("org.example")
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = "org.example.repository",
    entityManagerFactoryRef = "factory",
    transactionManagerRef = "jpaTransactionManager")
public class ApplicationConfig {

  @Bean
  public InternalResourceViewResolver internalResourceViewResolver(
      @Autowired ApplicationContext ctx) {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setApplicationContext(ctx);
    resolver.setPrefix("/pages/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
}
