package org.example;

public class Knight extends Personagem{

    // construtor:
    public Knight(String name) {
        super(name, 300, 100);
    }

    // métodos abstrato sobreescritos:
    @Override
    public int calcDamage() {
        return (int) (Math.random()*(30-10+1)+10);
    }

    @Override
    public String getVocacao() {
        return "Knight";
    }
}
