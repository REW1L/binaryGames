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
public class Char2 extends Fig{
    public Char2(char map[])
        {
            super();
            this.setRotate(true);
            this.setX((char)4);
            this.setY((char)0);
            byte[] temp = {0b11,0b110,0,0};
            this.setForm(temp);
        }
        public void rotation(char map[])
        {
            this.setRotate(!this.getRotate());
            if(this.getRotate())
            {
                this.setY((char)(this.getY()+1));
                byte[] temp = {0b11,0b110,0,0};
                this.setForm(temp);
            }
            else
            {
                this.setY((char)(this.getY()-1));
                byte[] temp = {0b10,0b11,0b1,0b0};
                this.setForm(temp);
            }
        }
}
