# Keycloak e Postgres no docker swarm

Para utilizar o keycloak e o postgres como serviços docker na estação de trabalho, realizar os seguintes comandos:

- acesse o diretório do arquivo yaml de configuração
```
cd multiplica\mvp\ambiente\local
```

- inicialize o docker em modo swarm
```
docker swarm init
```

- aplique a stack (keycloak + postgres) no docker
```
docker stack deploy --compose-file keycloak-compose.yml kc
```

## Comandos úteis

- Listar os serviços docker e suas características básicas
```
docker service ls
```
- Listar os containers docker
```
docker container ls
```
