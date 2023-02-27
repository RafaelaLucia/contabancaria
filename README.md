# Conta Bancaria 🏦

Este projeto foi feito com base em uma conta bancária fictícia a fim de treinar conceitos básicos de Java e lógica de programação

#Tecnologias
 
 - ![image](https://img.shields.io/badge/-Java-orange)
 
# Visão Geral
 
O projeto simula um sistema de banco, possibilitando o usuário interagir com um menu com as seguintes opções: Criar Conta, Listar todas as Contas, Buscar Contas por Numero, Atualizar dados da Conta, Apagar Conta, Sacar, Depositar, Transferir valores entre contas e Sair.

# Construção

O Projeto é composto pelas seguintes Classes e Interfaces:

| Classe/Interface    | Descrição                                                    |
| ------------------- | ------------------------------------------------------------ |
| **Menu**            | Classe principal, que conterá o Método main, responsável por criar o Menu inicial da aplicação com todas as funcionalidades do sistema. |
| **Cores**           | Classe utilitária, que possui a função de aplicar cores ao Menu. |
| **Conta**           | Classe responsável por definir o Objeto Conta genérico.      |
| **ContaCorrente**   | Classe responsável por definir o Objeto Conta Corrente.      |
| **ContaPoupanca**   | Classe responsável por definir o Objeto Conta Poupanca.      |
| **ContaRepository** | Interface responsável por encapsular os Métodos que serão utilizados no Menu da aplicação |
| **ContaController** | Classe responsável por implementar a Interface ContaRepository. |


