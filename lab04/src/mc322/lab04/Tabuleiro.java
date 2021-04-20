package mc322.lab04;

public class Tabuleiro
{
    Peca posicoes[][];
    int num_pecas;
    private int formaTabuleiro[][] = {
        {0, 0, 1, 1, 1, 0, 0},
        {0, 0, 1, 1, 1, 0, 0},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
        {0, 0, 1, 1, 1, 0, 0},
        {0, 0, 1, 1, 1, 0, 0},
    };

    // Inicia um novo tabuleiro completo;
    Tabuleiro()
    {
        posicoes = new Peca[7][7];
        for (int i = 0; i < 7; i++)
            for(int j = 0; j < 7; j++)
            {
                if (ehEspacoValido(i, j) && (i != 3 && j != 3))
                {
                    posicoes[i][j] = new Peca();
                }
                else
                {
                    posicoes[i][j] = null;
                }
            }
        num_pecas =  32;
    }

    // Checa se o espaço informado é válido
    private boolean ehEspacoValido(int i, int j)
    {
        if (formaTabuleiro[i][j] == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Realiza o movimento indicado, quando possível. Caso contrário, não faz nada.
    public void mover(String inicio, String fim)
    {

    }

    // Apresenta o estado atual do tabuleiro;
    public void apresenta()
    {

    }

    public String toString()
    {

    }

}