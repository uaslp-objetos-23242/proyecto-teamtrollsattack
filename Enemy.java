import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Esta clase engloba a todo lo que puede resultar dañino para el jugador
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class Enemy extends Entity
{
    private int mun, band;
    //Si es jefe, tebdra atributos especiales como daño y vida aumentados
    private boolean isBoss = false;

    //Si el jugador se encuentra en el radio del enemigo
    private boolean isPlayerInSight = false;
    private boolean isPlayerAtLeft;

    //Guarda las posiciones originales de los enemigos para que patrullen al rededor
    private int originalXPos = -1;
    private int originalYPos = -1;

    private boolean enemyInvincible = false;
    // Tiempo que el jugador es invencile despues de recibir daño
    private int enemyInvincibilityFrames = 30;

    public Enemy(int health, int damageDealt, int speed)
    {
        super(health,damageDealt,speed);
        int band=0, cont=0;
        // Salud, daño causado, velocidad

    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

    }

    /**
     * Regresa true si el jugador esta cerca y false si no
     * @Param detectionRange Es la distancia a la que el enemigo puede llegar a ver al jugador
     */
    public void lookingForPlayer(int detectionRange)
    {
        if(playerIsNearby(detectionRange))
            isPlayerInSight = true;
        else 
            isPlayerInSight = false;
    }

    /**
     * Revisa si el jugador esta a la derecha o a la izquierda en base a su posicion
     */
    public void checkForPlayerAtLeft()
    {
        if(getPlayerInfo().getX() - getX() <= 0)
            isPlayerAtLeft = true;
        else
            isPlayerAtLeft = false;
    }

    /**
     * Revisa si el jugador se encuentra en un radio determinado
     * @Param detectionRange Es la distancia a la que el enemigo puede llegar a ver al jugador
     */
    public boolean playerIsNearby(int detectionRange)
    {
        if(!getObjectsInRange(detectionRange, Player.class).isEmpty() && (getPlayerInfo().getY() >= getY() - 165 && getPlayerInfo().getY() <= getY() + 165))
            return true;
        else
            return false;
    }

    /**
     * Adquiere una copia del jugador para obtener datos relevantes
     */
    public Player getPlayerInfo()
    {
        return getWorld().getObjects(Player.class).get(0);
    }

    /**
     * Almacena la posicion original del enemigo
     */
    public void setOriginalPosition()
    {
        if(originalXPos == -1 || originalYPos == -1)
        {
            originalXPos = getX();
            originalYPos = getY();
        }
    }

    /**
     * Elimina al enemigo del mundo al perder toda su salud
     */
    public void despawnOnDeath()
    {
        scaleDownImage(10, 10);
        getImage().setTransparency(0);
        getPlayerInfo().increaseWorldKillCount();
        setLocation(0, 0);
    }

    /**
     * Revisa si el enemigo recibio daño
     */
    public void getDamaged()
    {   
        //Actor player = getOneObjectAtOffset(0, 0, Player.class);
        if(isTouching(Player.class) && getPlayerInfo().getAttackAnimation() && getHealth() >= 1 && !enemyInvincible)
        {
            setHealth(getHealth() - 1);
            enemyInvincible = true;
        }
        if(getHealth() < 1)
        {
            setIsAlive(false);
            despawnOnDeath();
        }
    }

    /**
     * Temporizador del enemigo para que no reciba daño
     */
    public void enemyInvincibilityTimer()
    {
        enemyInivicibilityIndicator();
        enemyInvincibilityFrames--;
        if(enemyInvincibilityFrames == 0)
        {
            enemyInvincible = false;
            enemyInvincibilityFrames = 30;
        }
    }

    /**
     * Da un efecto de parpadeo al enemigo al ser dañado
     */
    public void enemyInivicibilityIndicator()
    {
        if(enemyInvincibilityFrames % 3 == 0 && enemyInvincible)
            getImage().setTransparency(100);
        else
            getImage().setTransparency(255);
    }

    /**
     * Muestra datos ocultos del juego
     */
    public void debugHud()
    {
        getWorld().showText("X pos: " + getX(), 700, 50);
        getWorld().showText("Y pos: " + getY(), 700, 70);
        //getWorld().showText("Player nerby: " + playerIsNearby(200), 700, 90);
        getWorld().showText("Distance from player: " + (getPlayerInfo().getX() - getX()), 700, 110);
        getWorld().showText("Player at left: " + isPlayerAtLeft, 700, 130);
        getWorld().showText("Enemy health: " + getHealth(), 700, 150);
        getWorld().showText("Original X pos: " + originalXPos, 900, 130);
        getWorld().showText("Original Y pos: " + originalYPos, 900, 150);
    }

    public void Recargar()
    {
        if (this.mun<1 && getCont2() % 100 == 0)
            this.mun=1;
        setCont2(getCont2() + 1);
    }
    
    /**
     * Setters y getters
     */
    
    public void setMun(int mun)
    {
        this.mun = mun;
    }
    
    public void setBand(int band)
    {
        this.band = band;
    }
    
    public void setIsBoss(boolean isBoss)
    {
        this.isBoss = isBoss;
    }
    
    public void setIsPlayerInSight(boolean isPlayerInSight)
    {
        this.isPlayerInSight = isPlayerInSight;
    }
    
    public void setIsPlayerAtLeft(boolean isPlayerAtLeft)
    {
        this.isPlayerAtLeft = isPlayerInSight;
    }
    
    public void setOriginalXPos(int originalXPos)
    {
        this.originalXPos = originalXPos;
    }
    
    public void setOriginalYPos(int originalYPos)
    {
        this.originalYPos = originalYPos;
    }
    
    public void setEnemyInvincible(boolean enemyInvincible)
    {
        this.enemyInvincible = enemyInvincible;
    }
    
    public void setEnemyInvincibilityFrames(int enemyInvincibilityFrames)
    {
        this.enemyInvincibilityFrames = enemyInvincibilityFrames;
    }
    
    public int getMun()
    {
        return mun;
    }
    
    public int getBand()
    {
        return band;
    }
    
    public boolean getIsBoss()
    {
        return isBoss;
    }
    
    public boolean getIsPlayerInSight()
    {
        return isPlayerInSight;
    }
    
    public boolean getIsPlayerAtLeft()
    {
        return isPlayerAtLeft;
    }
    
    public int getOriginalXPos()
    {
        return originalXPos;
    }
    
    public int getOriginalYPos()
    {
        return originalYPos;
    }
    
    public boolean getEnemyInvincible()
    {
        return enemyInvincible;
    }
    
    public int getEnemyInvincibilityFrames()
    {
        return enemyInvincibilityFrames;
    }
}

