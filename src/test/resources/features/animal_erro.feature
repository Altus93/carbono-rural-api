# language: pt
Funcionalidade: Tratamento de Erros da API
  Como desenvolvedor
  Quero garantir que a API responde adequadamente a requisições inválidas
  Para manter a robustez do sistema

  Cenário: Buscar animal com ID inexistente
    Dado que não existe animal com ID 9999
    Quando eu envio uma requisição GET para "/animais/9999"
    Então o status da resposta deve ser 404