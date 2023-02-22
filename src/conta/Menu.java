package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		
		//teste da classe conta
		Conta c1 = new Conta(1, 123, 1, "Adriana", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		//Teste da classe corrente
		ContaCorrente cc1 = new ContaCorrente(2,123,1,"Mariana",15000.0f,1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		//Teste da classe poupanca
		ContaPoupanca cp1 = new ContaPoupanca(3,123,2,"Vitor",100000.0f,15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
        cp1.depositar(5000.0f);
        cp1.visualizar();
		
	
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		while(true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + ""+
		"________________________________________________\n"+
		"|                                              |\n"+
	    "|           BANCO DO BRAZIL ZIL ZIL            |\n"+
		"|______________________________________________|\n"+
		"|                                              |\n"+
		"|      1 - Criar Conta                         |\n"+
		"|      2 - Listar todas as Contas              |\n"+
		"|      3 - Buscar Conta por Numero             |\n"+
		"|      4 - Atualizar Dados da Conta            |\n"+
		"|      5 - Apagar Conta                        |\n"+
		"|      6 - Sacar                               |\n"+
		"|      7 - Depositar                           |\n"+
		"|      8 - Transferir valores entre Contas     |\n"+                     
	    "|      9 - Sair                                |\n"+
		"|                                              |\n"+
		"|______________________________________________|\n"+
		"\n"+
		"Entre com a opção desejada:\n" + Cores.TEXT_RESET);
			opcao = leia.nextInt();
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\n Banco do Brazil zil zil - O seu futuro começa aqui!");
				leia.close();
				System.exit(0);
			}
			
			
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar conta \n\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida\n\n" + Cores.TEXT_RESET);
				break;
			}
			
		}
		
	}

}
