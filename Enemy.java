import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Entity
{
    int mun, band;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Si es jefe, tebdra atributos especiales como daño y vida aumentados
    private boolean isBoss = false;

    //Si el jugador se encuentra en el radio del enemigo
    protected boolean isPlayerInSight = false;
    protected boolean isPlayerAtLeft;

    //Guarda las posiciones originales de los enemigos para que patrullen al rededor
    private int originalXPos = -1;
    private int originalYPos = -1;

    public Enemy(int health, int damageDealt, int speed)
    {
        super(health,damageDealt,speed);
        int band=0, cont=0;
        // Salud, daño causado, velocidad
        
    }

    public void act()
    {
        
    }

    /**
     * Hace que el objeto de la clase se mueva de un lado a otro en un rango determinado
     */
    public void wander(int maxLeftDistance, int maxRightDistance, int detectionRange)
    {
        setOriginalPosition();
        lookingForPlayer(detectionRange);
        if(!isPlayerInSight)
        {
            setLocation(getX() + speed, getY());
            if(getX() == originalXPos - maxLeftDistance || getX() == originalXPos + maxRightDistance || isAtEdge())
            {
                speed *= -1;
            }
            setRotation(0);
        }
        else

            engage();
    }

    /**
     * Inicia el combate con el jugador, cada subclase de enemigo ataca diferente
     */
    public abstract void engage();

    /**
     * Regresa true si el jugador esta cerca y false si no
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
     */
    public boolean playerIsNearby(int detectionRange)
    {
        return !getObjectsInRange(detectionRange, Player.class).isEmpty();
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
        scaleDownImage(20, 20);
        setLocation(0, 0);
    }

    public void getDamaged()
    {   
        Actor player = getOneObjectAtOffset(0, 0, Player.class);
        if(player != null && getPlayerInfo().getAttackAnimation() && this.health > 0)
            this.health--;
        if(this.health < 1)
        {
            isAlive = false;
            despawnOnDeath();
        }
    }

    public void debugHud()
    {
        getWorld().showText("X pos: " + getX(), 700, 50);
        getWorld().showText("Y pos: " + getY(), 700, 70);
        //getWorld().showText("Player nerby: " + playerIsNearby(200), 700, 90);
        getWorld().showText("Distance from player: " + (getPlayerInfo().getX() - getX()), 700, 110);
        getWorld().showText("Player at left: " + isPlayerAtLeft, 700, 130);
        getWorld().showText("Enemy health: " + this.health, 700, 150);
        getWorld().showText("Original X pos: " + originalXPos, 900, 130);
        getWorld().showText("Original Y pos: " + originalYPos, 900, 150);
    }
    
    public void Recargar()
    {
        if (this.mun<1&&cont2%100==0)
            this.mun=1;
        cont2++;
    }
}
    
