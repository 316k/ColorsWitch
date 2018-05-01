package org.legtux.g316k.colorswitch.model;

import org.legtux.g316k.colorswitch.model.level.Level;
import org.legtux.g316k.colorswitch.model.level.Level1;
import org.legtux.g316k.colorswitch.model.level.Level10;
import org.legtux.g316k.colorswitch.model.level.Level2;
import org.legtux.g316k.colorswitch.model.level.Level3;
import org.legtux.g316k.colorswitch.model.level.Level4;
import org.legtux.g316k.colorswitch.model.level.Level5;
import org.legtux.g316k.colorswitch.model.level.Level6;
import org.legtux.g316k.colorswitch.model.level.Level7;
import org.legtux.g316k.colorswitch.model.level.Level8;
import org.legtux.g316k.colorswitch.model.level.Level9;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui gère une partie du jeu Colors Witch.
 */
public class Game {

    public static final int WIDTH = 320, HEIGHT = 480;
    /**
     * Niveau maximum supporté par le jeu.
     */
    public static final int MAX_LEVEL = 10;

    /**
     * Flags permettant de déterminer le message à afficher selon le
     * résultat de la partie précédente.
     */
    public static final int SHOW_MSG_LOST = -1;
    public static final int DONT_SHOW_MSG = 0;
    public static final int SHOW_MSG_WIN = 1;

    /**
     * Message de félicitation à afficher selon le niveau réussi.
     */
    static final String[] CONGRAT_MSG = {
            "Winner !!!\nLet's go for another round !",
            "Yeah !",
            "Good job !",
            "Way to go !",
            "Amazing !",
            "You rock !",
            "Dude !",
            "My hero !",
            "Incredible !",
            "You are unstopable !"
    };

    private Level level;
    private Player player;

    /**
     * Les différents messages à afficher.
     */
    private Message winningMsg, losingMsg, levelMsg, jetPackMsg, foundJetPackMsg;
    private int msgFlag;

    /**
     * Utilisés lorsque le joueur entre en collision avec un obstacle.
     */
    private double timeSinceBeginning;
    private BallExplosion[] ballExplosion;
    private double timeSinceBallExploded;

    /**
     * Dimensions de l'écran
     */
    private double screenWidth, screenHeight;

    /**
     * Indique si la partie est terminée/gagnée
     */
    private boolean gameOver = false;
    private boolean hasWon = false;
    private boolean ballsExploding = false;

    public Game(double screenWidth, double screenHeight, int levelNumber) {
        this(screenWidth, screenHeight, levelNumber, Game.DONT_SHOW_MSG);
    }

    /**
     * Crée une partie dans le niveau levelNumber.
     *
     * @param screenWidth  largeur de l'écran
     * @param screenHeight hauteur de l'écran
     * @param levelNumber  numéro du niveau
     * @param msgFlag      indique si l'on doit afficher un message win/lose
     */
    public Game(double screenWidth, double screenHeight, int levelNumber, int msgFlag) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.msgFlag = msgFlag;
        this.timeSinceBeginning = 0;
        this.ballExplosion = new BallExplosion[50];
        this.timeSinceBallExploded = 0;
        double halfScreenwidth = screenWidth / 2;

        player = new Player(halfScreenwidth, 200, 15);

        generateMessages(halfScreenwidth, levelNumber);

