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
        // executa os comandos da forma a9:a9
        for (int i = 0; i < comandos.length; i++)
        {
            // converte o comando em string em seus valores inteiros:
            jInicio = Character.getNumericValue(comandos[i].charAt(0)) - Character.getNumericValue('a');
            iInicio = Character.getNumericValue(comandos[i].charAt(1)) - Character.getNumericValue('1');
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
        executaJogo("testes/teste8.csv");
    }
}