package creatures;

import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;

import java.awt.*;
import java.util.Map;

public class Clorus extends Creature {


    public Clorus(double e) {
        super("clorus");
        energy = e;

    }

    @Override
    public void move() {
        this.energy -= 0.03;

    }

    @Override
    public void attack(Creature c) {
        this.energy += c.energy();
    }

    @Override
    public Creature replicate() {
        this.energy = this.energy / 2;
        double babyEnergy = this.energy;
        return new Clorus(babyEnergy);
    }

    @Override
    public void stay() {
        this.energy -= 0.03;
    }

    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        return null;
    }

    @Override
    public Color color() {
        return new Color(34,0,231);
    }
}
