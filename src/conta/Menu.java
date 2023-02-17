package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
	
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		while(true) {
			
			System.out.println(""+
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
		"Entre com a opção desejada:\n");
			opcao = leia.nextInt();
			
			if(opcao == 9) {
				System.out.println("\n Banco do Brazil zil zil - O seu futuro começa aqui!");
				leia.close();
				System.exit(0);
			}
			
			
			switch(opcao) {
			case 1:
				System.out.println("Criar conta \n\n");
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");
				break;
			case 6:
				System.out.println("Saque\n\n");
				break;
			case 7:
				System.out.println("Depósito\n\n");
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");
				break;
			default:
				System.out.println("\nOpção Inválida\n\n");
				break;
			}
			
		}
		
	}

}
