# Template de microserviço com springboot
Este template é totalmente funcional. Ele utiliza tecnologia springboot com java jdk 8 ou superior, compilado com maven 3+. 

Para ajudar na configuração completa do ambiente local de desenvolvimento, este template utiliza docker em modo swarm, com os serviços abaixo:
- banco de dados PostgresSQL 11
- mensageria Kafka
- MongoDB 4.1

Portanto, para execução de todos os recursos do template é necessário conferir os seguintes pré-requisitos:
- docker com swarm
- jdk 1.8 ou superior

## Compilação do microserviço
Junto com a compilação do código fonte java, o template também prepara alguns arquivos que serão utilizados para montar a stack no docker. 
Para compilar o template, utilize o comando maven tradicional:

```
mvn clean package
```

Ao finalizar a compilação, verifique que no diretório "target" estarão, além do compilado java, alguns arquivos auxiliares:

- Dockerfile: arquivo de instruções para montar a imagem docker da aplicação java;
- docker-compose.yml: compose para montar a stack completa no docker service, incluindo a própria aplicação java;
- docker-stack.yml: compose para montar a stack completa no docker service, sem a aplicação java;
- README-stack.md: instruções para subir a stack no docker;
- curl-requests.txt: exemplos de requests no curl para a aplicação java;
- postman-collection.json: coleção de requests no postman para a aplicação java;
- stack.sh: shell script para automatizar tarefa de subida da stack;
- standalone.sh: shell script para automatizar tarefa de subida de containers simples das ferramentas auxiliares.

## Stack de desenvolvimento
Tal como mencionado no início deste README, este template utiliza postgres, kafka e mongodb integrados ao java springboot.

Para subir a stack de desenvolvimento completa em sua estação de trabalho, execute o comando stack.sh, localizado no diretório target do projeto (após compilar com maven):

```
$ cd target
$ chmod +x stack.sh
$ ./stack.sh
```
Após subir a stack, será possível observar os serviços docker rodando:
![docker.services](docker.services.png)
