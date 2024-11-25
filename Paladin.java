package org.example;

public class Paladin extends Personagem {

    // construtor:
    public Paladin(String name) {
        super(name, 300, 100);
    }

    // métodos sobreescritos:
    @Override
    public int calcDamage() {
        return (int) (Math.random()*(35-10+1)+10);
    }

    @Override
    public String getVocacao() {
        return "Paladin";
    }
}
