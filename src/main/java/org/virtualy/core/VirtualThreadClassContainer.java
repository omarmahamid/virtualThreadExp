package org.virtualy.core;

import org.virtualy.annotation.RunAsVirtualThread;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VirtualThreadClassContainer {


    private final List<Method> virtualMethods;
    private static VirtualThreadClassContainer instance;

    private VirtualThreadClassContainer(){
        this.virtualMethods = new ArrayList<>();
    }

    public static VirtualThreadClassContainer getInstance(){
        if (instance == null){
            instance = new VirtualThreadClassContainer();
        }
        return instance;
    }


    public void register(Class<?> clazz){
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(RunAsVirtualThread.class))
                .forEach(
                        virtualMethods::add
                );
    }


    public List<Method> getVirtualMethods(){
        return virtualMethods;
    }
}
