package org.legtux.g316k.colorswitch.model;

import org.legtux.g316k.colorswitch.view.renderer.PlayerRenderer;

/**
 * Classe représentant l'entité de la personne qui joue (aka, la sorcière).
 * <p>
 * La sorcière est représentée par un cercle.
 */
public class Player extends Entity implements RoundShape {

    private double radius;
    private int color;
    private double vy = 0;
    private final double maxVy = 400;

    private double ay = -1300;

    /**
     * couleurs utilisées pour indiquer qu'un effet est actif
     */
    private final int shieldColor;
    private final int bckEffectColor;
    private final int gravityColor;
    private final int jetPackColor;
    private int currentShieldColor;
    private int currentGravColor;
    private int currentJetPackColor;

    /**
     * tient à jour le status de l'effet shield
     */
    private boolean hasShield;
    private double timeSinceShieldActivated;
    private double shieldDelay;

    /**
     * tient à jour le status de l'effet gravité
     */
    private boolean increasedGravity;
    private double timeSinceGravityBoost;

    /**
     * tient à jour le status de l'effet jetpack
     */
    private boolean hasJetPack;
    private double timeSinceJetActivated;
    private boolean jetPackInUse;
    private boolean foundJetPack;
    private double timeSinceJetPackFound;

    public Player(double x, double y, double r) {
        super(x, y);

        this.color = 1;
        this.radius = r;

        this.hasShield = false;
        this.timeSinceShieldActivated = 0;
        this.shieldDelay = 0;
        this.shieldColor = 4;
        this.currentShieldColor = shieldColor;

        this.increasedGravity = false;
        this.gravityColor = 5;

        this.hasJetPack = false;
        this.jetPackColor = 6;
        this.currentJetPackColor = jetPackColor;
        this.jetPackInUse = false;
        this.foundJetPack = false;

        this.bckEffectColor = 7;
        this.currentGravColor = gravityColor;

        this.renderer = new PlayerRenderer(this);
    }

    /**
     * Fonction appelée à chaque frame pour mettre à jour les attributs de
     * l'entité
     *
     * @param dt Delta-Temps en secondes
     */
    @Override
    public void tick(double dt) {
        // Mise à jour de la vitesse
        if (!jetPackInUse) {
            vy += (increasedGravity ? 2.5 : 1) * dt * ay;
        }

        vy = Math.min(vy, 1.5 * maxVy);

        // Clip la vitesse effective de la balle
        y += dt * Math.max(Math.min(vy, maxVy), -maxVy);

        if (hasShield) {
            timeSinceShieldActivated += dt;

            if (timeSinceShieldActivated > shieldDelay) {
                timeSinceShieldActivated = 0;
                hasShield = false;
            } else if ((timeSinceShieldActivated * 100) % 20 > 10) {
                currentShieldColor = shieldColor;
            } else {
                currentShieldColor = bckEffectColor;
            }

        }

        if (increasedGravity) {
            timeSinceGravityBoost += dt;

            if (timeSinceGravityBoost > 6) {
                timeSinceGravityBoost = 0;
                increasedGravity = false;
            } else if ((timeSinceGravityBoost * 100) % 20 > 10) {
                currentGravColor = gravityColor;
            } else {
                currentGravColor = bckEffectColor;
            }
        }

        if (jetPackInUse) {
            timeSinceJetActivated += dt;

            if (timeSinceJetActivated > 1.3) {
                timeSinceJetActivated = 0;
                hasJetPack = false;
                jetPackInUse = false;
            } else if ((timeSinceJetActivated * 100) % 20 > 10) {
                currentJetPackColor = jetPackColor;
            } else {
                currentJetPackColor = bckEffectColor;
            }

        }

        if (foundJetPack) {
            timeSinceJetPackFound += dt;
            if (timeSinceJetPackFound > 2) {
                foundJetPack = false;
            }
        }
    }


    /**
     * Remplace la couleur actuelle par une nouvelle couleur aléatoire
     */
    public void randomizeColor() {
        int newColor;

        do {
            newColor = (int) (Math.random() * 4);
        } while (newColor == this.color);

        this.color = newColor;
    }


