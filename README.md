# PWS2020

WebApp feito para ser executado em um servidor com suporte a ferramenta Tomcat para a componente professor.

## Índice

* [Requerimentos](#requerimentos)
* [Instalação](#instalação)
* [Teste](#teste)
* [Autores](#autores)

## Requerimentos

Projeto foi criado e testado com:
* Java SDK 11
* Apache Tomcat 9.0.31
* Eclipse, opção Java EE (Recomendado)

## Instalação

Como foi elaborado em um ambiente linux (debian), os passos a seguir levam em consideração esse ambiente. Diferentes sistemas operacionais precisam de outras ações que não são cobertas aqui. 

### Java SDK

Se já estiver instalado o SDK necessário para compilar o móduloprofessor, pode pular essa etapa de instalação e seguir para instalação do Apache Tomcat. Senão, siga os passos:

1. [Baixar](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) os binários ou instaladores apropriados para o seu sistema operacional e instalá-los.
2. Para configurar a variável de ambiente, execute o comando:

```
sudo update-alternatives --config java
```
Será retornado todas as instalações do java, queremos o endereço até a pasta que inclua "jdk" (Exemplo: */usr/lib/jvm/java-11-openjdk-amd64/*) e sua versão no caminho. Será chamado de **caminho\_pro\_java**

3. Agora, modifique o arquivo em */etc/profile* e inclua os comandos:
```
export JAVA_HOME="caminho_pro_java" 
export PATH=$JAVA_HOME:$PATH
```

### Apache Tomcat

1. [Baixar](https://tomcat.apache.org/download-90.cgi) os binário ou o instalador apropriado para o seu sistema operacional, se ecnontram na seção "Core". 
2. Extraia o pacote zip/tar.gz em uma pasta.
3. Abra o terminal e, dentro da pasta bin do tomcat, faça:

```
./startup.sh
```

4. Se tudo ocorrer bem, uma mensagem aparecerá a seguinte mensagem:

```
Tomcat started
```

5. Para acessar o servidor, basta digitar ** localhost:8080/ ** no navegador. Irá aparecer uma página padrão do tomcat.
6. Para encerrar, basta fazer:

```
./shutdown.sh
```

### Eclipse

Embora seja possível a utilziação de outra IDE para editar uma variedade de diferentes tipos de arquivos (java, JSP, HTML, etc...), devido a fácil configuração e possibilidade de editar código e ver a prória atualização com o servidor ligado, recomenda-se o uso da IDE Eclipse. Se optar por outra opção, lembre-se de instalar o Java Entrepreise Edition, de maneira parecida com o procedimento com o Java SDK. Aqui seguem os passos para fazer a instalação correta e configuração:

1. Faça download do instalador no [site](https://www.eclipse.org/downloads/).
2. Rode o instalador, e selecione a opção "Eclipse IDE for Entrepise Java Developers".
3. Mude a perspectiva para java (Ícone de uma janela com uma estrela, no canto superior direito).
4. Aperte Ctrl+3 e digite **servers**.
5. Clique com o botão direito na aba "servers", e depois clique em **New**.
6. Selecione o Apache Tomcat 9.0, e aperte "Next".
7. Atualize o endereço de instalação do Tomcat (Ex: /home/usuario/Documents/apache-tomcat-9.0.31), e aperte "Finish".
8. Na "Servers", dê dois cliques no servidor. Em "Servers Locations", mude a opção para usar o local da instalação do Tomcat.
9. Clique no servidor, e clique no botão de rodar (circulo verde com seta branca) e, teste novamente o endereço (*localhost*) da seção anterior.
10. O servidor está rodando e mostrando a página padrão do tomcat, mas ainda não está configurado para inculir o projeto. Para isso, clique com o botão direito no servidor, e clique a opção "Add & Remove" e clique em "Add" para colocar na janela de configurados. Aperte "Finish".
11. Com o endereço do *localhost* acrescente "webserver" (nome do projeto) e estará acessando a página *index* do aplicativo web.

Agora você pode inicializar o tomcat direto do eclipse, com todas as dependências necessárias para desenvolvivemento web em Java.

## Teste

Dentro da pasta "webserver" (nome do projeto), os arquivos em "java.resources" cuidam da lógica do servidor (upload de arquivos, direcionamento de requisições http, etc). A pasta "WebContent" possui quaisquer arquivos relacionados a exibição da página web para o navegador (html, jsp, xml) , e as bibliotecas externas necessárias (jar).

Para acessar a página padrão do aplicativo web, basta adicionar */webserver/* depois do endereço local do seu servidor. 

### Arquivo WAR

Eventualmente, ao final das modificações, será necessário fazer *redepoly* no servinder onde está instalado o tomcat. Assim, é necessário mm arquivo war (web archive) contém todas as informações do projeto. Para gerar esse arquivo, existem duas maneiras:

1. Pelo Eclipse, no menu File -> Export. Filtre por "war", selecione e clique ok. (Recomendado)
2. Pelo ferramenta *jar*. No terminal, acesse a pasta do projeto e difite o comando:

```
jar -cvf nome_do_projeto.war *  
```

## Autores

Diego Martos Buoro (@dmb42odyssey)
