
public class chimie {
    
    public static Double incertitude(String tip) {
        int a = 100;
        Double b = 0.0;
        System.out.println("\nChoisissez une incertitude pour " + tip + ".");
        System.out.println("0 - 0.03 ml");
        System.out.println("1 - 0.02 ml");
        while ((a > 2)||(a < 0)) {
            a = Lire.i();
            if ((a > 2)||(a < 0)) {
                System.out.println("\nVeuillez entrer une option disponible.");
            }
        }
        switch (a) {
            case 0:
                b = 0.03;
                break;
            case 1:
                b= 0.02;
                break;
            default:
                break;
        }
        return(b);
    }
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("INCERTITUDE RELATIVE");
        System.out.println("===============================================================");
        System.out.println("\nChoisissez un volume pour l'espèce dont la concentration est connue.");
        Double vcconnue = Lire.d();
        Double a = (incertitude("le volume de l'espèce dont la concentration est connue")/Math.sqrt(3))/vcconnue;
        System.out.println("\nChoisissez un volume pour l'espèce dont la concentration est inconnue.");
        Double vccherche = Lire.d();
        Double b = (incertitude("le volume de l'espèce dont la concentration est inconnue")/Math.sqrt(3))/vccherche;
        Double incertituder = Math.sqrt(a*a + b*b + 0.0020*0.0020);
        System.out.println("\nL'incertitude relative est : " + incertituder);
        int CS = 0;
        if (incertituder <= 0.005) {
            CS = 4;
        }
        if ((incertituder > 0.005)&&(incertituder <= 0.05)) {
            CS = 3;
        }
        if ((incertituder > 0.05)&&(incertituder <= 0.1)) {
            CS = 4;
        }
        if (incertituder > 0.1) {
            CS = 5;
        }
        System.out.println("Le résultat final aura donc " + CS + " chiffres significatifs");

        System.out.println("\n\n===============================================================");
        System.out.println("CONCENTRATION INCONNUE");
        System.out.println("===============================================================");
        System.out.println("\nChoisissez une concentration pour l'espèce connue.");
        Double cconnue = Lire.d();
        Double ccherche = (cconnue*vcconnue)/vccherche;
        System.out.println("\nLa concentration inconnue est :" + ccherche);

        System.out.println("\n\n===============================================================");
        System.out.println("INCERTITUDE ABSOLUE");
        System.out.println("===============================================================");
        Double incertitudea = incertituder*ccherche;
        System.out.println("\nL'incertitude absolue est :" + incertitudea);

        System.out.println("\n\n===============================================================");
        System.out.println("COMPTE RENDU");
        System.out.println("===============================================================");

        System.out.println("\nLes résultats sont les suivants:");
        System.out.println("    - l'incertitude relative (2CS) est : " + incertituder);
        System.out.println("    - la concentration est : " + ccherche);
        System.out.println("    - l'incertitude absolue est : " + incertitudea);
        System.out.println("    - la concentration et l'incertitude absolue auront " + CS + " chiffres significatifs.");

    }
}
