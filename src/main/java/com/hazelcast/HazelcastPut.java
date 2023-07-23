package com.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Random;

public class HazelcastPut {

    public static void main(String[] args) {
        
    	HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        IMap<Object, Object> map = hazelcastInstance.getMap("numbers");
        Random rand = new Random();

        long startTimePut20k = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            map.put(i, rand.nextInt(100000));
        }
        long endTimePut20k = System.currentTimeMillis();
        System.out.println("Time taken to put 20000 random numbers with Hazelcast: " + (endTimePut20k - startTimePut20k) + " ms");

        long startTimePut100k = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            map.put(i, rand.nextInt(100000));
        }
        long endTimePut100k = System.currentTimeMillis();
        System.out.println("Time taken to put 100000 random numbers with Hazelcast: " + (endTimePut100k - startTimePut100k) + " ms");

        hazelcastInstance.shutdown();
    }
}
