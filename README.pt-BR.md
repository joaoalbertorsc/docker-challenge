# BoxOffice: Catalog Service

Uma API REST simples com Spring Boot, empacotada como imagem Docker e executada em um container com a porta mapeada.

Ela é a primeira peça do **BoxOffice**, uma futura plataforma de venda de ingressos para shows ao vivo. Os próximos
passos estão planejados em [FUTURE_FEATURES.md](FUTURE_FEATURES.md) (em inglês).

> English version: [README.md](README.md)

## Checklist do desafio

| Requisito | Onde encontrar |
|---|---|
| API REST com Spring Boot e um endpoint GET que retorna dado estático | [`ShowController`](src/main/java/com/boxoffice/catalog/controller/ShowController.java): `GET /api/v1/shows` |
| Dockerfile válido na raiz do projeto | [`Dockerfile`](Dockerfile) |
| Imagem gerada e container executando com a porta mapeada | [Passo a passo](#passo-a-passo), passos 1 a 3 |
| Teste da API pelo Postman | Coleção em [`postman/`](postman), [passo 4](#passo-a-passo) |

## Tecnologias

Java 21 · Spring Boot 4.1 · Spring Data JPA · H2 (em memória) · Maven · Docker · Postman

## A API

`GET /api/v1/shows` retorna todos os shows do banco (título, artista, local, cidade, data e preço inicial), do mais
próximo ao mais distante.

Os dados vêm do [`data.sql`](src/main/resources/data.sql). O Spring Boot carrega esse arquivo em um banco H2 em memória
toda vez que a aplicação inicia, então não há banco para instalar. Para mudar o que a API retorna, edite esse arquivo.

## Passo a passo

Você só precisa do Docker. O Java e o Maven rodam dentro do build da imagem.

**1. Gerar a imagem** a partir do `Dockerfile` da raiz:

```bash
docker build -t boxoffice/catalog-service .
```

O Dockerfile tem dois estágios. O primeiro compila o jar com Maven e JDK. O segundo copia só esse jar para uma imagem
menor, que tem apenas o Java para executar.

**2. Executar o container** mapeando a porta da aplicação:

```bash
docker run -d --name catalog-service -p 8080:8080 boxoffice/catalog-service
```

O formato é `-p <porta-da-sua-máquina>:<porta-do-container>`. A aplicação escuta na porta `8080` dentro do container.
Com `-p 9090:8080`, a mesma API responderia em `http://localhost:9090`.

**3. Conferir se está rodando:**

```bash
docker ps
```

**4. Testar** no Postman (ou no navegador) com `GET http://localhost:8080/api/v1/shows`. Você também pode importar
[`postman/boxoffice.postman_collection.json`](postman/boxoffice.postman_collection.json), que já tem a requisição e
confere se a resposta é `200 OK` com uma lista de shows.

**5. Parar e remover o container:**

```bash
docker rm -f catalog-service
```

Para rodar sem Docker: `./mvnw spring-boot:run`.

## Próximos passos

Testes, novos endpoints, novos serviços, mensageria com Kafka e RabbitMQ, observabilidade e CI/CD estão planejados em
[FUTURE_FEATURES.md](FUTURE_FEATURES.md).
