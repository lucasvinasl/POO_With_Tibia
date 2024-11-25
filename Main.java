package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Personagem p1 = null;
        Personagem p2 = null;
        Criatura criatura = null;

        String classe_p1 = "";
        String nome_p1 = "";
        String classe_p2 = "";
        String nome_p2 = "";
        String nome_criatura = "";
        int life_criatura = 0;

        boolean parada = true;

        while(parada){

            System.out.println(" Jogar no modo PVP - 1 ou PVE - 2: (1/2)");
            String modo = input.nextLine();

            if(modo.equals("1") || modo.equalsIgnoreCase("pvp")){

                System.out.println("Informe a Classe do Player 1: ");
                classe_p1 = input.nextLine();
                System.out.println("Qual o nome do Player 1: ");
                nome_p1 = input.nextLine();
                System.out.println("Informe a Classe do Player 2: ");
                classe_p2 = input.nextLine();
                System.out.println("Qual o nome do Player 2: ");
                nome_p2 = input.nextLine();

                p1 = criarPersonagem(classe_p1, nome_p1);
                p2 = criarPersonagem(classe_p2, nome_p2);

                while (p1.lifeStatus() && p2.lifeStatus()) {

                    p1.setAttack(p2);
                    if (!p2.lifeStatus()) {
                        System.out.printf("%s venceu a batalha!%n", p1.getNickName());
                        break;
                    }

                    // Paladin ataca Knight
                    p2.setAttack(p1);
                    if (!p1.lifeStatus()) {
                        System.out.printf("%s venceu a batalha!%n", p2.getNickName());
                        break; // Termina o loop
                    }
                }

            }else if(modo.equals("2") || modo.equalsIgnoreCase("pve")){

                System.out.println("Informe a Classe do Player 1: ");
                classe_p1 = input.nextLine();
                System.out.println("Qual o nome do Player 1: ");
                nome_p1 = input.nextLine();
                System.out.println("Qual o nome da Criatura: ");
                nome_criatura = input.nextLine();
                System.out.println("Qual o life da Criatura: ");
                life_criatura = input.nextInt();


                p1 = criarPersonagem(classe_p1, nome_p1);
                criatura = criarCriatura(nome_criatura, life_criatura);

                while (p1.lifeStatus() && criatura.lifeStatus()) {

                    p1.setAttack(criatura);
                    if (!criatura.lifeStatus()) {
                        System.out.printf("%s venceu a batalha!%n", p1.getNickName());
                        break;
                    }

                    // Paladin ataca Knight
                    criatura.setAttack(p1);
                    if (!p1.lifeStatus()) {
                        System.out.printf("%s venceu a batalha!%n", criatura.getNickName());
                        break; // Termina o loop
                    }
                }

            }else {
                System.out.println("Opção Inválida");
                return;
            }



            System.out.println("\n=== Fim da Batalha ===");
            System.out.println("Deseja Sair ou uma Nova Batalha ? (1 - Sair / 2 - Nova Batalha");
            int condicao = input.nextInt();
            input.nextLine();
            if(condicao == 1){
                parada = false;
            }else {
                continue;
            }
        }

        input.close();

        }

    public static Personagem criarPersonagem(String classe, String nome){
        switch (classe.toLowerCase()){
            case "knight":
                return new Knight(nome);

            case "paladin":
                return new Paladin(nome);

            case "mage":
                return new Mage(nome);

            default:
                System.out.println("Classe inválida!");
                return null;
        }
    }

    public static Criatura criarCriatura(String nome, int life){
            return new Criatura(nome, life);
    }

}


/*
POO COM TIBIA

    Personagem:
        Atributos:
            Nome
            Vocação:
                Knight:
                    Armas/Skills Físicas
                    Dano Físico
                    Muita Life/Vida
                    Pouca Mana

                Paladino:
                    Armas/Skills Físicas
                    Armas/Skills Mágicas
                    Dano Físico
                    Dano Mágico
                    Life/Vida Intermediária
                    Mana Intermediária

                Mago(Druid/Sorcerer):
                    Armas/Skills Mágicas
                    Dano Mágico
                    Pouca Life/Vida
                    Muita Mana

    Criaturas:
        Atributos:
            Nome
            Life/Vida
            Dano

        Recompensa por morte:
                Loot/Recompensa Material
                Experiência/XP

 */