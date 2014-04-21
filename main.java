/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;


/**
 *
 * @author Rew1L
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    //static variables for all program
    
    static char[] map = new char[20];
    static int points;
    static char delay;
    static boolean start;
    static Fig fg;
    static MyConsole mc = new MyConsole(); //like console but for tetris (need to change this shit)
    static boolean a;
    
    
    public static void main(String[] args) {
        
        //define variables
        
        for(int i = 0; i<20; i++) //make good map on start
            map[i]=0;
        points = 0;
        a = true;
        start = true;
        fg = null; //
        
        //for fun
        
        if(args.length>=1)
        {
            if(args[0].equals("hardcore"))
                delay = 50;
            if(args[0].equals("normal"))
                delay = 150;
            if(args[0].equals("easy"))
                delay = 300;
        }
        else
        {
            delay = 150;
        }
        
        //main cycle
        
        while(a)
        {
            if(start) //new figure or not
            {
                byte rand = (byte)(Math.random()*6);
                
                switch(rand) //for choose figures
                {
                    case 0: fg = new Stick(map);break;
                    case 1: fg = new Box(map);break;
                    case 2: fg = new CharS(map);break;
                    case 3: fg = new Char2(map);break;
                    case 4: fg = new CharL(map);break;
                    case 5: fg = new CharG(map);break;
                }
                if(!fg.check(map)) //Player really can lose 
                {
                    mc.seeMap(true);
                    a = !a;
                    break;
                }
                else
                {
                    fg.addOnMap(map);
                }
                start = !start;
            }
            else
            {
                try 
                {
                    Thread.sleep(delay);
                } 
                catch (InterruptedException ex) 
                {
                    System.out.println("Chto - to poshlo ne tak");
                }
                fg.removeFromMap(map);
                fg.incY();
                if(fg.check(map))
                    fg.addOnMap(map);
                else
                {
                    fg.decY();
                    fg.addOnMap(map);
                    start = !start;
                    for(int i = 0; i<20; i++)
                    {
                        if(map[i]==65535)
                        {
                            for(int k = i; k>0; k--)
                            {
                                map[k]=map[k-1];
                            }
                            points+=1;
                        }
                    }
                }
            }
            mc.seeMap(false);
        }
    }
    public static void vlevo()
    {
        fg.removeFromMap(map);
        if(fg.getX()>0)
            fg.decX();
        if(fg.check(map))
        {
            fg.addOnMap(map);
            mc.seeMap(false);
        }
        else
        {
            fg.incX();
            fg.addOnMap(map);
        }
    }
    public static void rotate()
    {
        fg.removeFromMap(map);
        fg.rotation(map);
        if(!fg.check(map))
        {
            for(int i = 0; i<3; i++)
                fg.rotation(map);
        }
        fg.addOnMap(map);
        mc.seeMap(false);
    }
    public static void vpravo()
    {
        fg.removeFromMap(map);
        if(fg.getX()<15)
            fg.incX();
        if(fg.check(map))
        {
            fg.addOnMap(map);
            mc.seeMap(false);
        }
        else
        {
            fg.decX();
            fg.addOnMap(map);
        }
    }
}
