//package com.example.springbootlogback;
//
//import ch.qos.logback.classic.LoggerContext;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.env.PropertySourceLoader;
//import org.springframework.boot.env.YamlPropertySourceLoader;
//import org.springframework.core.env.PropertySource;
//import org.springframework.core.io.Resource;
//
//import java.io.IOException;
//
///**
// * @Description
// * @Author Mico
// * @Date 2024/5/16 下午2:17
// */
//@Slf4j
//public class ConfigFileLocationPrinter implements PropertySourceLoader {
////    public String[] getFileExtensions() {
////        return new String[] { "yml", "yaml" };
////    }
////
////    @Override
////    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
////        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
////        if (context != null&& !context.getTurboFilterList().isEmpty()&&context.getTurboFilterList().size() ==1){
////            context.resetTurboFilterList();
////        }
////        log.info("Loading properties file: {}", resource.getURL());
////        return (new YamlPropertySourceLoader()).load(name, resource);
////    }
//@Override
//public String[] getFileExtensions() {
//    return new String[] { "yml", "yaml" };
//}
//    @Override
//    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
//        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
//        if (context != null&& !context.getTurboFilterList().isEmpty()&&context.getTurboFilterList().size() ==1){
//            context.resetTurboFilterList();
//        }
//        log.info("Loading properties file: {}", resource.getURL());
//        return (new YamlPropertySourceLoader()).load(name, resource, profile);
//    }
//}
//
