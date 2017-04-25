package com.mogikanensoftware.rx.creation;

import java.util.Arrays;

import rx.Observable;

public class SimpleCreationApp 
{
    public static void main( String[] args )
    {
        Observable<Integer> observable = null;
        System.out.println("Observable creation from an array of 2 integers");
        observable = Observable.from(new Integer[]{Integer.valueOf(42),Integer.valueOf(43)});
        observable.subscribe((i)->{
        	System.out.println(i);
        });
        
        System.out.println("Observable creation from a list of integers");
        observable = Observable.from(Arrays.asList(22,34,56,77));
        observable.subscribe((i)->{
        	System.out.println(i);
        });
        System.exit(0);
    }
}
