package org.legtux.g316k.colorswitch;

import org.legtux.g316k.colorswitch.model.Entity;
import org.legtux.g316k.colorswitch.model.Game;
import org.legtux.g316k.colorswitch.model.level.Level;

import java.util.List;

/**
 * Contrôleur pour le jeu : fait le pont entre la vue et les modèles.
 */
public class Controller {

    private Game game;
    private int level = 1;

    public Controller() {
        this.game = new Game(Game.WIDTH, Game.HEIGHT, level);
    }


        public List<Entity> getEntities() {
            return this.game.getEntities();
        }


        /**
         * Fonction appelée à chaque frame du jeu.
         *
         * @param dt Delta-temps exprimé en secondes
         */
        public void tick(double dt) {
            if (this.game.isGameOver()) {
                int msgFlag = Game.SHOW_MSG_LOST;
                if (this.game.hasWon()) {
                    level++;
                    msgFlag = Game.SHOW_MSG_WIN;
                }

                // TODO - replace nex line with end of game message
                if (level > Game.MAX_LEVEL) level = 1;

                this.game = new Game(Game.WIDTH, Game.HEIGHT, level, msgFlag);
            } else {
                this.game.tick(dt);
            }
        }


        public Level getCurrentLevel() {
            return this.game.getLevel();
        }


        /**
         * Sélectionne un niveau et démarre une nouvelle partie
         *
         * @param level Le nouveau niveau à utiliser.
         */
        public void setLevel(int level) {
            this.level = level;
            this.game = new Game(Game.WIDTH, Game.HEIGHT, level, Game.DONT_SHOW_MSG);
        }


        /**
         * Retourne le niveau maximal supporté par le jeu.
         *
         * @return
         */
        public int getMaxLevel() {
            return Game.MAX_LEVEL;
        }


        /**
         * Fonction appelée lorsque la barre espace est enfoncée.
         */
        public void spaceTyped() {
            this.game.jump();
        }


        /**
         * Fonction appelée lorsqu'un 'J' est appuyé par le joueur.
         */
        public void jTyped() {
            game.useJetPack();
        }

        /**
         * Fonction appelée lorsque TAB est appuyé par le joueur.
         */
        public void tabTyped() {
            game.toggleInvulnerability();
        }
    }
