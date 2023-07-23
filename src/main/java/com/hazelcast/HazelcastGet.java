package com.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Random;

public class HazelcastGet {

    public static void main(String[] args) {
        
    	HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        IMap<Object, Object> map = hazelcastInstance.getMap("numbers");
        Random random = new Random();

        long startTimeGet20k = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            int randomKey = random.nextInt(20000);
            map.get(randomKey);
        }
        long endTimeGet20k = System.currentTimeMillis();
        System.out.println("Time taken to get 20000 random numbers with Hazelcast: " + (endTimeGet20k - startTimeGet20k) + " ms");

        long startTimeGet100k = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            int randomKey = random.nextInt(100000);
            map.get(randomKey);
        }
        long endTimeGet100k = System.currentTimeMillis();
        System.out.println("Time taken to get 100000 random numbers with Hazelcast: " + (endTimeGet100k - startTimeGet100k) + " ms");

        hazelcastInstance.shutdown();
    }
}
