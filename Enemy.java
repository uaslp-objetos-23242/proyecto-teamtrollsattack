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
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Si es jefe, tebdra atributos especiales como da�o y vida aumentados
    private boolean isBoss = false;

    //Si el jugador se encuentra en el radio del enemigo
    protected boolean isPlayerInSight = false;

    //Guarda las posiciones originales de los enemigos para que patrullen al rededor
    private int originalXPos = -1;
    private int originalYPos = -1;

    public Enemy(int health, int damageDealt, int speed)
    {
        // Salud, da�o causado, velocidad
        super(health,damageDealt,speed);
    }

    public void act()
    {
        // Add your action code here.
    }

    /**
     * Hace que el objeto de la clase se mueva de un lado a otro en un rango determinado
     */
    public void wander()
    {
        lookingForPlayer();
        if(!isPlayerInSight)
        {
            setLocation(getX() + speed, getY());
            if(getX() == originalXPos - 100 || getX() == originalXPos + 100)
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
    public void lookingForPlayer()
    {
        if(playerIsNearby())
            isPlayerInSight = true;
        else 
            isPlayerInSight = false;
    }

    /**
     * Revisa si el jugador se encuentra en un radio determinado
     */
    public boolean playerIsNearby()
    {
        return !getObjectsInRange(200, Player.class).isEmpty();
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

    public void nivelateOnFloor()
    {
        int x = getX();
        int y = getY();
        if(isOnFloor())
        {
            setLocation(x, y - 1);
        }
    }

    /**
     * Elimina al enemigo del mundo al perder toda su salud
     */
    public void despawnOnDeath()
    {

    }

    public void debugHud()
    {
        getWorld().showText("X pos: " + getX(), 700, 50);
        getWorld().showText("Y pos: " + getY(), 700, 70);
        getWorld().showText("Player nerby: " + playerIsNearby(), 700, 90);
        getWorld().showText("Distance from player: " + (getPlayerInfo().getX() - getX()), 700, 110);
    }

}
