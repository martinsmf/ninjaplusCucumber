Feature: Login
  Para que eu possa gerenciar os filmes do catálogo
  Sendo um usuário previamente cadastrado
  Posso acessar o sistema com o meu email e senha

  Scenario: Acesso
    When eu faco login com "matheus@qaplus.com" e "pwd123"
    Then devo ver "Matheus" na área logada


  Scenario Outline: Login sem sucesso
    When  eu faco login com <email> e <pass>
    Then devo ver a mensagem de alerta <text>

    Examples:
      | email                | pass       | text                           |
      | "matheus@qaplus.com" | "abc12357" | "Usuário e/ou senha inválidos" |
      | "404@gmail.com"      | "abc123"   | "Usuário e/ou senha inválidos" |
      | ""                   | "abc123"   | "Opps. Cadê o email?"          |
      | "matheus@qaplus.com" | ""         | "Opps. Cadê a senha?"          |
