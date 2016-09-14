/**
 * Created by Ben on 8/30/2016.
 */

package com.ben.domain;

import com.ben.domain.jpa.listener.BaseDomainObjectEventListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
//@EnableJpaRepositories
@EnableWebMvc
@Import(RepositoryRestMvcConfiguration.class)  //https://spring.io/guides/gs/accessing-data-rest/
public class AppConfig extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AppConfig.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        // Configure JSON support
//        MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        mappingJacksonHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        mappingJacksonHttpMessageConverter.getObjectMapper().setDateFormat(format);
//        mappingJacksonHttpMessageConverter.setPrettyPrint(true);
//        // mappingJacksonHttpMessageConverter.getObjectMapper().getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
//        converters.add(mappingJacksonHttpMessageConverter);
//    }

    @Bean
    BaseDomainObjectEventListener baseDomainObjectEventListener() {
        return new BaseDomainObjectEventListener();
    }
}


//@Configuration
//@ComponentScan("com.ben")
//@EnableAutoConfiguration
//@SpringBootApplication
//@EnableJpaRepositories
//@Import(RepositoryRestMvcConfiguration.class)
//@EnableTransactionManagement
//@EnableWebMvc
//@PropertySource("classpath:application.properties")
//@EnableScheduling
//public class AppConfig {
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//
////    @Value("${jdbc.driverClassName}")
////    private String driverClassName;
////
////    @Value("${jdbc.url}")
////    private String url;
////
////    @Value("${jdbc.username}")
////    private String username;
////
////    @Value("${jdbc.password}")
////    private String password;
////
////    @Value("${spring.jpa.show-sql")
////    private String showSql;
////
////    @Value("${fileUpload.maxUploadSize}")
////    private String maxUploadSize;
//
//    /**
//     * Bootstraps an in-memory HSQL database.
//     *
//     * @return
//     * @see http
//     *      ://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html#
//     *      jdbc-embedded-database
//     *      -support
//     */
////    @Bean
////    public DataSource dataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName(driverClassName);
////        dataSource.setUrl(url);
////        dataSource.setUsername(username);
////        dataSource.setPassword(password);
////
////        return dataSource;
////        /*
////         * EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
////         * return builder.setType(EmbeddedDatabaseType.HSQL).build();
////         */
////    }
//
//    /**
//     * Sets up a {@link LocalContainerEntityManagerFactoryBean} to use Hibernate. Activates picking
//     * up entities from the
//     * project's base package.
//     *
//     * @return
//     */
////    @Bean
////    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
////
////        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
////        vendorAdapter.setDatabase(Database.MYSQL);
////        // vendorAdapter.setDatabase(Database.HSQL);
////        vendorAdapter.setGenerateDdl(true);
////        vendorAdapter.setShowSql(Boolean.parseBoolean(showSql));
////
////        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
////        factory.setJpaVendorAdapter(vendorAdapter);
////        factory.setPackagesToScan(getClass().getPackage().getName());
////        factory.setDataSource(dataSource());
////
////        return factory;
////    }
//
//    /*
//     * (non-Javadoc)
//     * @see
//     * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers
//     * (org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
//     */
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/explorer/**").addResourceLocations("/explorer/");
////        registry.addResourceHandler("/example/**").addResourceLocations("/example/");
////        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
////    }
//
////    @Bean
////    public PlatformTransactionManager transactionManager() {
////
////        JpaTransactionManager txManager = new JpaTransactionManager();
////        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
////        return txManager;
////    }
////
////    @Override
////    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
////        // Configure JSON support
////        MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
////        mappingJacksonHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
////        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
////        mappingJacksonHttpMessageConverter.getObjectMapper().setDateFormat(format);
////        mappingJacksonHttpMessageConverter.setPrettyPrint(true);
////        // mappingJacksonHttpMessageConverter.getObjectMapper().getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
////        converters.add(mappingJacksonHttpMessageConverter);
////    }
////
////    @Bean
////    public CommonsMultipartResolver multipartResolver() {
////        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
////        commonsMultipartResolver.setDefaultEncoding("utf-8");
////        commonsMultipartResolver.setMaxUploadSize(Long.parseLong(maxUploadSize));
////        return commonsMultipartResolver;
////    }
//
////    @Bean
////    BaseDomainObjectEventListener baseDomainObjectEventListener() {
////        return new BaseDomainObjectEventListener();
////    }
//
////    @Bean
////    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
////        return new PropertySourcesPlaceholderConfigurer();
////    }
//
//}
