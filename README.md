<h1 align="center">Desafio Elo-7 </h1>

<h1 align="center">
    Sondas Espaciais
</h1>
<p align="center">🚀 API desenvolvida para possibilitar o movimento de sondas em estações espaciais</p>

<p align="center">
 <h1> Objetivo • </h1>

 O Objetivo desse projeto é possibilitar o movimento de sondas em estações espaciais, com uma disponibilidade de área de pouso no Planalto delimitada, onde as sondas podem pousar e se movimentar para frente, para o lado esquerdo ou lado direito, através de comandos. 
 É possível que uma ou várias sondas pousem ao mesmo tempo, em um ou vários planetas, e é necessário que essa movimentação seja coordenada por comandos e funcione de forma adequada.

<p align="center">
 <h1> 🛠 Tecnologias •</h1>

As seguintes ferramentas foram usadas na construção do projeto:
- Linguagem: Java versão 11
- Gerenciamento de dependências/ build: Maven 
- Testes: JUnit versão 4.13
- Framework: Spring Boot
- Conteinerização: Docker

<p align="center">
<h1> Documentação • </h1>

## SwaggerUI link

Documentação gerada no SwaggerUI 
```
  http://localhost:8080/swagger-ui/index.html#/
```


## Implantar Sondas

Enviar uma sonda para o planeta, informando em que localização a mesma será implantanda.
```
POST /estacao-espacial/sondas
```
## Exemplo 

```
curl -X 'POST' \
  'http://localhost:8080/estacao-espacial/sondas' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "x": 1,
  "y": 2,
  "movimentos": "N"
}'
```

## Lista de sondas implantadas
Listar todas as sondas já implantadas.
```
GET /estacao-espacial/sondas
```
## Exemplo 

```
curl -X 'GET' \
  'http://localhost:8080/estacao-espacial/sondas' \
  -H 'accept: application/json'
```

## Controlar sonda
Enviar comandos para que a sonda se movimente.
```
PUT /estacao-espacial/sondas//{x}/{y}/explorar-planeta-pela-posicao
```
## Exemplo
```
curl -X 'PUT' \
  'http://localhost:8080/estacao-espacial/sondas/1/2/explorar-planeta-pela-posicao' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '[
  "M"
]'
```

## Jornada
Implantar uma nova sonda com comandos para que ela faça uma jornada pelo planeta.
```
POST /estacao-espacial/sondas//explorar-planeta-pela-jornada
```


<p align="center">
 <h1> Autora • </h1>
</p>

## Anna Waleska de Freitas Salles