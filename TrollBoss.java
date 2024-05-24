import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa una instancia de TrollBoss
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class TrollBoss extends Enemy
{
    private int rockRainSpawnDelayCounter = 200;
    private boolean rockRainSpawnOnCooldown = false;
    private boolean alreadyScreamed = false;
    GreenfootSound screamTrollBoss = new GreenfootSound("Troll_Boss_muere.mp3");
    Goal goal = new Goal();
    public TrollBoss(boolean isBoss)
    {
        super(6,1,5);
        if(isBoss)
            boss();
    }

    /**
     * Act - do whatever the TrollBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isAlive)
        {
            checkFalling();
            checkForPlayerAtLeft();
            wander(100, 100, 200);
            getDamaged();
            if(enemyInvincible)
                enemyInvincibilityTimer();
        }
        else if(!isAlive && isBoss)
        {
            if(!alreadyScreamed)
                trollBossDeathScream();
            getWorld().addObject(goal, 1150, 726);
        }
    }

    /**
     * Inicia el combate con el jugador, cada subclase de enemigo ataca diferente
     */
    public void engage()
    {
        lockOnPlayer();
        spawnRockRain();
        if(rockRainSpawnOnCooldown)
            rockRainSpawnDelay();
    }

    /**
     * Hace aparecer estalactitas encima del jugador
     */
    public void spawnRockRain()
    {
        if(!rockRainSpawnOnCooldown)
        {
            if(isPlayerAtLeft)
            {
                getWorld().addObject(new Stalactite(), getX() - 100, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() - 120, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() - 140, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() - 160, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() - 180, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() - 200, getY() + getImage().getHeight() * -1);
                rockRainSpawnOnCooldown = true;
            }
            else
            {
                getWorld().addObject(new Stalactite(), getX() + 100, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() + 120, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() + 140, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() + 160, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() + 180, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() + 200, getY() + getImage().getHeight() * -1);
                rockRainSpawnOnCooldown = true;
            }
        }
    }

    /**
     * Un delay entre aparicion de rocas
     */
    public void rockRainSpawnDelay()
    {
        rockRainSpawnDelayCounter--;
        if(rockRainSpawnDelayCounter == 0)
        {
            rockRainSpawnDelayCounter = 200;
            rockRainSpawnOnCooldown = false;
        }
    }

    /**
     * Mantiene la direccion hacia el jugador
     */
    public void lockOnPlayer()
    {
        if(isPlayerAtLeft)
            setImage("Troll_boss.png");
        else
        {
            setImage("Troll_boss.png");
            getImage().mirrorHorizontally();
        }
    }

    /**
     * Gira la imagen para simular movimiento
     */
    public void turnWhileWandering()
    {
        if(speed > 0)
            setImage("Troll_boss.png");
        else
        {
            setImage("Troll_boss.png");
            getImage().mirrorHorizontally();
        }
    }

    /**
     * Hace que el TrollBoss grite al morir
     */
    public void trollBossDeathScream()
    {
        screamTrollBoss.play();
        alreadyScreamed = true;
    }

    /**
     * Vuelve jefe al enemigo
     */
    public void boss()
    {
        screamTrollBoss.setVolume(50);
        this.health = 12;
        isBoss = true;
    }
}