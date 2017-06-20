/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test3;

/**
 *帅哥美女之间的对话！
 * @author 挺
 */
public class test {
    public static void main(String[] args) {
        Asker ask = new Asker("范冰冰");
        Answer ans = new Answer("杨挺",ask);
        Thread kt = new Thread(ask);
        Thread st = new Thread(ans);
        st.setDaemon(true);
        kt.start();
        st.start();
    }
}
