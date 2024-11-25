package org.example;

public abstract class Personagem implements Damage {

    // atributos:
    private String nickName;
    private int life;
    private int mana;

    // construtor:
    public Personagem(String nome, int life, int mana){
        this.nickName = nome;
        this.life = life;
        this.mana = mana;
    }

    // métodos - get:
    public String getNickName(){
        return nickName;
    }

    public int getLife(){
        return life;
    }

    public int getMana(){
        return mana;
    }

    public abstract String getVocacao();

    // métodos - set:
    public void setAttack(Personagem player){
        int dano = calcDamage();
        System.out.printf("%s atacou %s com %d de dano !%n", this.nickName, player.getNickName(), dano);
        player.recebeAttack(dano);
    }

    public void recebeAttack(int dano){
        this.life -= dano;
        if(this.life < 0){
            this.life = 0;
        }
        System.out.printf("%s tem %d de vida ! %n",this.nickName, this.life);
    }

    public boolean lifeStatus(){

        if(this.life > 0){
            return true;
        }else{
            return false;
        }
    }

    public void review(){
        System.out.println(getVocacao());
        System.out.printf("%s, Vida: %d, Mana: %d", getNickName(), getLife(), getMana());
        System.out.println("");
    }

}
