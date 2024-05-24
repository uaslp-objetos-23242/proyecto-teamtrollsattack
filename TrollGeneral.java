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
        if(isAlive)
        {
            checkFalling();
            checkForPlayerAtLeft();
            wander(100, 100, 200);
            getDamaged();
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
        spawnSlash();
        if(slashSpawnOnCooldown)
            slashSpawnDelay();
    }

    /**
     * Mantiene la direccion hacia el jugador
     */
    public void lockOnPlayer()
    {
        if(isPlayerAtLeft)
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
        if(speed > 0)
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
            if(isPlayerAtLeft)
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
