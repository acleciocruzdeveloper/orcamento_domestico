# Domestic Budget | Orçamento Doméstico

O que é necessário para exetuar este projeto 

- Docker

Dentro da estrutura do projeto contem um arquivo chamado: `docker-compose.yml`

através do terminal `Git Bash | Zsh | Cmd` execute o comando abaixo com a engine do docker em execução: 

``
    docker compose up -d 
``

Este comando inicializa o banco de dados `Postgres` dentro de um container

O projeto utiliza FlyWay para controle de alterações nas tabelas do banco de dados
logo caso altere alguma informação schema, lembre-se sempre de para "Stop" na aplicação
antes de criar uma nova versão de migrations seguindo o padrão 
`V*__definicao_da_migration.sql` 
- onde o asterisco indica o número da versão que está sendo criada

Uma vez inicializado o container com o banco de dados pode ser realizado o start da aplicação executando
o comando `mvn spring-boot:run` através do terminal

