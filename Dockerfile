# 使用官方的 OpenJDK 作为基础镜像
FROM openjdk:8-jre-slim

# 将 Spring Boot jar 包复制到容器中
COPY target/test-jdk8-*.jar /app.jar

# 运行 Spring Boot 应用
ENTRYPOINT ["java", "-jar", "/app.jar"]
