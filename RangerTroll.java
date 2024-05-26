import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa una instancia de RangerTroll
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class RangerTroll extends Enemy
{
    public RangerTroll()
    {
        super(1,1,1);
        //scaleDownImage(2, 2);
    }

    /**
     * Act - do whatever the RangerTroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(getIsAlive())
        {
            setOriginalPosition();
            checkFalling();
            getDamaged();
            wander(50,50,600);
            checkForPlayerAtLeft();
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
        if(getMun() > 0)
        {
            Dispara();
        }

        if(10000%10==0)
        {
            Recargar();
        }
    }

    /**
     * Mantiene la direccion hacia el jugador
     */
    public void lockOnPlayer()
    {
        if(getIsPlayerAtLeft())
            setImage("Troll_ranger3.png");
        else
        {
            setImage("Troll_ranger3.png");
            getImage().mirrorHorizontally();
        }
    }

    /**
     * Gira la imagen para simular movimiento
     */
    public void turnWhileWandering()
    {
        if(getSpeed() > 0)
            setImage("Troll_ranger3.png");
        else
        {
            setImage("Troll_ranger3.png");
            getImage().mirrorHorizontally();
        }
    }

    /**
     * Crea proyectiles
     */
    public void Dispara()
    {
        getWorld().addObject(new Rock(), getX(), getY());
        setMun(getMun() - 1);
    }
}
