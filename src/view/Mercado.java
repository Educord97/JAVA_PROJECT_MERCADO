package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import helper.Utils;
import model.Produto;

public class Mercado {
	
	private static Scanner teclado = new Scanner(System.in);
	private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;
		
	
	public static void main(String[] args) {
		//PROGRAMA PRINCIPAL
		
		produtos = new ArrayList<Produto>();
		carrinho = new HashMap<Produto, Integer>();
		Mercado.menu();

	}
	
	private static void menu() {
		System.out.println("=============================================");
		System.out.println("================== Bem-Vindo(a) ==============");
		System.out.println("================== Nosso Mercado =============");
		System.out.println("==============================================");
		
		System.out.println("Selecione uma op��o abaixo: ");
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Listar produtos");
		System.out.println("3 - Listar produtos");
		System.out.println("4 - Visualizar carrinho");
		System.out.println("5 - Sair do sistema");
		
		int opcao = 0;
		
		try {
			opcao = Integer.parseInt(Mercado.teclado.nextLine());
		}catch(InputMismatchException e) {
			Mercado.menu();
		}catch(NumberFormatException f) {
			Mercado.menu();
		}
		
		
		switch(opcao) {
		case 1:
			Mercado.cadastrarProduto();
			break;
		case 2:
			Mercado.listarProdutos();
			break;
		case 3:
			Mercado.comprarProduto();
			break;
		case 4:
			Mercado.visualizarCarrinho();
			break;
		case 5:
			System.out.println("Volte sempre!");
			Utils.pausar(2);
			System.exit(0);
		default:
			System.out.println("Op��o inv�lida.");
			Utils.pausar(2);
			Mercado.menu();
			break;
		}
	}
	
	
	private static void cadastrarProduto() {
		System.out.println("Cadastro de Produto...");
		System.out.println("======================");
		
		System.out.println("Informe o nome do produto: ");
		String nome = Mercado.teclado.nextLine();
		
		System.out.println("Informe o pre�o do produto: ");
		Double preco = Mercado.teclado.nextDouble();
		
		Produto produto = new Produto(nome, preco);
		
		Mercado.produtos.add(produto);
		
		System.out.println("O produto " + produto.getNome() + " foi cadastrado com sucesso!!!");
		Utils.pausar(2);
		Mercado.menu();
	}
	
	private static void listarProdutos() {
		if(Mercado.produtos.size() > 0) {
			System.out.println("Listagem de produtos: ");
			System.out.println();
			
			for(Produto p : Mercado.produtos) {
				System.out.println(p);
				System.out.println();
			}
		}else {
			System.out.println("Ainda n�o existem produtos cadastrados.");
		}
		
		Utils.pausar(2);
		Mercado.menu();
	}
	
	
	private static void comprarProduto() {
		System.out.println("Comprando produto...");
	}
	
	
	private static void visualizarCarrinho() {
		if(Mercado.carrinho.size() > 0) {
			System.out.println("Produtos no carrinho: ");
			
			for(Produto p : Mercado.carrinho.keySet()) {
				System.out.println("Produto: " + p + "\nQuandidade: " + Mercado.carrinho.get(p));
			}
		}else {
			System.out.println("Ainda n�o existem produtos no carrinho.");
		}
		
		Utils.pausar(2);
		Mercado.menu();
	}

}


















