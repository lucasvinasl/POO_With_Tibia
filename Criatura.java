package org.example;

public class Criatura extends Personagem{

    public Criatura(String name, int life){
        super(name, life,0);
    }


    @Override
    public int calcDamage() {
        return (int) (Math.random()*(10-10+1)+10);
    }

    @Override
    public String getVocacao() {
        return "Criatura";
    }

}
