package com.mogikanensoftware.rx.simple_creation;

import rx.Observable;

public class App 
{
    public static void main( String[] args )
    {
        Observable<Integer> observable = null;
        System.out.println("Observable creation from an array of 2 integers");
        observable = Observable.from(new Integer[]{Integer.valueOf(42),Integer.valueOf(43)});
        observable.subscribe((i)->{
        	System.out.println(i);
        });
    }
}
