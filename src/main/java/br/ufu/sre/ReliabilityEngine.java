package br.ufu.sre;

import java.util.Scanner;

import br.ufu.sre.loader.Menu;

public class ReliabilityEngine {

	public static void main( String[] args ) {
		
		Menu menu = new Menu();
		Scanner scanner = new Scanner( System.in );
		//R(t), U(t), MTTF, h(t), H(t)	
		Integer option = 0;
		do {
			System.out.println( "" );
			System.out.println( "**************************************" );
			System.out.println( "Escolha a métrica de confiabilidade: " );
			System.out.println( "1 - R(t) " );
			System.out.println( "2 - U(t) " );
			System.out.println( "3 - MTTF " );
			System.out.println( "4 - h(t) " );
			System.out.println( "5 - H(t) " );
			System.out.println( "6 - Sair" );
			System.out.println( "Opção: " );
			
			try {
				option = scanner.nextInt();
			} catch( Exception ex ) {
				System.out.println( "Opção inválida" );
				scanner.next();
				continue;
			}
			
			if( menu.getOptions().get( option ) != null ) {
				menu.getOptions().get( option ).requestInfo( scanner );
			} else {
				System.out.println( "Opção inválida" );
			}
			
		} while( 6 != option );
		
	}

}
