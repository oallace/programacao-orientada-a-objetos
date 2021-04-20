package mc322.lab04;

public class AppRestaUm
{
    public static String[] executaJogo(String caminhoCSV)
    {
        String comandos[];
        String resultado [];
        Tabuleiro tab = new Tabuleiro();
        CSVReader csv = new CSVReader();
        
        // lê os comandos
        csv.setDataSource(caminhoCSV);
        comandos = csv.requestCommands();
        // inicia o vetor resultado:
        resultado = new String[comandos.length];
        // executa os comandos da forma a9:a9
        for (int i = 0; i < comandos.length; i++)
        {
            tab.mover(comandos[i].substring(0, 2), comandos[i].substring(3, 5));
            tab.apresenta();
            resultado[i] = tab.toString();
        }

        return resultado;
    }

    public static void main(String[] args)
    {
        executaJogo("comandos.csv");
    }
}