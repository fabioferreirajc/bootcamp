package org.academiadecodigo.stormrooters.sniper;

public class Game {

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;
    private int shootsFired;


    public Game(int size, SniperRifle sniper) {
        gameObjects = new GameObject[size];
        this.shootsFired = 0;
        this.sniperRifle = sniper;

    }

    public void createObjects() {

        for (int i = 0; i < gameObjects.length; i++) {
            int enemyGenerator = (int) (Math.random() * 5);

            if (enemyGenerator <= 1) {
                gameObjects[i] = new ArmouredEnemy();
            }

            if (enemyGenerator == 2 || enemyGenerator == 3) {
                gameObjects[i] = new SoldierEnemy();
            }
            if (enemyGenerator >= 4) {
                gameObjects[i] = new Tree();
            }
        }
    }

    public void start() {

        createObjects();

        for (GameObject gameObject : gameObjects) {

            System.out.println(gameObject.getMessage());

            if (gameObject instanceof Tree) {
            }

            if (gameObject instanceof Enemy) {
                Enemy enemy = (Enemy) gameObject;

                while (!enemy.isDead()) {
                    shootsFired++;
                    System.out.println("SHOOTS FIRED "+ shootsFired);
                    sniperRifle.shoot(enemy);
                }
            }

        }
    }

    public int getGameObjectsSize() {
        return gameObjects.length;
    }

    public GameObject[] getGameObject() {
        return gameObjects;
    }
}
