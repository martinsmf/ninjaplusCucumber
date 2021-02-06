Feature: Busca
  Como usuário e gerenciador do catálogo de filmes
  Desejo realizar a buscas de filmes
  Que estão cadastrados no catálogo

  Background: Login
    * Login com "matheus@qaplus.com" e "pwd123"

  Scenario: Buscar um filme
    When faço a busca do filme "Coringa"
    Then  devo ver apenas o filme "Coringa" na lista
