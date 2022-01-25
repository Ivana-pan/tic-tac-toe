import java.util.Scanner;

public class D_6_Ivana_Zinajic_NS129QA4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Izaberite simbol X ili O: ");
        String mojKarakter = input.next();
        String kompKarakter;
        String[] tabela = new String[9];

        //Validnost i izbor karaktera
        if (mojKarakter.equals("X")) {
            kompKarakter = "O";
        } else if (mojKarakter.equals("O")) {
            kompKarakter = "X";
        } else {
            System.out.println("Izabrani karakter nije validan.");
            return;
        }

        //Gameplay:
        ispisivanjeTabele(tabela);
        mojPotez(mojKarakter, tabela);
        while (!IsGameOver(tabela)) {
            kompovPotez(kompKarakter, tabela);
            ispisivanjeTabele(tabela);
            mojPotez(mojKarakter, tabela);
        }
        ispisivanjeTabele(tabela);


    }

    // ispisivanje tabele
    public static void ispisivanjeTabele(String[] tabela) {
        for (int i = 0; i < tabela.length; i++) {
            System.out.print(tabela[i]);
            System.out.print(" ");
            if (i == 2 || i == 5 || i == 8) {
                System.out.println();
            }
        }
    }

    // kompov potez
    public static void kompovPotez(String karakter, String[] tabela) {
        int pozicijaKompa = (int) (Math.random() * (9) + 0);
        //System.out.println(pozicijaKompa);
        while (tabela[pozicijaKompa] != null) {
            pozicijaKompa = (int) (Math.random() * (9) + 0);
        }
        tabela[pozicijaKompa] = karakter;
    }

    //moj potez
    public static void mojPotez(String karakter, String[] tabela) {
        Scanner input = new Scanner(System.in);
        System.out.print("Unesite poziciju: ");
        int pozicija = input.nextInt();
        tabela[pozicija] = karakter;
    }

    //da li su sva polja popunjena
    public static boolean IsGameOver(String[] tabela) {

        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] == null) {
                return false;
            }
        }
        return true;
    }

}