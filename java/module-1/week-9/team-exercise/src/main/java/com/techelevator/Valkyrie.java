package com.techelevator;

public class Valkyrie extends Character {
    public Valkyrie (String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack(Character opponent) {
        int damage = getAttackPower();
        System.out.printf("%s attacks %s for %d damage!%n", getName(), opponent.getName(), damage);
        opponent.setHealth(opponent.getHealth() - damage);
    }
}
