package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario,numeroDestino;
		String titular;
		float saldo,limite,valor;
		
		System.out.println("\n Criar Contas \n ");
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123,1,"Lorena Orsi",1000f,100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 125,2,"Giovanna Tezoni",8000f,15f);
		contas.cadastrar(cc2);
		contas.listarTodas();
		
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
			
			try {
				opcao = leia.nextInt();		
			}catch(InputMismatchException e) {
				System.out.println("\n Digite valores inteiros!");
				leia.nextLine();
			    opcao=0;	
			}
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\n Banco do Brazil zil zil - O seu futuro começa aqui!");
				leia.close();
				System.exit(0);
			}
			
			
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar conta \n\n");
				
				System.out.println("Olá, Digite o Número da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o Tipo da Conta: \n Digite 1 para Conta Corrente \n Digite 2 para Conta Poupança");
					tipo = leia.nextInt();
				}while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o Saldo da Conta (Em Reais): ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (Em Reais): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular,saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversário da Conta: ");
					aniversario = leia.nextInt();
				    contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia, tipo, titular, saldo, aniversario));	
				  	}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				if (contas.buscarNaCollection(numero) != null) {
					
					System.out.println("Digite o número da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					System.out.println("Digite o Saldo da Conta (Em Reais): ");
					saldo = leia.nextFloat();
					tipo = contas.retornaTipo(numero);
					
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (Em Reais): ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular,saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o Dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero,agencia,tipo,titular,saldo,aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválida!");
					}
					}
				}else {
					System.out.println("\n Conta não foi encontrada...");
				}
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				
				System.out.println("Por favor, Digite o número da conta: ");
				numero = leia.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				do {
					System.out.println("Digite o Valor do Saque(R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				contas.sacar(numero,valor);	
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = leia.nextFloat();
				}while(valor <= 0);
				contas.depositar(numero,valor);
			
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
				
				System.out.println("Digite o Número da Conta de Origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o Número da Conta de Destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = leia.nextFloat();
				}while(valor <=0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida\n\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
		
	}

	public static void keyPress() {
		
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione ENTER para Continuar...");
			System.in.read();
		}catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de ENTER!");
		}
	}
}
