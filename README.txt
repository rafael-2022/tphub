Compilacao utilizando container (Docker):

Conteudo do Dockerfile:

#Dockerfile Start
FROM openjdk:8-jdk-alpine
COPY apache-maven-3.6.3 /usr/share/maven
RUN ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
#Dockerfile end

Versao do Maven: 3.6.3

Procedimento:
- Instale o Docker em seu sistema
- Crie um diretorio vazio
- Dentro do diretorio crie o arquivo Dockerfile com o conteudo acima
- Baixe a versao do Maven, decompacte e copie o diretorio do Maven para o diretorio criado
- Conteudo do diretorio:

total 8,0K
drwxrwxr-x. 6 sergio sergio 4,0K abr 30 11:10 apache-maven-3.6.3
-rw-rw-r--. 1 sergio sergio  116 abr 30 12:51 Dockerfile

- Crie a imagem com o comando:

docker build -t java:compiler .

- Utilize o comando para rodar o container com o comando /bin/sh

docker run -it -v <DIRETORIO-DO-REPOSITORIO>:/DEV java:compiler /bin/sh

- <DIRETORIO-DO-REPOSITORIO> deve ser o caminho para o repositorio do projeto
- Execute o comando para entrar no diretorio do projeto:

cd /DEV

- Execute o comando do Maven para compilar o projeto:

mvn install

- Caso queira desabilitar os testes, execute:

mvn install -DskipTests

- Caso ocorra erro de conexão SSL (https), execute:
mvn install -DskipTests -Dmaven.wagon.http.ssl.insecure=true


