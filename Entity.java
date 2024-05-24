import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase engloba todos los metodos y variables que tienen en comun algunos actores
 * Principalmente Player y Enemy
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entity extends Actor
{
    /**
     * Act - do whatever the Entity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    //La entidad unifica aspectos que todos comparte como salud, daño y velocidad, obvio varia por personaje
    protected int health;
    protected int damageDealt;
    protected int speed;
    
    protected int vSpeed = 0;
    protected int acceleration = 1;
    
    //Estado de la entidad, vivo o muerto, no creo se ocupe pero por si acaso
    protected boolean isAlive;
    protected int cont2;
    public Entity(int health, int damageDealt, int speed)
    {
        this.health = health;
        this.damageDealt = damageDealt;
        this.speed = speed;
        this.isAlive = true;
    }

    public void act()
    {
        
    }

    /**
     * Reescala la imagen para hacerla mas pequeña
     */
    public void scaleDownImage(int horizontalScaleDown, int verticalScaleDown)
    {
        getImage().scale(getImage().getWidth()/horizontalScaleDown, getImage().getHeight()/verticalScaleDown);
    }

    /**
     * Reescala la imagen para hacerla mas grande
     */
    public void scaleUpImage(int horizontalScaleDown, int verticalScaleDown)
    {
        getImage().scale(getImage().getWidth() * horizontalScaleDown, getImage().getHeight() * verticalScaleDown);
    }
    
    /**
     * Inicia la caida al no estar tocando el suelo
     */
    public void checkFalling()
    {
        if(!onGround())
            fall();
        else
            vSpeed = 0;
    }
    
    /**
     * Hace caer a los objetos
     */
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        vSpeed += acceleration;
    }
    
    /**
     * Revisa si esta tocando el suelo
     */
    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Floor.class);
        return under != null;
    }

    /**
     * Muestra informacion oculta en pantalla para debugear
     */
    public abstract void debugHud();
}
