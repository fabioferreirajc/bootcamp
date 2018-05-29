package org.academiadecodigo.bootcamp.sniperelite.gameobject;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.decor.Tree;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.enemy.ArmouredEnemy;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.enemy.Enemy;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.enemy.SoldierEnemy;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.props.Barrel;

public class GameObjectFactory {

    private static final int ENEMY_HEALTH = 3;
    private static final int ARMOUR = 3;

    public static Enemy createEnemy() {

        return Math.random() > 0.5 ? new SoldierEnemy(ENEMY_HEALTH) : new ArmouredEnemy(ENEMY_HEALTH, ARMOUR);

    }

    public static GameObject createObject() {

        return Math.random() > 0.5 ? new Tree() : new Barrel();

    }

}
