import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase engloba todos los metodos y variables que tienen en comun algunos actores
 * Principalmente Player y Enemy
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public abstract class Entity extends Actor
{
    //La entidad unifica aspectos que todos comparte como salud, daño y velocidad, obvio varia por personaje
    private int health;
    private int damageDealt;
    private int speed;

    private int vSpeed = 0;
    private int acceleration = 1;

    //Estado de la entidad, vivo o muerto, no creo se ocupe pero por si acaso
    private boolean isAlive;
    private int cont2;
    public Entity(int health, int damageDealt, int speed)
    {
        this.health = health;
        this.damageDealt = damageDealt;
        this.speed = speed;
        this.isAlive = true;
    }

    /**
     * Act - do whatever the Entity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

    }

    /**
     * Reescala la imagen para hacerla mas pequeña
     * @Param horizontalScaleDown la cantidad que se va a reducir horizontalmente
     * @Param verticalScaleDown la cantidad que se va a reducir verticalmente
     */
    public void scaleDownImage(int horizontalScaleDown, int verticalScaleDown)
    {
        getImage().scale(getImage().getWidth()/horizontalScaleDown, getImage().getHeight()/verticalScaleDown);
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
    
    /**
     * Setters y getters
     */
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    public void setDamageDealt(int damageDealt)
    {
        this.damageDealt = damageDealt;
    }
    
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    public void setVSpeed(int vSpeed)
    {
        this.vSpeed = vSpeed;
    }
    
    public void setAcceleration(int acceleration)
    {
        this.acceleration = acceleration;
    }
    
    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }
    
    public void setCont2(int cont2)
    {
        this.cont2 = cont2;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int getDamageDelt()
    {
        return damageDealt;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public int getVSpeed()
    {
        return vSpeed;
    }
    
    public int getAcceleration()
    {
        return acceleration;
    }
    
    public boolean getIsAlive()
    {
        return isAlive;
    }
    
    public int getCont2()
    {
        return cont2;
    }
}
