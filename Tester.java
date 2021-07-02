import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Data data = new Data();

		System.out.println(data.mostra1());
		System.out.println(data.mostra2());

		// Pegando os valores antes de criar a classe para usar a sobrecarga com
		// atributos
		System.out.println("utilizando o constructor com atributos dessa vez");

		Scanner scan = new Scanner(System.in);
		boolean dValido = false, mValido = false, aValido = false;
		String gotD, gotM, gotA;
		int d = 0, m = 0, a = 0;

		int[] maxDias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// Eu decidi pegar o ano e o mês antes do dia, pra fazer checagem dias válidos e
		// ano bissexto

		/* ------------------------- pegando o valor do ano ------------------------- */
		do {
			System.out.println("Por favor digite ua número inteiro para que este seja o ano");
			gotA = scan.nextLine();
			try {
				a = Integer.parseInt(gotA);

				if (data.bissexto(a))
					maxDias[1] = 29;
				aValido = true;
			} catch (NumberFormatException ex) {
				System.out.println("O valor digitado é inválido, por favor tente novamente");
			}
		} while (!aValido);

		/* ------------------------- pegando o valor do mes ------------------------- */
		do {
			System.out.println("Por favor digite um número inteiro para que este seja o mes");
			gotM = scan.nextLine();
			try {
				m = Integer.parseInt(gotM);

				if (m >= 1 && m <= 12)
					mValido = true;
				else
					System.out.println("O valor digitado é inválido, por favor tente novamente");
			} catch (NumberFormatException ex) {
				System.out.println("O valor digitado é inválido, por favor tente novamente");
			}
		} while (!mValido);

		/* ------------------------- pegando o valor do dia ------------------------- */
		do {
			System.out.println("Por favor digite um número inteiro para que este seja o dia");
			gotD = scan.nextLine();
			try {
				d = Integer.parseInt(gotD);

				if (d > 0 && d <= maxDias[m - 1])
					dValido = true;
				else
					System.out.println("O dia digitado é inválido para esta combinação de mês e ano, tente novamente");
			} catch (NumberFormatException ex) {
				System.out.println("O valor digitado é inválido, por favor tente novamente");
			}
		} while (!dValido);

		scan.close();

		// atribuindo os valores recebidos às propriedades da classe
		Data data2 = new Data(d, m, a);

		System.out.println(data2.mostra1());
		System.out.println(data2.mostra2());

		// montando uma string de data com os valores retornados dos objetos;
		System.out.println("usando as funções ret");
		int dia, mes, ano;

		dia = data2.retDia();
		mes = data2.retMes();
		ano = data2.retAno();

		String dataApresentavel = dia + "/" + mes + "" + ano;

		System.out.println(dataApresentavel);

		int diasTranscorridos = data2.diasTranscorridos();

		System.out.println("dias trasncorridos:");
		System.out.println(diasTranscorridos);

		data.apresentaDataAtual();
	}
}
