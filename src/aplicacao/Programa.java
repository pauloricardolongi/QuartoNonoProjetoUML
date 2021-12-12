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
		
		System.out.print("Número do Quarto");
		int numero = sc.nextInt();
		System.out.print(" data do checkin (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print(" data do checkout(dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		//se a data posterior não é depois do checkin
		if(!checkout.after(checkin)) {
			System.out.println("Erro: Data da reserva é posterior a data do checkin ");
		}
		else {
			Reserva reserva = new Reserva(numero, checkin, checkout);
			System.out.println( reserva);
		}
		
		sc.close();

	}

}
