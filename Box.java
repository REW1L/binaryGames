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
public class Box extends Fig
{
    public Box(char map[])
        {
            super();
            this.setRotate(true);
            this.setX((char)4);
            this.setY((char)0);
            byte[] temp = {0b11,0b11,0b0,0b0};
            this.setForm(temp);
        }
}
