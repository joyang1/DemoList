/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test2;

/**
 *
 * @author 挺
 */
public class Start {
    public static void main(String[] args) {
        Clock c = new Clock();
        Xiaoming m = new Xiaoming(c);
        Thread ct = new Thread(c);
        Thread mt = new Thread(m);
        mt.setDaemon(true);
        ct.start();
        mt.start();
    }
}
