import java.util.Scanner;
import java.lang.String;

public class Lychrel {

	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args){

		lector = new Scanner(System.in);
		int numCasos = Integer.parseInt(lector.nextLine());

		for (int i = 1; i <= numCasos; i++){
			casDeProva();
		}

	}

	static void casDeProva(){

		String entrada = lector.nextLine();
		int n = Integer.parseInt(entrada);
		int resultat = 0;


		if ( n < 1 || n > 100000){ //Limit de combres
			System.out.println("ERROR");
		}else{
			//Aki fem els calculs:
			//1) Sumem nombres girats OK
			//2) Agafem resultat i repetim fins a 1.000.000 com a nombre, LONG?
			resultat = suma(entrada,(invertir(entrada)));
			boolean lychrel = false;
			int iteracions = 1;

			while (resultat < 1000000000 && !lychrel){

				if( esCapiCua(passaaString(resultat))){
					System.out.println(iteracions+" "+resultat);
					lychrel = true;
				}else lychrel = false;
				
				resultat = suma(passaaString(resultat),invertir(passaaString(resultat)));
				iteracions++;
		
			}
			if(!lychrel) System.out.println("Lychrel?");

		}
	}

	static String invertir(String nombre)
	{
		String inv = "";

		for(char c : nombre.toCharArray())
		{
			inv = c + inv;	
		}
		return inv;
	}
	
	static int suma(String a, String b){
		return Integer.parseInt(a)+Integer.parseInt(b);
	}

	static String passaaString(int numeroaConvertir){
		return Integer.toString(numeroaConvertir);
	}

	static boolean esCapiCua(String numero){

		if (numero.compareTo(invertir(numero)) == 0) return true;
		else return false;
	}
}
