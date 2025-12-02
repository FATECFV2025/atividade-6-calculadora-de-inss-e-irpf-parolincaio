[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/10VFIvOH)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=21916076&assignment_repo_type=AssignmentRepo)
# **Atividade 6 - Calculadora de INSS e IRPF **

## 📌 **Objetivo da Atividade**

Nesta atividade, você deverá implementar, em Java:

- Uma **Interface** que define o contrato de cálculo de tributos.  
- Uma **classe base (superclasse)** com atributos e comportamentos comuns.  
- **Múltiplas subclasses** especializadas que herdam da superclasse.  
- Uso de **polimorfismo**, manipulando objetos de diferentes subclasses através de uma referência do tipo da superclasse ou da interface.

O foco é aplicar **Interface, Herança e Polimorfismo** de maneira prática.

---

## 📐 **1. Interface de Cálculo de Tributos**

Crie uma interface, por exemplo `CalculadoraTributo`, contendo os métodos:

- `calcularINSS()`
- `calcularIRPF()`
- `calcularSalarioLiquido()`

Ela representa o contrato que todas as subclasses deverão seguir.

---

## 🧱 **2. Superclasse Genérica**

Crie uma classe base, por exemplo **`Contribuinte`** ou **`PessoaRenda`**, com os seguintes atributos:

- `nome` (String)  
- `cpf` (String)  
- `salarioBruto` (double)

E os seguintes comportamentos:

- `exibirResumo()` – exibe os dados do contribuinte e os valores dos descontos.  
- *Getters e Setters* conforme necessário.  

A superclasse deve **implementar a interface** de tributos.

---

## 🧬 **3. Subclasses Especializadas (Herança)**

Crie **pelo menos 3 subclasses**, herdando de `Contribuinte`:

- `FuncionarioCLT`  
- `Estagiario`  
- `PrestadorServico` (ou `PessoaJuridica`)  

Cada subclasse deve **sobrescrever os métodos**:

- `calcularINSS()`  
- `calcularIRPF()`  
- `calcularSalarioLiquido()`  

Cada uma usa **regras diferentes**, simulando formas distintas de tributação.

---

## 🔁 **4. Polimorfismo**

Crie uma classe principal, por exemplo:  
### **`AppFolhaPagamento`**

Essa classe deve:

1. **Solicitar ao usuário**, via teclado (Scanner):

   - Nome  
   - CPF  
   - Salário bruto  
   - Tipo do contribuinte  
     - `1` = Funcionário CLT  
     - `2` = Estagiário  
     - `3` = Prestador de Serviço (PJ)

2. **Instanciar dinamicamente** o objeto correto com base na opção escolhida.

3. **Armazenar o objeto em uma variável do tipo `Contribuinte` ou `CalculadoraTributo`**, demonstrando o uso de polimorfismo.

4. Chamar os métodos polimórficos:

   - `calcularINSS()`  
   - `calcularIRPF()`  
   - `calcularSalarioLiquido()`  
   - `exibirResumo()`  

O aluno deve **executar o programa várias vezes** com tipos diferentes, para observar o comportamento polimórfico real.

---

## 📥 **5. Entradas e Saídas**

### **Entrada**
Via Scanner ou valores fixos no código:

- Nome  
- CPF  
- Salário bruto  
- Tipo (CLT / Estagiário / PJ)

### **Saída (console)**

Para cada execução do programa:

- Nome  
- Tipo do contribuinte  
- Salário bruto  
- Valor do INSS  
- Valor do IRPF  
- Salário líquido  


## No Microsoft Teams  👥

- Não há necessidade fazer o upload do projeto 

## Regras 📄

- Utilize as boas práticas de programação que são sempre mencionadas em aula e nos materiais; 
- Observe sempre os modificadores de acesso em atributos e métodos;
- Observe os nomes de classes e atributos;
- Utilze comentários para elucidar o cenário elaborado;

## Feedback 📨
-  Sua atividade receberá uma pontuação de 0 a 10, que compõe a Nota da ATV2;
-  A nota será atribuída no Microsoft Teams
