import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa una instancia de TrollGeneral
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class TrollGeneral extends Enemy
{
    private int slashSpawnDelayCounter = 130;
    private boolean slashSpawnOnCooldown = false;
    public TrollGeneral()
    {
        super(3,2,4);
    }

    /**
     * Act - do whatever the TrollGeneral wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(getIsAlive())
        {
            checkFalling();
            checkForPlayerAtLeft();
            wander(50, 50, 100);
            getDamaged();
            if(getEnemyInvincible())
                enemyInvincibilityTimer();
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
        spawnSlash();
        if(slashSpawnOnCooldown)
            slashSpawnDelay();
    }

    /**
     * Mantiene la direccion hacia el jugador
     */
    public void lockOnPlayer()
    {
        if(getIsPlayerAtLeft())
            setImage("Troll_general.png");
        else
        {
            setImage("Troll_general.png");
            getImage().mirrorHorizontally();
        }
    }

    /**
     * Gira la imagen para simular movimiento
     */
    public void turnWhileWandering()
    {
        if(getSpeed() > 0)
            setImage("Troll_general.png");
        else
        {
            setImage("Troll_general.png");
            getImage().mirrorHorizontally();
        }
    }

    /**
     * Hace aparecer un corte
     */
    public void spawnSlash()
    {
        if(!slashSpawnOnCooldown)
        {
            if(getIsPlayerAtLeft())
                getWorld().addObject(new Slash(true), getX(), getY());
            else
                getWorld().addObject(new Slash(false), getX(), getY());
            slashSpawnOnCooldown = true;
        }
    }

    /**
     * Un delay entre cortes creados
     */
    public void slashSpawnDelay()
    {
        slashSpawnDelayCounter--;
        if(slashSpawnDelayCounter == 0)
        {
            slashSpawnDelayCounter = 130;
            slashSpawnOnCooldown = false;
        }
    }
}
