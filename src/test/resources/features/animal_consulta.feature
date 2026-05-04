# language: pt
Funcionalidade: Consulta de Animais e Conformidade ESG
  Como auditor ambiental
  Quero consultar os animais cadastrados
  Para garantir rastreabilidade e conformidade regulatória

  Cenário: Listar todos os animais e verificar integridade dos dados
    Dado que existem animais cadastrados no sistema
    Quando eu envio uma requisição GET para "/animais"
    Então o status da resposta deve ser 200
    E a resposta deve ser uma lista
    E cada animal da lista deve conter os campos obrigatórios "id", "nome" e "especie"
    E o contrato da resposta deve estar em conformidade com o JSON Schema