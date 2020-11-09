# MVP - microfrontends com single-spa

# Pré-requisitos

### Instalar/Configurar

- [node](http://nodejs.org)
- npm (junto com o node na instalação padrão)
- [yarn](https://classic.yarnpkg.com/lang/en/)
- sudo npm install -g generator-single-spa@latest
- sudo npm install -g yo@latest
- sudo npm install -g single-spa@latest

# Como o single-spa funciona

Nas palavras da própria documentação oficial, [single-spa](https://single-spa.js.org/) é um framework que possibilita trabalhar com múltiplos microfrontends javascript juntos, em uma aplicação frontend. Implementar seu frontend usando single-spa traz muitos benefícios, tais como:

- utilizr diferentes frameworks em uma única página, sem precisar de refresh (React, AngularJS, Angular, Ember, e outros);
- realizar o deploy dos seus microfrontends de modo independente;
- escrever código usando um novo framework, sem precisar reescrever seu app existente;
- menos código necessário para otimizar o tempo.

No [Getting Started ](https://single-spa.js.org/docs/getting-started-overview) do single-spa temos acesso a uma ótima descrição da arquitetura do framework.

## Partes típicas de um single-spa application

Para seu correto funcionamento, o single-spa (spa de _single page application_) necessita de dois tipos de componentes:

- root-config: é o frontend centralizador, que conterá todos os microfrontends;
- single-spa app: são os microfrontends (mfe) independentes, que serão registrados (plugados) no root-config.

# Hands on

Nesta seção da wiki você encontra os passos básicos para montar uma single page application e seus microfrontends plugados.

## Criar um root-config

```
yarn create single-spa --module-type root-config
```

## Criar um microfrontend

```
yarn create single-spa --framework react
```

## Configurar o mfe na aplicação root-config

### No arquivo index.ejs

Primeiramente, adicionar os imports referentes ao framework javascript que o microfrontend utilizará. Por exemplo, se o seu microfrontend utiliza REACT, devem ser incluídos os fontes padrão do REACT, tal como segue:

```
  <script type="systemjs-importmap">
    {
      "imports": {
        "react": "https://cdn.jsdelivr.net/npm/react@16.13.1/umd/react.production.min.js",
        "react-dom": "https://cdn.jsdelivr.net/npm/react-dom@16.13.1/umd/react-dom.production.min.js",
        "single-spa": "https://cdn.jsdelivr.net/npm/single-spa@5.5.5/lib/system/single-spa.min.js"
      }
    }
  </script>
```

Posteriormente, adicionar também o import do código-fonte do microfrontend:

```
  <script type="systemjs-importmap">
    {
      "imports": {
        ...
        "@multiplica/logo": "//localhost:9001/multiplica-logo.js"
      }
    }
  </script>
```

Por fim, incluir a instrução abaixo no body do html

```
<application name="@multiplica/logo"></application>
```

### registrar o mfe no root-config

Adicionar uma entrada no root-config.js (o nome deste arquivo muda conforme o nome da aplicação, mas termina sempre com root-config), com o nome do microfrontend que você está incluindo. Esta operação é o registro do mfe no root-config.

```
registerApplication({
   name: "@multiplica/logo",
   app: () => System.import("@multiplica/logo"),
   activeWhen: ["/"]
});
```

# Auxílios e ferramentas adicionais

### import-map-overrides

Um dos recursos disponíveis para implementação de mfe no single-spa é a lib import-map-overrides. O uso desta ferramenta permite adicionar, remover e sobrescrever mfe dentro da aplicação principal, direto no browser e em tempo de depuração. Para habilitar o import-map-overrides, abra o console do browser e digite o comando abaixo:

```
localStorage.setItem("devtools", true)
```

Com um _enter_ esse comando é executado no console. A partir daí aparece na tela principal um botão que habilita o import-map-overrides, permitindo que o desenvolvedor realize suas personalizações de componentes.

### Comandos úteis

Listar processos node e portas escutando na sua estação de trabalho

```
lsof -i -P -n | grep node | grep LISTEN
```
