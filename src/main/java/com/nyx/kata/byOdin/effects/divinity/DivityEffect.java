package com.nyx.kata.byOdin.effects.divinity;

import com.nyx.kata.byOdin.effects.Effect;
import com.nyx.kata.byOdin.units.DivinityDice;
import com.nyx.kata.byOdin.units.WarriorUnit;

import java.util.List;

public interface DivityEffect extends Effect {

    void apply(DivinityDice divinityDice, List<WarriorUnit> refWarriorUnit);

}
