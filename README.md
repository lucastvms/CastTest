# desafio-banco
Esse projeto consiste em um conjunto de features para serem implementadas por candidatos interessados em participar do processo de seleção da empresa.

### O desafio
O desafio consiste em implementar *em até 5 dias*, os requisitos funcionais ou features de um banco digital fictício que contemple as operações de criação de novas contas, depósitos, saques e transferências entre contas.

Será exigido do candidato: 
- **Implementar uma API Rest baseada em Spring Boot** utilizando Java 8 ou superior seguindo as melhores práticas de qualidade de código. 
- Implementar (no mínimo uma das duas abaixo): 
    - Um **conjunto de testes automáticos, que interaja com a API** criada no item 1, **utilizando o framework Cucumber** e as metodologias de desenvolvimento guiado por teste **TDD e BDD**. 
    - **Um gateway, que interaja com a API** criada no item 1, **utilizando Angular**.

---

Seguem os requisitos funcionais ou features:

* [Criar Conta](criar_conta.feature) - Feature de criação de uma nova conta no banco
* [Depósito](deposito.feature) - Feature de realização da operação de depósito em conta.
* [Saque](saque.feature) - Feature de realização da operação de saque em conta.
* [Transferência](transferencia.feature) - Feature de realização da operação transferência de valores entre contas.
