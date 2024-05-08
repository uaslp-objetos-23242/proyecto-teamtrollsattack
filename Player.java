import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Entity
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    // Sobreescudo que tiene al entrar a una nueva sala
    private int armorPoints;
    // Puntos de experiencia para mejorar sus atributos
    private int expPoints;
    // Altura maxima que puede saltar
    private int jumpHeight = 100;
    // Gravedad del jugador
    private int gravity = 0;
    // Sirve para llevar un flujo mas manejable de la gravedad y algunos temporizadores
    private int count = 0;
    // Frames antes de poder volver a atacar
    private int attackDelayTimer = 20;
    // Obligar al jugador a soltar el boton de salto para volver a saltar
    private boolean jumpPressed = false;
    // Determina si se puede atacar o no
    private boolean attackOnCooldown = false;
    // Obliga a que el jugador suelte el boton de ataque para volver a atacar
    private boolean attackPressed = false;
    // Inicia el contador de frames de ataque
    private boolean attackAnimation = false;
    // Frames que dura la animacion de ataque
    private int attackFrames = 10;
    // Estado de invencibilidad del jugador
    private boolean playerInvincible = false;
    // Tiempo que el jugador es invencile despues de recibir daño
    private int invincibilityFrames = 60;
    // Estado de uso del escudo
    private boolean usingShield = false;
    // Checa la direccio que el personaje esta viendo, sirve para la direccion de los sprites
    private boolean facingLeft = false;

    /**
     * Pos el constructor, que mas xd
     */
    public Player()
    {
        // Salud, daño causado, velocidad
        super(3,1,5);
        this.armorPoints = 2;
        this.expPoints = 0;
        scaleDownImage(2, 2);
    }

    public void act()
    {
        debugHud();
        hud();
        nivelateOnFloor();
        increaseGravity();
        count++;
        slideAround();
        fall();
        jump();
        attack();
        useShield();
        if(playerInvincible)
            invincibilityTimer();
        reduceHealth();
        if(attackAnimation)
            playAttackAnimation();
        if(attackOnCooldown)
            attackDelay();
    }

    /**
     * Movimiento casual, izquierda y derecha
     * Obtiene la posicion del personaje y le agrega o resta valor a x para moverse
     */
    public void slideAround()
    {
        int x = getX();
        int y = getY();
        if(Greenfoot.isKeyDown("d") && !usingShield && !attackAnimation)
        {
            setLocation(x + speed, y);
            facingLeft = false;
            moveAnimation();
        }
        if(Greenfoot.isKeyDown("a") && !usingShield && !attackAnimation)
        {
            setLocation(x - speed, y);
            facingLeft = true;
            moveAnimation();
        }
    }

    /**
     * Hace que el jugador caiga por gravedad
     * El count y * 9 en gravity es para tratar de nivelar una caida lenta
     */
    public void fall()
    {
        if(!isOnFloor() && count % 2 == 0)
            setLocation(getX(), getY() + gravity * 9);
        else
            gravity = 0;
    }

    /**
     * Saltar al presionar espacio
     * Antes de saltar revisa que la tecla espacio no este ya presionada y que el personaje este en el suelo
     */
    public void jump()
    {
        if(Greenfoot.isKeyDown("space") && !jumpPressed && isOnFloor())
        {
            setLocation(getX(), getY() - jumpHeight);
            jumpPressed = true;
        }
        if(!Greenfoot.isKeyDown("space"))
            jumpPressed = false;
    }

    /**
     * La gravedad  no puede ser mayor a 20 y solo afecta cuando no esta tocando el suelo
     */
    public void increaseGravity()
    {
        if(gravity < 20 && !isOnFloor())
            gravity++;
    }

    /**
     * Nivela a todos al ras del suelo
     * heredado de forma abstracta de Entity
     */
    public void nivelateOnFloor()
    {
        int x = getX();
        int y = getY();
        if(isOnFloor())
        {
            setLocation(x, y - gravity);
        }
    }

    /**
     * Ataca al presionar j
     * Solo puede atacar si no esta en cooldown, se solto la tecla despues del ataque anterior y la animacion de ataque ya acabo
     */
    public void attack()
    {
        if(Greenfoot.isKeyDown("j") && !attackOnCooldown && !attackPressed && !attackAnimation && isOnFloor())
        {
            if(facingLeft)
            {
                setImage("Link_Ataca_Izquierda.png");
                scaleDownImage(2, 2);
            }
            else
            {
                setImage("Link_Ataca_Derecha.png");
                scaleDownImage(2, 2);
            }
            attackPressed = true;
            attackAnimation = true;
        }
        if(!Greenfoot.isKeyDown("j"))
            attackPressed = false;
    }

    /**
     * Contador para la duracion de la animacion de ataque
     */
    public void playAttackAnimation()
    {
        attackFrames--;
        if(attackFrames == 0)
        {
            setRotation(0);
            attackAnimation = false;
            attackOnCooldown = true;
            attackFrames = 10;
        }
    }

    /**
     * Contador para el cooldown entre ataques
     */
    public void attackDelay()
    {
        //setRotation(0);
        attackDelayTimer--;
        if(attackDelayTimer == 0)
        {
            moveAnimation();
            attackDelayTimer = 20;
            attackOnCooldown = false;
        }
    }

    /**
     * Recude la salud del personaje
     * Unicamente si el jugador no esta invencible ni usando el escudo
     * Despues checa si aun tiene armadura, de ser asi la reduce primero y al terminarse comienza a reducir salud
     */
    public void reduceHealth()
    {
        if(isDamaged() && !playerInvincible && !usingShield)
        {
            if(armorPoints > 0)
            {
                armorPoints--;
                playerInvincible = true;
            }
            else if(this.health > 0)
            {
                this.health--;
                playerInvincible = true;
            }
        }
    }

    /**
     * Revisa si ha sido impactado con alguien o algo de la clase Enemy
     */
    public boolean isDamaged()
    {
        if(isTouching(Enemy.class))
        {
            return true;
        }
        else
            return false;
    }

    /**
     * Temporizador de invencibilidad
     */
    public void invincibilityTimer()
    {
        invincibilityFrames--;
        if(invincibilityFrames == 0)
        {
            playerInvincible = false;
            invincibilityFrames = 60;
        }
    }

    /**
     * Usa el escudo al presionar k
     */
    public void useShield()
    {
        if(Greenfoot.isKeyDown("k"))
        {
            usingShield = true;
            shieldAnimation();
        }
        else
        {
            usingShield = false;
            // Hay que hacer que deje de mostrar la animacion de usar el escudo
        }
    }

    /**
     * Muestra un sprite diferente dependiendo de en que posicion se mueva
     */
    public void moveAnimation()
    {
        if(facingLeft)
        {
            setImage("Link_Izquierda.png");
            scaleDownImage(2, 2);
        }
        else
        {
            setImage("Link_Derecha.png");
            scaleDownImage(2, 2);
        }
    }

    /**
     * Muestra un sprite diferente de uso del escudo dependiendo de en que posicion se mueva
     */
    public void shieldAnimation()
    {
        if(facingLeft)
        {
            setImage("Link_Escudo_Izquierda.png");
            scaleDownImage(2, 2);
        }
        else
        {
            setImage("Link_Escudo_Derecha.png");
            scaleDownImage(2, 2);
        }
    }

    /**
     * Muestra informacion del personaje en pantalla
     */
    public void hud()
    {
        getWorld().showText("health: " + health, 50, 50);
        getWorld().showText("armor: " + armorPoints, 50, 70);
    }

    /**
     * Muestra informacion sobre variables para debuguear
     */
    public void debugHud()
    {
        getWorld().showText("Invincibility timer: " + invincibilityFrames, 200, 50);
        getWorld().showText("Invincibility: " + usingShield, 200, 70);
        getWorld().showText("Facing left: " + facingLeft, 200, 90);
        getWorld().showText("On floor: " + isOnFloor(), 200, 110);
        getWorld().showText("Current gravity: " + gravity, 200, 130);
        getWorld().showText("X pos: " + getX(), 350, 50);
        getWorld().showText("Y pos: " + getY(), 350, 70);
    }
    
    public int getHealth()
    {
        return this.health;
    }
}
