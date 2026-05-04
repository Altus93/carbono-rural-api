# language: pt
Funcionalidade: Gerenciamento de Animais
  Como usuário do sistema Carbono Rural
  Quero cadastrar e gerenciar animais
  Para calcular a emissão de carbono da fazenda

  Cenário: Cadastrar um novo animal com dados válidos
    Dado que eu tenho os dados de um animal
      | nome   | especie |
      | Nelore | Bovino  |
    Quando eu envio uma requisição POST para "/animais"
    Então o status da resposta deve ser 200
    E o corpo da resposta deve conter os dados do animal cadastrado
    E o campo "id" não deve ser nulo