package org.virtualy.test;

import org.virtualy.annotation.RunAsVirtualThread;

public class TestVirtualThread {

    private final Integer x;

    public TestVirtualThread(Integer x){
        this.x = x;
    }

    @RunAsVirtualThread
    public void isPrime(){
        for (int i = 2; i < Math.sqrt(x) + 1; i++){
            if (x % i == 0){
                System.out.println("IS NOT PRIME");
                return;
            }
        }
        System.out.println("IS PRIME");
    }
}
