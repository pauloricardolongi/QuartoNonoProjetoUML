package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {		
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print(" Número do Quarto");
		int numero = sc.nextInt();
		System.out.print(" data do checkin (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print(" data do checkout(dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		
		if (!checkout.after(checkin)) {
			System.out.println("Erro de reserva: data de saída tem que ser depois da data de entrada!");
		}		
		
		else {
			Reserva reserva = new Reserva(numero, checkin, checkout);
			System.out.println( reserva);
			
			System.out.println();
			System.out.println(" Entre com os dados para atualizar a reserva: ");
			System.out.print(" data do checkin (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print(" data do checkout(dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (checkin.before(agora) || checkout.before(agora)) {
				System.out.println(" Erro de reserva: As datas de atualizações para reserva devem ser datas futuras");
				
			}
			else if(!checkout.after(checkin)) {
					System.out.println(" Erro de reserva: A data de checkout deverá ser posterior a data de checkin!");
				}	
			else {

				reserva.updateDate(checkin, checkout);
				System.out.println( reserva);					
			}
			
		}
		
		sc.close();

	}

}
