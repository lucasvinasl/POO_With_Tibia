package org.example;

public class Mage extends Personagem{

    // construtor:
    public Mage(String name) {
        super(name, 100, 300);
    }

    // métodos sobreescritos:
    @Override
    public int calcDamage() {
        int max = (int) (getMana()*0.1);
        int bonus = (int) (Math.random()*(50-10+1)+10);
        return max + bonus;
    }

    @Override
    public String getVocacao() {
        return "Mage";
    }
}
