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
    private GreenfootSound screamTrollBoss = new GreenfootSound("Troll_Boss_muere.mp3");
    private Goal goal = new Goal();
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
        if(getIsAlive())
        {
            checkFalling();
            checkForPlayerAtLeft();
            wander(200, 200, 250);
            getDamaged();
            if(getEnemyInvincible())
                enemyInvincibilityTimer();
        }
        else if(!getIsAlive() && getIsBoss())
        {
            if(!alreadyScreamed)
                trollBossDeathScream();
            getWorld().addObject(goal, 600,416);
        }
    }

    /**
     * Hace que el objeto de la clase se mueva de un lado a otro en un rango determinado
     * @Param maxLeftDistance Distancia maxima a la que puede moverse el enemigo hacia la izquierda desde su punto de origen
     * @Param maxRightDistance Distancia maxima a la que puede moverse el enemigo hacia la derecha desde su punto de origen
     * @Param detectionRange Es la distancia a la que el enemigo puede llegar a ver al jugador
     */
    public void wander(int maxLeftDistance, int maxRightDistance, int detectionRange)
    {
        setOriginalPosition();
        lookingForPlayer(detectionRange);
        if(!getIsPlayerInSight())
        {
            setLocation(getX() - getSpeed(), getY());
            if(getX() == getOriginalXPos() - maxLeftDistance || getX() == getOriginalXPos() + maxRightDistance || isAtEdge())
            {
                setSpeed(getSpeed() * -1);
                turnWhileWandering();
            }
            setRotation(0);
        }
        else
            engage();
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
            getWorld().addObject(new Stalactite(), getPlayerInfo().getX() - 30, getPlayerInfo().getY() + getImage().getHeight() * -1);
            getWorld().addObject(new Stalactite(), getPlayerInfo().getX() - 15, getPlayerInfo().getY() + getImage().getHeight() * -1);
            getWorld().addObject(new Stalactite(), getPlayerInfo().getX(), getPlayerInfo().getY() + getImage().getHeight() * -1);
            getWorld().addObject(new Stalactite(), getPlayerInfo().getX() + 15, getPlayerInfo().getY() + getImage().getHeight() * -1);
            getWorld().addObject(new Stalactite(), getPlayerInfo().getX() + 30, getPlayerInfo().getY() + getImage().getHeight() * -1);
            rockRainSpawnOnCooldown = true;
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
        if(getIsPlayerAtLeft())
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
        if(getSpeed() > 0)
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
        setHealth(12);
        setIsBoss(true);
    }
}