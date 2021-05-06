package mc322.lab04;

public class AppRestaUm
{
    public static String[] executaJogo(String caminhoCSV)
    {
        String comandos[];
        String resultado [];
        Tabuleiro tab = new Tabuleiro();
        CSVReader csv = new CSVReader();
        int iInicio, jInicio, iFim, jFim;

        // lê os comandos
        csv.setDataSource(caminhoCSV);
        comandos = csv.requestCommands();
        // inicia o vetor resultado:
        resultado = new String[comandos.length];
        // apresenta o tabuleiro:
        System.out.println("Tabuleiro inicial:");
        tab.apresenta();
        // executa os comandos da forma a9:a9
        for (int i = 0; i < comandos.length; i++)
        {
            // converte o comando em string em seus valores inteiros:
            System.out.printf("Source: %s\n", comandos[i].substring(0,2));
            jInicio = Character.getNumericValue(comandos[i].charAt(0)) - Character.getNumericValue('a');
            iInicio = Character.getNumericValue(comandos[i].charAt(1)) - Character.getNumericValue('1');
            System.out.printf("Target: %s\n", comandos[i].substring(3,5));
            jFim = Character.getNumericValue(comandos[i].charAt(3)) - Character.getNumericValue('a');
            iFim = Character.getNumericValue(comandos[i].charAt(4)) - Character.getNumericValue('1');
            // Realiza o movimento;
            tab.mover(iInicio, jInicio, iFim, jFim);
            tab.apresenta();
            resultado[i] = tab.toString();
        }

        return resultado;
    }

    public static void main(String[] args)
    {
        if (args.length == 1)
        {
            executaJogo(args[0]);
        }
        else
        {
            System.out.println("Você deve fornecer um arquivo de entrada!");
        }

    }
}