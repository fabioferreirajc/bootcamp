package org.academiadecodigo.stormrooters.sniper;

public class Game {

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;
    private int shotsFired;


    public Game(int size, SniperRifle sniper) {
        gameObjects = new GameObject[size];
        this.shotsFired = 0;
        this.sniperRifle = sniper;

    }

    public void createObjects() {

        for (int i = 0; i < gameObjects.length; i++) {
            int enemyGenerator = (int) (Math.random() * 5);

            if (enemyGenerator == 0 || enemyGenerator == 1) {
                gameObjects[i] = new ArmouredEnemy();
                System.out.println("Armoured enemy soldier created");
            }

            if (enemyGenerator == 2 || enemyGenerator == 3) {
                gameObjects[i] = new SoldierEnemy();
                System.out.println("Enemy soldier created");
            }
            if (enemyGenerator == 4) {
                gameObjects[i] = new Tree();
                System.out.println("Tree created");
            }
        }
    }

    public void start() {
        createObjects();
        for (GameObject enemies : gameObjects) {
            sniperRifle.shot();

        }
    }

    public int getGameObjectsSize() {
        return gameObjects.length;
    }

    public GameObject[] getGameObject() {
        return gameObjects;
    }
}
