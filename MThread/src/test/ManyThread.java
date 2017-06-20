/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author 挺
 */
public class ManyThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person p = new Person();
        
        Thread t1 = new Thread(new pro(p));
        Thread t2 = new Thread(new Cust(p));
        
        t1.start();
        t2.start();
    }
    
}