        switch (levelNumber) {
            case 1:
                level = new Level1(screenWidth, screenHeight, 1);
                break;
            case 2:
                level = new Level2(screenWidth, screenHeight, 2);
                break;
            case 3:
                level = new Level3(screenWidth, screenHeight, 3);
                break;
            case 4:
                level = new Level4(screenWidth, screenHeight, 4);
                break;
            case 5:
                level = new Level5(screenWidth, screenHeight, 5);
                break;
            case 6:
                level = new Level6(screenWidth, screenHeight, 6);
                break;
            case 7:
                level = new Level7(screenWidth, screenHeight, 7);
                break;
            case 8:
                level = new Level8(screenWidth, screenHeight, 8);
                break;
            case 9:
                level = new Level9(screenWidth, screenHeight, 9);
                break;
            case 10:
                level = new Level10(screenWidth, screenHeight, 10);
                break;
            default:
                throw new IllegalArgumentException("Niveau inconnu");
        }
    }


    /**
     * Méthode privée générant les messages à afficher en fonction du niveau.
     *
     * @param x     coordonée de référence en x (généralement la moitiée de l'écran)
     * @param level le niveau de la partie en cours
     */
    private void generateMessages(double x, int level) {
        String completed = (level == 1
                ? "All levels completed !\n"
                : "Level " + (level - 1) + " completed !\n");

        jetPackMsg = new Message(x * 1.5, 20, "[J]", 20);
        foundJetPackMsg = new Message(x, 400, "You found a Jet Pack!\nSwipe up to use it", 20);

        winningMsg = new Message(x, 200, completed + CONGRAT_MSG[level - 1], 20);
        losingMsg = new Message(x, 200, "Failed Level " + level + "...\nLet's try again !", 20);
        levelMsg = new Message(x, 20, "" + level, 20);
    }


    /**
     * Méthode privée créant une centaine de balles pour simuler
     * l'explosion de l'avatar du joueur après une collision.
     */
    private void makeHundredBalls() {
        for (int i = 0; i < ballExplosion.length; i++) {
            int color = (int) (Math.random() * (5 - 1)) + 1;
            double r = Math.random() * (player.getRadius() / 3) + player.getRadius() / 8;

            ballExplosion[i] = new BallExplosion(player.getX(), player.getY(),
                    r, player.getRadius(), color, 0, screenWidth,
                    level.getScroll(), screenHeight);
        }
    }


    /**
     * Fonction appelée à chaque frame
     *
     * @param dt Delta-Temps (en secondes)
     */
    public void tick(double dt) {
        level.tick(dt);

        if (!ballsExploding) {
            player.tick(dt);

            if (player.getY() - player.getRadius() < 0.2 * screenHeight) {
                // Empêche la balle de sortir de l'écran
                player.setY(0.2 * screenHeight + player.getRadius());
            } else if (player.getY() - level.getScroll() > screenHeight / 2) {
                // Scroll le level verticalement si nécessaire
                level.incrementScroll(player.getY() - level.getScroll() - screenHeight / 2);
            } else if (player.getY() + player.getRadius() < level.getScroll()) {
                loose();
            }

            // Gestion des collisions avec les éléments (items/obstacles/...) du niveau
            for (LevelElement element : level.getEntities()) {
                if (!player.hasShield() && !player.getJetPackInUse() && element.intersects(player)) {
                    element.handleCollision(player, this);
                }
            }
        }

        if (msgFlag != 0) {
            timeSinceBeginning += dt;
            if (timeSinceBeginning > 3) {
                msgFlag = 0;
            }
        }

        if (ballsExploding) {
            timeSinceBallExploded += dt;
            for (int i = 0; i < ballExplosion.length; i++) {
                ballExplosion[i].tick(dt);
            }

            if (timeSinceBallExploded > 2) {
                this.gameOver = true;
                this.ballsExploding = false;
            }
        }
    }


    /**
     * Retourne les entités à afficher à l'écran.
     *
     * @return les entités à afficher à l'écran
     */
    public List<Entity> getEntities() {
        List<Entity> entities = new ArrayList<>();

        entities.addAll(level.getEntities());

        if (ballsExploding) {
            for (int i = 0; i < ballExplosion.length; i++) {
                entities.add(ballExplosion[i]);
            }
            entities.add(losingMsg);
        } else {
            entities.add(player);
        }

        if (msgFlag == SHOW_MSG_WIN) {
            entities.add(winningMsg);
        } else if (msgFlag == SHOW_MSG_LOST) {
            entities.add(losingMsg);
        }
        entities.add(levelMsg);

        if (player.hasJetPack()) {
            entities.add(jetPackMsg);
        }

        if (player.getFoundJetPack()) {
            entities.add(foundJetPackMsg);
        }

        return entities;
    }


    /**
     * Accesseur du niveau de jeu.
     *
     * @return level Le niveau
     */
    public Level getLevel() {
        return level;
    }


    /**
     * Fait sauter le player.
     */
    public void jump() {
        player.jump();
    }


    /**
     * Fait utiliser le JetPack par le player.
     */
    public void useJetPack() {
        player.useJetPack();
    }


    /**
     * Initie une explosion de balles lorsque la partie est perdue.
     */
    public void loose() {
        ballsExploding = true;
        this.makeHundredBalls();
    }


    /**
     * Fait gagner la partie.
     */
    public void win() {
        this.hasWon = true;
        this.gameOver = true;
    }


    /**
     * Indique si la partie est gagnée
     *
     * @return true si la partie est gagnée, false sinon
     */
    public boolean hasWon() {
        return hasWon;
    }


    /**
     * Indique si la partie est terminée
     *
     * @return true si la partie est terminée, false sinon
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Cheat mode utilisé pour permettre au correcteur de passer rapidement
     * des obstacles.
     */
    public void toggleInvulnerability() {
        player.toggleInvulnerability();
    }
}
