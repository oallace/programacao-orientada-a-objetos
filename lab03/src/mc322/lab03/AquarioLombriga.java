package mc322.lab03;

public class AquarioLombriga
{
    public int tamLombriga, posLombriga, sentidoLombriga;
    public int tamAquario;

    AquarioLombriga(int tamAquario, int tamLombriga, int posLombriga)
    {
        this.tamLombriga = tamLombriga;
        if (tamLombriga > tamAquario)
        {
            this.tamAquario = tamLombriga;
        }
        else
        {
            this.tamAquario = tamAquario;
        }
        // Se a lombriga informada ultrapassa os limites do aquario:
        if (posLombriga + tamLombriga - 1 > this.tamAquario)
        {
            this.posLombriga = 1;
        }
        else
        {
            this.posLombriga = posLombriga;
        }
        this.sentidoLombriga = 1;
    }

    public String apresenta()
    {
        String res = "";
        for (int i = 1; i <= tamAquario; i++)
        {
            // Escreve a lombriga:
            if (i >= posLombriga && i < posLombriga + tamLombriga)
            {
                // Define a posição da cabeça da lombriga:
                if ((sentidoLombriga == 1 && i == posLombriga + tamLombriga - 1) || (sentidoLombriga == -1 && i == posLombriga))
                {
                    res = res + "0";
                }
                else
                {
                    res = res + "@";
                }
            }
            // Escreve aquário:
            else
            {
                res = res + "#";
            }
        }
        return res;
    }

    public void crescer()
    {
        if (sentidoLombriga == 1)
        {
            if (posLombriga > 1)
            {
                tamLombriga += 1;
                posLombriga -= 1;
            }
            else
            {
                System.out.println("Parece que não há espaço atrás de você!");
            }
        }
        else
        {
            if (posLombriga + tamLombriga - 1 < tamAquario)
            {
                tamLombriga += 1;
            }
            else
            {
                System.out.println("Parece que não há espaço atrás de você!");
            }
        }
    }

    public void mover()
    {
        if (sentidoLombriga == 1)
        {
            if (posLombriga + tamLombriga - 1 < tamAquario)
            {
                posLombriga += 1;
            }
            else
            {
                System.out.println("Ops! Não há mais espaço por esse lado!");
            }
        }
        else
        {
            if (posLombriga > 1)
            {
                posLombriga -= 1;
            }
            else
            {
                System.out.println("Ops! Não há mais espaço por esse lado!");
            }
        }
    }

    public void virar()
    {
        sentidoLombriga = sentidoLombriga * (-1);
    }
}