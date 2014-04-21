/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Rew1L
 */
public class MyConsole extends JFrame
{
    static JTextArea txtIO;
    public MyConsole()
    {
        super("Tetris");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(230, 345);
        this.setVisible(true);
        this.setResizable(false);
        txtIO = new JTextArea();
        txtIO.setSize(this.getWidth(), this.getHeight());
        txtIO.setEditable(false);
        txtIO.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP)
                    Main.rotate();
                if(e.getKeyCode()==KeyEvent.VK_DOWN)
                    Main.delay = 50;
                if(e.getKeyCode()==KeyEvent.VK_LEFT) //left
                    Main.vlevo();
                else if(e.getKeyCode()==KeyEvent.VK_RIGHT) //right
                    Main.vpravo();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_DOWN)
                    Main.delay = 150;
            }
        });
        this.add(txtIO);
        txtIO.requestFocus();
    }
    
    public static void seeMap(boolean end)
    {
        String str = "";
        for(int i = 0; i< Main.map.length; i++)
        {
            if(end && (i==4))
            {
                str+="\r\n                  Game over\r\n";
                str+="             Your score: ";
                str+=Main.points;
                str+=" pts.\r\n\n";
                i+=4;
            }
            str +="<! ";
            for(int g = 1; g<65535; g*=2)
            {
                if(((int)Main.map[i]&(g))!=0)
                    str+="1 ";
                else
                    str+="   ";
            }
            str+="!>\n";
        }
        txtIO.setText(str);
    }
}
