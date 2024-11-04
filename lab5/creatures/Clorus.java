package creatures;

import huglife.*;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.randomEntry;

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
        Deque<Direction> emptyNeightbors = new ArrayDeque<Direction>();
        Deque<Direction> plipNeighbors = new ArrayDeque<>();
        for(Map.Entry<Direction,Occupant> entry: neighbors.entrySet()){
            Direction dir = entry.getKey();
            Occupant occupant = entry.getValue();
            if(occupant.name() == "empty"){
                emptyNeightbors.add(dir);
            }
            if(occupant.name() == "plip"){
                plipNeighbors.add(dir);
            }
        }
        if(emptyNeightbors.size() == 0){
            return new Action(Action.ActionType.MOVE);
        }

        if(plipNeighbors.size() != 0){
            return  new Action(Action.ActionType.ATTACK, randomEntry(plipNeighbors));
        }

        if(this.energy >= 1){
            return new Action(Action.ActionType.REPLICATE,randomEntry(emptyNeightbors));
        }

        return new Action(Action.ActionType.STAY,randomEntry(emptyNeightbors));
    }

    @Override
    public Color color() {
        return new Color(34,0,231);
    }
}
