import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es una instancia del TrollMountain
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class MountainTroll extends Enemy
{
    private int waveSpawnDelayCounter = 150;
    private boolean waveSpawnOnCooldown = false;
    public MountainTroll()
    {
        super(5,3,1);
    }

    /**
     * Act - do whatever the MountainTroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(getIsAlive())
        {
            checkFalling();
            checkForPlayerAtLeft();
            wander(200, 200, 200);
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
        spawnShockWaves();
        if(waveSpawnOnCooldown)
            waveSpawnDelay();
    }

    /**
     * Mantiene la direccion hacia el jugador
     */
    public void lockOnPlayer()
    {
        if(getIsPlayerAtLeft())
            setImage("Mountain_Troll.png");
        else
        {
            setImage("Mountain_Troll.png");
            getImage().mirrorHorizontally();
        }
    }

    /**
     * Gira la imagen para simular movimiento
     */
    public void turnWhileWandering()
    {
        if(getSpeed() > 0)
            setImage("Mountain_Troll.png");
        else
        {
            setImage("Mountain_Troll.png");
            getImage().mirrorHorizontally();
        }
    }

    /**
     * Hace aparecer ondas de choque con las que ataca
     */
    public void spawnShockWaves()
    {
        if(!waveSpawnOnCooldown)
        {
            getWorld().addObject(new Shockwave(true), getX(), getY() + getImage().getHeight()/2 - 20);
            getWorld().addObject(new Shockwave(false), getX(), getY() + getImage().getHeight()/2 - 20);
            waveSpawnOnCooldown = true;
        }
    }

    /**
     * Un pequeño delay entre ondas de choque
     */
    public void waveSpawnDelay()
    {
        waveSpawnDelayCounter--;
        if(waveSpawnDelayCounter == 0)
        {
            waveSpawnDelayCounter = 150;
            waveSpawnOnCooldown = false;
        }
    }
}
