package mc322.lab03;

public class Animacao
{
    AquarioLombriga lombriga;
    String seqPassos;
    int proxPasso;

    Animacao(String novaAnimacao)
    {
        int tamAquario = Integer.parseInt(novaAnimacao.substring(0, 2));
        int tamLombriga = Integer.parseInt(novaAnimacao.substring(2, 4));
        int posLombriga = Integer.parseInt(novaAnimacao.substring(4, 6));
        this.lombriga = new AquarioLombriga(tamAquario, tamLombriga, posLombriga);
        this.seqPassos = novaAnimacao.substring(6);
        this.proxPasso = 0;
    }

    public String apresenta()
    {
        return lombriga.apresenta();
    }

    public void passo()
    {
        if (proxPasso < seqPassos.length())
        {
            switch (seqPassos.charAt(proxPasso)) 
            {
                case 'C':
                    lombriga.crescer();
                    break;
                case 'M':
                    lombriga.mover();
                    break;
                case 'V':
                    lombriga.virar();
                    break;
            }
            proxPasso++;
    }
    }
}