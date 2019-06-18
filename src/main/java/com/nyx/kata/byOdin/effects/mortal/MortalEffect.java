package com.nyx.kata.byOdin.effects.mortal;

import com.nyx.kata.byOdin.effects.Effect;
import com.nyx.kata.byOdin.units.MortalDice;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.List;

public interface MortalEffect extends Effect {

    void apply(MortalDice dice, List<WarriorUnit> refWarriorUnit);

}
