//package com.example.springbootlogback;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
//import org.springframework.context.ApplicationContextInitializer;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.core.env.ConfigurableEnvironment;
//
///**
// * @Description
// * @Author Mico
// * @Date 2024/5/16 下午4:46
// */
//@Slf4j
//public class YamlPathPrinterInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, ApplicationListener<ApplicationEnvironmentPreparedEvent> {
//
//    @Override
//    public void initialize(ConfigurableApplicationContext applicationContext) {
//        ConfigurableEnvironment environment = applicationContext.getEnvironment();
//        environment.getPropertySources().forEach(propertySource -> System.out.println(propertySource.getName()));
////        MutablePropertySources mutablePropertySources = environment.getPropertySources();
////        if (Objects.nonNull(mutablePropertySources)){
////            Stream<PropertySource<?>> stream = mutablePropertySources.stream();
////            stream.forEach(propertySource -> {
////                if (propertySource instanceof OriginTrackedMapPropertySource){
////                    Resource[] resources = (Resource[]) propertySource.getSource();
////                    for (Resource resource : resources) {
////                        try {
////                            log.info("{}", resource.getURL());
////                        } catch (IOException e) {
////                            throw new RuntimeException(e);
////                        }
////                    }
////                }
////
////            });
////        }
////        Resource[] propertySources = environment.getPropertySources().get("Config resource 'class path resource [application-dev.yml]' via location 'optional:classpath:/'") != null ?
////                (Resource[]) environment.getPropertySources().get("Config resource 'class path resource [application.yml]' via location 'optional:classpath:/'").getSource() : null;
////        if (propertySources != null) {
////            for (Resource resource : propertySources) {
////                try {
////                    System.out.println("Reading YAML file from: " + resource.getURI());
////                } catch (IOException e) {
////                    throw new RuntimeException(e);
////                }
////            }
////        }
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
//        System.out.println("Spring Boot is loading the following configuration files:");
//        event.getEnvironment().getPropertySources().forEach(propertySource -> System.out.println(propertySource.getName()));
//    }
//}
