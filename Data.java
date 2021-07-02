import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;

public class Data {
  private int dia;
  private int mes;
  private int ano;

  public Data() {
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

        if (bissexto(a))
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
    dia = d;
    mes = m;
    ano = a;
  }

  public Data(int d, int m, int a) {
    dia = d;
    mes = m;
    ano = a;
  }

  public void entraDia(int d) {
    dia = d;
  }

  public void entraMes(int m) {
    mes = m;
  }

  public void entraAno(int a) {
    ano = a;
  }

  public void entraDia() {
    Scanner scan = new Scanner(System.in);
    String gotD;
    boolean dValido = false;
    int d;
    int[] maxDias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    /* ------------------------- pegando o valor do dia ------------------------- */
    do {
      System.out.println("Por favor digite um número inteiro para que este seja o dia");
      gotD = scan.nextLine();
      try {
        d = Integer.parseInt(gotD);

        if (bissexto())
          maxDias[1] = 29;

        if (d > 0 && d <= maxDias[mes - 1])
          dValido = true;
        else
          System.out.println("O dia digitado é inválido para esta combinação de mês e ano, tente novamente");
      } catch (NumberFormatException ex) {
        System.out.println("O valor digitado é inválido, por favor tente novamente");
      }
    } while (!dValido);
    scan.close();
  }

  public void entraMes() {
    Scanner scan = new Scanner(System.in);
    String gotM;
    int m;
    boolean mValido = false;
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
    scan.close();
  }

  // TODO colocar verificação se um ano bissexto mudou para um não bissexto
  public void entraAno() {
    Scanner scan = new Scanner(System.in);
    String gotA;
    int a;
    boolean aValido = false;

    int[] maxDias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    do {
      System.out.println("Por favor digite ua número inteiro para que este seja o ano");
      gotA = scan.nextLine();
      try {
        a = Integer.parseInt(gotA);

        if (bissexto(a))
          maxDias[1] = 29;
        if (dia <= maxDias[mes - 1])
          aValido = true;
        else {
          System.out.println("O valor digitado é inválido, por favor tente novamente");
        }
      } catch (NumberFormatException ex) {
        System.out.println("O valor digitado é inválido, por favor tente novamente");
      }
    } while (!aValido);
    scan.close();
  }

  public int retDia() {
    return dia;
  }

  public int retMes() {
    return mes;
  }

  public int retAno() {
    return ano;
  }

  public String mostra1() {
    return dia + "/" + mes + "/" + ano;
  }

  public String mostra2() {
    String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
        "Outubro", "Novembro", "Dezembro" };

    return dia + "/" + meses[mes - 1] + "/" + ano;
  }

  public boolean bissexto(int a) {
    if (a % 400 == 0 || (a % 100 != 0 && a % 4 == 0))
      return true;
    return false;
  }

  public boolean bissexto() {
    if (ano % 400 == 0 || (ano % 100 != 0 && ano % 4 == 0))
      return true;
    return false;
  }

  public int diasTranscorridos() {
    int[] maxDias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int diasTranscorridos = 0;
    if (bissexto())
      maxDias[1] = 29;

    for (int i = 0; i < (mes - 1); i++) {
      diasTranscorridos += maxDias[i];
    }

    diasTranscorridos += dia;

    return diasTranscorridos;
  }

  public void apresentaDataAtual() {
    Date data = new Date();
    String dataApresentavel = DateFormat.getDateInstance(DateFormat.FULL).format(data);

    System.out.println(dataApresentavel);
  }
}
