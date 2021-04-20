package mc322.lab04;

public class Tabuleiro
{
    Peca posicoes[][];
    int num_pecas;
    /* Descreve a forma do tabuleiro:
    1: espaço válido
    0: espaço inválido
    */
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
                if (!ehEspacoValido(i, j) || (i == 3 && j == 3))
                {
                    posicoes[i][j] = null;
                }
                else
                {
                    posicoes[i][j] = new Peca();
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

    // Checa se o movimento é válido
    private boolean ehMovimentoValido(int iInicio, int jInicio, int iFim, int jFim)
    {

    }

    // Realiza o movimento indicado, quando possível. Caso contrário, não faz nada.
    public void mover(int iInicio, int jInicio, int iFim, int jFim)
    {
        if (ehMovimentoValido(iInicio, jInicio, iFim, jFim))
        {
            // Come a peça;
            if (iInicio == iFim)
            {
                posicoes[iInicio][jInicio + 1] = null;
            }
            else if (jInicio == jFim)
            {
                posicoes[iInicio + 1][jInicio] = null;
            }
            // realiza o salto:
            posicoes[iFim][jFim] = posicoes[iInicio][jInicio];
            posicoes[iInicio][jInicio] = null;
        }
    }

    // Retorna uma string que representa a linha
    private String stringLinha(int i)
    {
        String res = "";

        for(int j = 0; j < 7; j++)
        {
            if(ehEspacoValido(i, j))
            {
                if(posicoes[i][j] != null)
                {
                    res += posicoes[i][j].apresenta();
                }
                else
                {
                    res += '-';
                }
            }
            else
            {
                res += '-';
            }
        }

        return res + "\n";
    }
    // Apresenta o estado atual do tabuleiro;
    public void apresenta()
    {
        for(int i = 0; i < 7; i++)
        {
            System.out.printf("%d ", i + 1);
            System.out.print(stringLinha(i));
        }
        System.out.println("  abcdefg");
    }

    public String toString()
    {
        String res = "";

        for(int i = 0; i < 7; i++)
        {
            res += stringLinha(i);
        }

        return res;
    }

}