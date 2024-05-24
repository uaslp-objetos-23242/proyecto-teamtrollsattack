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
        if(isAlive)
        {
            setOriginalPosition();
            checkFalling();
            getDamaged();
            wander(50,50,600);
            checkForPlayerAtLeft();
            if(enemyInvincible)
                enemyInvincibilityTimer();
        }
    }

    /**
     * Inicia el combate con el jugador, cada subclase de enemigo ataca diferente
     */
    public void engage()
    {
        lockOnPlayer();
        if(this.mun>0)
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
        if(isPlayerAtLeft)
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
        if(speed > 0)
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
        mun --;
    }
}
