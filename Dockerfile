FROM openjdk:21 
COPY "./target/ConsultasMedicas-1.jar" "app.jar"
EXPOSE 8090 
ENTRYPOINT [ "java", "-jar", "app.jar" ] 
