package org.virtualy.core;

import org.virtualy.test.TestVirtualThread;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WrapMethodAsVirtual {

    private final VirtualThreadClassContainer virtualThreadClassContainer;

    public WrapMethodAsVirtual(VirtualThreadClassContainer virtualThreadClassContainer) {
        this.virtualThreadClassContainer = virtualThreadClassContainer;
    }


    public void runMethodsInVirtualMode(){
        virtualThreadClassContainer.getVirtualMethods()
                .forEach(
                        method -> createVirtualThreadForMethod(method, new TestVirtualThread(9))
                );
    }


    public Thread createVirtualThreadForMethod(Method method, Object obj) {

        return Thread.ofVirtual()
                .start(
                        () -> {
                            try {
                                method.invoke(obj);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
    }

}
