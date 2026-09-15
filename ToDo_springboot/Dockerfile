#Escolhendo o sistema operacional para ser utilizado na parte de build do projeto
FROM eclipse-temurin:17.0.20_8-jdk AS build

#criando uma pasta build e acessando ela
WORKDIR /build

#Copiando o arquivo mvnw e colocando dentro da pasta build
COPY mvnw .
#Copiando o arquivo pom.xml e colocando dentro da pasta build
COPY pom.xml .
#Copiando a pasta .mvn e colocando dentro da uma nova pasta chamanda .mvn dentro da pasta build
COPY .mvn .mvn

#Baixando as dependências necessárias do projeto
RUN ./mvnw dependency:go-offline

#Copiando a pasta src e colocando dentro de uma nova pasta chamada src dentro da pasta build
COPY src src

#Fazendo a compilação do projeto
RUN ./mvnw package -DskipTests

#Escolhendo o sistema operacional para rodar o projeto
FROM eclipse-temurin:17.0.20_8-jre

#criando a pasta app dentro deste OS
WORKDIR /app

#Pegando o arquivo de compialção e copiando para o arquivo app.jar dentro da pasta app
COPY --from=build /build/target/*.jar app.jar

#Falando para utilizar a porta 8080
EXPOSE 8080

#Código para ser executado assim que o projeto começar a roda, para iniciar o executável
ENTRYPOINT ["java", "-jar", "app.jar"]