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
//生产者类
public  class pro implements Runnable {
    private  Person p = null;
    public pro(Person p){
        this.p = p;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if(i%2==0){
                p.set("joyang", "software engineer");
            }else{
                p.set("ting.joyang.wang","web");
            }
        }
    }

}
