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
//消费者
public class Cust implements Runnable{
    private  Person p = null;
    public Cust(Person p){
        this.p = p;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(p.get());
        }
    }
}
