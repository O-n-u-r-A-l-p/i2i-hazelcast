package com.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastGet {
	
    public static void main(String[] args) throws InterruptedException {

    	HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IMap<Object,Object> map = client.getMap("map");
        
        int i = 0;
        long start = System.nanoTime();
        while(i<20000){
            map.get(i);
            i++;}
        
        CalculateTime time = new CalculateTime();
        time.calculateTime(start);
    }
}
