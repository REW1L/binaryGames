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
public class Fig {
    
        private char x,y;
        private byte[] form;
        private boolean rotate;
        public void rotation(char map[]){}
        public void addOnMap(char map[])
        {
            if(map.length>=y+1)
                map[y] += (Math.pow(2,x))*form[0];
            if(map.length>=y+2)
                map[y+1] += (Math.pow(2,x))*form[1];
            if(map.length>=y+3)
                map[y+2] += (Math.pow(2,x))*form[2];
            if(map.length>=y+4)
                map[y+3] += (Math.pow(2,x))*form[3];
        }
        public boolean check(char map[])
        {
            if(((char)(Math.pow(2,x))*form[0]>65535)||((char)(Math.pow(2,x))*form[1]>65535)||((char)(Math.pow(2,x))*form[2]>65535)||((char)(Math.pow(2,x))*form[3]>65535))
                return false;
            if(x<0)
                return false;
            if(y<0)
                return false;
            boolean temp = false;
            byte yPlus = 0;
            for(int i = 0; i<4; i++)
            {
                if(form[i]!=0)
                    yPlus++;
            }
            if(map.length<y+yPlus)
                return false;
            for(int i = 0; i<yPlus;i++)
            {
                if(map.length-1>=y+i)
                {
                    temp |= ((map[y+i]&((char)(Math.pow(2,x))*form[i]))!=0);
                }
                else
                    return false;
            }
            return !temp;
        }
        public void removeFromMap(char map[])
        {
            if(map.length>=y+1)
                map[y] -= (Math.pow(2,x))*form[0];
            if(map.length>=y+2)
                map[y+1] -= (Math.pow(2,x))*form[1];
            if(map.length>=y+3)
                map[y+2] -= (Math.pow(2,x))*form[2];
            if(map.length>=y+4)
                map[y+3] -= (Math.pow(2,x))*form[3];
        }
        void decY()
        {
            --this.y;
        }
        void incY()
        {
            ++this.y;
        }
        void incX()
        {
            ++this.x;
        }
        void decX()
        {
            --this.x;
        }
        byte[] getForm()
        {
            return form;
        }
        void setForm(byte[] newForm)
        {
            form = newForm;
        }
        boolean getRotate()
        {
            return rotate;
        }
        void setRotate(boolean newRotate)
        {
            rotate = newRotate;
        }
        char getX()
        {
            return x;
        }
        void setX(char newX)
        {
            x = newX;
        }
        char getY()
        {
            return y;
        }
        void setY(char newY)
        {
            y = newY;
        }
}
