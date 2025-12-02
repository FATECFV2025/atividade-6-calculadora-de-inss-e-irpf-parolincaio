import java.util.*;

interface CalculadoraTributo {
    double calcularINSS();
    double calcularIRPF();
    double calcularSalarioLiquido();
}

abstract class Contribuinte implements CalculadoraTributo {
    protected String nome;
    protected String cpf;
    protected double salarioBruto;

    public Contribuinte(String nome, String cpf, double salarioBruto) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBruto = salarioBruto;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public double getSalarioBruto() { return salarioBruto; }
    public void setSalarioBruto(double salarioBruto) { this.salarioBruto = salarioBruto; }

    public void exibirResumo() {
        System.out.println("---------- RESUMO ----------");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.printf(Locale.US,"Salário bruto: R$ %.2f%n", salarioBruto);
        System.out.printf(Locale.US,"INSS: R$ %.2f%n", calcularINSS());
        System.out.printf(Locale.US,"IRPF: R$ %.2f%n", calcularIRPF());
        System.out.printf(Locale.US,"Salário líquido: R$ %.2f%n", calcularSalarioLiquido());
        System.out.println("----------------------------");
    }

}

class FuncionarioCLT extends Contribuinte {
    public FuncionarioCLT(String nome, String cpf, double salarioBruto) {
        super(nome, cpf, salarioBruto);
    }

    @Override
    public double calcularINSS() {
        // Exemplo simples: 11% do bruto
        return salarioBruto * 0.11;
    }

    @Override
    public double calcularIRPF() {
        // Regra simplificada: calcula sobre salário após INSS
        double base = salarioBruto - calcularINSS();
        if (base <= 2500.0) {
            return 0.0;
        } else {
            // 15% sobre o que excede 2500
            return (base - 2500.0) * 0.15;
        }
    }

    @Override
    public double calcularSalarioLiquido() {
        return salarioBruto - calcularINSS() - calcularIRPF();
    }
}

class Estagiario extends Contribuinte {
    public Estagiario(String nome, String cpf, double salarioBruto) {
        super(nome, cpf, salarioBruto);
    }

    @Override
    public double calcularINSS() {
        // Simulação: estagiários isentos para a atividade
        return 0.0;
    }

    @Override
    public double calcularIRPF() {
        // Simulação: estagiários isentos
        return 0.0;
    }

    @Override
    public double calcularSalarioLiquido() {
        return salarioBruto; // sem descontos aqui
    }
}

class PrestadorServico extends Contribuinte {
    public PrestadorServico(String nome, String cpf, double salarioBruto) {
        super(nome, cpf, salarioBruto);
    }

    @Override
    public double calcularINSS() {
        // PJ - sem INSS sobre "salário" (simulação)
        return 0.0;
    }

    @Override
    public double calcularIRPF() {
        // Simulação: retenção simplificada de 5% do bruto
        return salarioBruto * 0.05;
    }

    @Override
    public double calcularSalarioLiquido() {
        return salarioBruto - calcularIRPF();
    }
}

public class AppFolhaPagamento {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // Para formatar ponto decimal como esperado
        Scanner sc = new Scanner(System.in);

        System.out.println("=== App Folha de Pagamento ===");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Salário bruto (ex: 2500.50): R$ ");
        double salarioBruto;
        try {
            salarioBruto = Double.parseDouble(sc.nextLine().replace(",", "."));
            if (salarioBruto < 0) {
                System.out.println("Salário não pode ser negativo. Encerrando.");
                sc.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para salário. Encerrando.");
            sc.close();
            return;
        }

        System.out.println("Tipo do contribuinte:");
        System.out.println("1 = Funcionário CLT");
        System.out.println("2 = Estagiário");
        System.out.println("3 = Prestador de Serviço (PJ)");
        System.out.print("Escolha (1/2/3): ");
        int tipo = 0;
        try {
            tipo = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Encerrando.");
            sc.close();
            return;
        }

        Contribuinte c; // referência do tipo da superclasse (polimorfismo)

        switch (tipo) {
            case 1:
                c = new FuncionarioCLT(nome, cpf, salarioBruto);
                System.out.println("Instanciado: Funcionário CLT");
                break;
            case 2:
                c = new Estagiario(nome, cpf, salarioBruto);
                System.out.println("Instanciado: Estagiário");
                break;
            case 3:
                c = new PrestadorServico(nome, cpf, salarioBruto);
                System.out.println("Instanciado: Prestador de Serviço (PJ)");
                break;
            default:
                System.out.println("Opção inválida. Encerrando.");
                sc.close();
                return;
        }

        c.exibirResumo();

        System.out.printf("Detalhe: INSS=R$ %.2f, IRPF=R$ %.2f%n",
                c.calcularINSS(), c.calcularIRPF());

        sc.close();
    }
}
