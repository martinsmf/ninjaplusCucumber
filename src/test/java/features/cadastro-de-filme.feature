Feature: Cadastro de filme
  Para que eu possa disponiblizar novos titulos no catálogo
  Sendo um gestor de catálogo
  Posso cadastrar um novo filme

  Background: Login
    * Login com "matheus@qaplus.com" e "pwd123"

  Scenario Outline: Novo Filme
  O gestor do catálogo cadastr um novo filme atraves do formulário
  e um novo filme é incerido a lista

    Given que <codigo> é um novo filme
    When eu faço o cadastro desse filme
    Then devo ver o novo filme <codigo> na lista

    Examples:
      | codigo     |
      | "ultimato" |
      | "spider"   |
      | "jumanji2" |

  Scenario Outline: Campos obrigátorios
  O gestor de catálogo tenta cadastrar um novo filme, mas esquece
  de preencher um dos campos obrigátorios, e em seguida o sistema
  exibe uma notificação para o usuário

    Given que <codigo> é um novo filme
    When eu faço o cadastro desse filme
    Then devo ver a notificação <text>

    Examples:
      | codigo      | text                                        |
      | "no_title"  | "Oops - Faltou o titulo do filme :/"        |
      | "no_status" | "Oops - O status deve ser informado!"       |
      | "no_year"   | "Oops - Faltou o ano de lançamento também!" |
