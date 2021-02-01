Feature: Cadastro de filme
  Para que eu possa disponiblizar novos titulos no catálogo
  Sendo um gestor de catálogo
  Posso cadastrar um novo filme

  Background: Login
    * Login com "matheus@qaplus.com" e "pwd123"

  Scenario Outline: Novo Filme
    Given que <codigo> é um novo filme
    When eu faço o cadastro desse filme
    Then devo ver o novo filme na lista

    Examples:
      | codigo     |
      | "ultimato" |
#      | "spider"   |
#      | "jocker"   |