    /**
     * Fait sauter la sorcière
     */
    public void jump() {

        if(vy < 0) {
            vy = maxVy;
        } else {
            vy += maxVy / 2;
        }

        // vy += increasedGravity ? 300 : 400;
/*
        vy += maxVy;
*/
    }

    /**
     * Active l'effet shield.
     */
    public void shieldUp() {
        shieldDelay = 3.0;
        hasShield = true;
    }


    /**
     * Cheat mode utilisé pour permettre au correcteur de passer rapidement
     * des obstacles.
     */
    public void toggleInvulnerability() {
        if (hasShield) {
            shieldDelay = 0.0;
            hasShield = false;
            timeSinceShieldActivated = 0;
        } else {
            shieldDelay = Double.POSITIVE_INFINITY;
            hasShield = true;
        }
    }

    /**
     * Détermine si l'effet shield est actif.
     *
     * @return true si shield est actif.
     */
    public boolean hasShield() {
        return hasShield;
    }


    /**
     * Retourne la couleur actuelle de l'aura shield.
     *
     * @return la couleur de l'aura à afficher.
     */
    public int getShieldColor() {
        return currentShieldColor;
    }


    /**
     * Retourne la couleur actuelle de l'aura gravity.
     *
     * @return la couleur de l'aura à afficher.
     */
    public int getGravityColor() {
        return currentGravColor;
    }


    /**
     * Active l'effet gravity.
     */
    public void increaseGravity() {
        increasedGravity = true;
    }


    /**
     * Détermine si l'effet gravity est actif.
     *
     * @return true si l'effet gravity est actif.
     */
    public boolean hasGravity() {
        return increasedGravity;
    }


    /**
     * Détermine si le joueur a un jetpack en sa possession.
     *
     * @return true si le joueur a un jetpack.
     */
    public boolean hasJetPack() {
        return hasJetPack;
    }


    /**
     * Retourne la couleur actuelle de l'aura jetpack.
     *
     * @return la couleur de l'aura à afficher.
     */
    public int getJetPackColor() {
        return currentJetPackColor;
    }


    /**
     * Ramasse un jetpack.
     */
    public void jetPackUp() {
        hasJetPack = true;
        foundJetPack = true;
    }


    /**
     * Active le jetpack.
     */
    public void useJetPack() {
        if (hasJetPack) {
            jetPackInUse = true;
            vy = maxVy;
        }
    }


    /**
     * Détermine si le jetpack est actif.
     *
     * @return true si le jetpack est actif.
     */
    public boolean getJetPackInUse() {
        return jetPackInUse;
    }


    /**
     * Détermine si un jetpack vient d'être ramassé (utilisé pour afficher un
     * message informatif).
     *
     * @return true si un jetpack vient d'être ramassé.
     */
    public boolean getFoundJetPack() {
        return foundJetPack;
    }

    public void setY(double y) {
        this.y = y;
    }


    /**
     * Le point le plus au nord de la circonférence de l'avatar du joueur.
     *
     * @return la valeur de ce point
     */
    public double getNorthBorder() {
        return y + radius;
    }


    /**
     * Le point le plus au sud de la circonférence de l'avatar du joueur.
     *
     * @return la valeur de ce point
     */
    public double getSouthBorder() {
        return y - radius;
    }


    /**
     * Le point le plus à l'ouest de la circonférence de l'avatar du joueur.
     *
     * @return la valeur de ce point
     */
    public double getWestBorder() {
        return x - radius;
    }


    /**
     * Le point le plus à l'est de la circonférence de l'avatar du joueur.
     *
     * @return la valeur de ce point
     */
    public double getEastBorder() {
        return x + radius;
    }


    /**
     * Largeur de l'avatar du joueur
     *
     * @return la valeur en pixel
     */
    @Override
    public double getWidth() {
        return this.getRadius() * 2;
    }


    /**
     * Hauteur de l'avatar du joueur
     *
     * @return la valeur en pixel
     */
    @Override
    public double getHeight() {
        return this.getRadius() * 2;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public int getColor() {
        return color;
    }
}
