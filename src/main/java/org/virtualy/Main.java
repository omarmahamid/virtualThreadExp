package org.virtualy;


import org.virtualy.core.VirtualThreadClassContainer;
import org.virtualy.core.WrapMethodAsVirtual;
import org.virtualy.test.TestVirtualThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        VirtualThreadClassContainer virtualThreadClassContainer = VirtualThreadClassContainer.getInstance();

        virtualThreadClassContainer.register(TestVirtualThread.class);

        WrapMethodAsVirtual wrapMethodAsVirtual = new WrapMethodAsVirtual(virtualThreadClassContainer);

        wrapMethodAsVirtual.runMethodsInVirtualMode();

        Thread.sleep(1000L);
    }
}