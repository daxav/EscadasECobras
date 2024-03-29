package game_root;

import game_entities.jogador.JogadoresCollection;
import game_map.casas.*;
import game_map.iterador_mapa.Mapa;

public class BuilderJogoConcreto implements IBuilderJogo{

    private Jogo jogo;

    @Override
	public void construirJogo(int quantidadeJogadores) 
    { 
        
        this.jogo = new Jogo(quantidadeJogadores);
    }

    @Override
	public void construirMapa(int quantidadeJogadores) 
    { 
        Mapa mapa = new Mapa();

        for (int i = 1; i < 101; i++) {
			if(i == 10 || i == 25 || i == 57){
				mapa.addCasa(new CasaEscada(i, i+10));
			}else if(i == 66 || i ==15 || i == 99){
				mapa.addCasa(new CasaCobra(i, i-10));
			}else if(i == 30 || i == 80 || i == 40){
				mapa.addCasa(new CasaBonus(i));
			}else{
				mapa.addCasa(new Casa(i));
			}
        }
        jogo.setMapa(mapa);
        
        for (int i = 0; i < quantidadeJogadores; i++)
		{
        	JogadoresCollection jogadores = jogo.getJogadores();
			mapa.getJogadoresPosicao().setCasaAtual(jogadores.getJogador(i), mapa.getCasa(0));
		}
    }
    

    @Override
	public Jogo getJogo() {
        return jogo;
    }

}