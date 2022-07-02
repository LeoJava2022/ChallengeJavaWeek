
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import model.Animal;
import model.Jogador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tailon.prado
 */
public class Main {
    private static ArrayList<Animal> baralho = new ArrayList();
    private static ArrayList<Jogador> jogadores = new ArrayList();
    public static void main(String[] args) {
        telaPrincipal();
    }
    
    public static void telaPrincipal() {
        int opcao;
        do  {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU PRINCIPAL \n"
                    + "1 - Jogar \n"
                    + "2 - Adicionar Animal \n"
                    + "3 - Exibir Lista de Animais \n"
                    + "4 - Jogar contra BOT \n"
                    + "0 - Sair"));
            
            switch (opcao) {
                case 1 :
                    iniciarJogo();
                    break;
                case 2 :
                    criarAnimal();
                    break;
                case 3 :
                    exibirAnimais();
                    break;
                case 4:
                    jogarContraBot();
                    break;
            }
        } while (opcao != 0);
    } 
    
    public static void criarAnimal() {
        
        int quantidade = Integer.parseInt(
                JOptionPane.showInputDialog("Quantas cartas você vai " + 
                        " querer adicionar?"));
        
        for (int i = 0; i < quantidade; i++) {
            String mensagemTela = "CRIANDO ANIMAL";
            mensagemTela += "\n Adicionando carta " + 
                    String.valueOf(i + 1) + "\n";
       
            String nome = JOptionPane.showInputDialog(mensagemTela + "\n"
                            + "Informe o nome do animal:");
            
            double forca = Double.parseDouble(
                    JOptionPane.showInputDialog(mensagemTela + "\n"
                            + "Informe um valor para a força:"));

            double defesa = Double.parseDouble(
                    JOptionPane.showInputDialog(mensagemTela + "\n"
                            + "Informe um valor para defesa:")); 

            double velocidade = Double.parseDouble(
                    JOptionPane.showInputDialog(mensagemTela + "\n"
                            + "Informe um valor para velocidade:"));

            baralho.add(new Animal(nome, forca, defesa, velocidade));
            
            JOptionPane.showMessageDialog(null, "As seguintes cartas foram adicionadas: \n"
                    + baralho.get(i).toString());
        }
         
    }
    
    public static void iniciarJogo() {
        iniciarJogador(
            JOptionPane.showInputDialog("Informe um nick name " +
                            "para o Jogador 1")); 
        selecaoDeCartas( jogadores.get(0) );
        
        iniciarJogador(
            JOptionPane.showInputDialog("Informe um nick name " +
                            "para o Jogador 2")); 
        selecaoDeCartas( jogadores.get(1) );
        
        iniciarBatalha();
        
        
        jogadores.removeAll(jogadores);
    }
    
    public static void iniciarBatalha(){
        String ganhadorRodada;
        do{
            ganhadorRodada = "";
            int atributoRodada = Integer.parseInt(
                    JOptionPane.showInputDialog("SELEÇÃO DE ATRIBUTO\n"+
                                                "0 - Força \n"+
                                                "1 - Defesa \n" + 
                                                "2 - Velocidade")); 
            switch(atributoRodada){
                case 0:
                    ganhadorRodada = comparaForca();
                    break;
                case 1:
                    ganhadorRodada = comparaDefesa();
                    break;
                case 2:
                    ganhadorRodada = comparaVelocidade();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }

            if (ganhadorRodada.equals("empate")) { 
                JOptionPane.showMessageDialog(null, "Houve empate");
            }else{
                JOptionPane.showMessageDialog(null, "O ganhador da rodada foi " + ganhadorRodada);
            }
            
        }while(jogadores.get(0).getListaCartas().size() > 0 && jogadores.get(1).getListaCartas().size() > 0);
        JOptionPane.showMessageDialog(null, "O ganhador do jogo foi " + ganhadorRodada);
    }
    
    public static String comparaForca(){
        ArrayList<Animal> listaCartasJogadorUm = jogadores.get(0).getListaCartas();
        ArrayList<Animal> listaCartasJogadorDois = jogadores.get(1).getListaCartas();
        
        if(listaCartasJogadorUm.get(0).getForca() > listaCartasJogadorDois.get(0).getForca()){
            removerAnimalDaLista(jogadores.get(1).getListaCartas(), 0);
            return jogadores.get(0).getNickName();
            
        }else if (listaCartasJogadorDois.get(0).getForca() > listaCartasJogadorUm.get(0).getForca()){
            removerAnimalDaLista(jogadores.get(0).getListaCartas(), 0);
            return jogadores.get(1).getNickName();
        }else{
            
            return "empate";
        }
    }
    
    public static String comparaDefesa(){
        ArrayList<Animal> listaCartasJogadorUm = jogadores.get(0).getListaCartas();
        ArrayList<Animal> listaCartasJogadorDois = jogadores.get(1).getListaCartas();
        
        if(listaCartasJogadorUm.get(0).getDefesa() > listaCartasJogadorDois.get(0).getDefesa()){
            removerAnimalDaLista(jogadores.get(1).getListaCartas(), 0);
            return jogadores.get(0).getNickName();
            
        }else if (listaCartasJogadorDois.get(0).getDefesa() > listaCartasJogadorUm.get(0).getDefesa()){
            removerAnimalDaLista(jogadores.get(0).getListaCartas(), 0);
            return jogadores.get(1).getNickName();
        }else{
            
            return "empate";
        }
    }
    
    public static String comparaVelocidade(){
        ArrayList<Animal> listaCartasJogadorUm = jogadores.get(0).getListaCartas();
        ArrayList<Animal> listaCartasJogadorDois = jogadores.get(1).getListaCartas();
        
        if(listaCartasJogadorUm.get(0).getVelocidade() > listaCartasJogadorDois.get(0).getVelocidade()){
            removerAnimalDaLista(jogadores.get(1).getListaCartas(), 0);
            return jogadores.get(0).getNickName();
            
        }else if (listaCartasJogadorDois.get(0).getVelocidade()> listaCartasJogadorUm.get(0).getVelocidade()){
            removerAnimalDaLista(jogadores.get(0).getListaCartas(), 0);
            return jogadores.get(1).getNickName();
        }else{
            
            return "empate";
        }
    }
    
    public static void selecaoDeCartas(Jogador jogador) {

        ArrayList<Animal> baralhoAux = new ArrayList();
        
        for (int i = 0; i < baralho.size(); i++) {
            baralhoAux.add(baralho.get(i));
        }
        
        for(int i = 0; i < baralho.size()/2; i++){
            String lista = "";
        
            for (int j = 0; j < baralhoAux.size(); j++) {
                lista += j + " - " + baralhoAux.get(j).getNome() + "\n";
            }


            int posicaoDaCarta = Integer.parseInt(
                JOptionPane.showInputDialog(
                    "SELEÇÃO DE CARTAS DO JOGADOR: " + jogador.getNickName() + "\n"
                    + lista)
            );

            jogador.addAnimal( baralhoAux.get(posicaoDaCarta) );
            baralhoAux.remove(posicaoDaCarta);
        }
        
    }
    
   public static void iniciarJogador(String nome) {
       jogadores.add(new Jogador(nome));
   }
    
    public static void exibirAnimais() {
        JOptionPane.showMessageDialog(null, 
                "BARALHO DE ANIMAIS: \n" +
                baralho.toString());
    }
    
    public static void removerAnimalDaLista(ArrayList lista, int posicao) {
        lista.remove(posicao);
    }
    
    public static void jogarContraBot(){
        iniciarJogador(
            JOptionPane.showInputDialog("Informe seu nick name")); 
        selecaoDeCartas( jogadores.get(0) );
        
        iniciarJogador("BOT");
        selecaoCartaBot(jogadores.get(1));
        
        iniciarBatalha();
    }
    public static void selecaoCartaBot(Jogador jogador){
        Random aleatorio = new Random();
        ArrayList<Animal> baralhoAux = new ArrayList();
        
        for (int i = 0; i < baralho.size(); i++) {
            baralhoAux.add(baralho.get(i));
        }
        
        for(int i = 0; i < baralho.size()/2; i++){
            int posicaoAleatoria = aleatorio.nextInt(baralhoAux.size());
            System.out.println(posicaoAleatoria);
            jogador.addAnimal( baralhoAux.get(posicaoAleatoria) );
            baralhoAux.remove(posicaoAleatoria);
        }
    }
}
