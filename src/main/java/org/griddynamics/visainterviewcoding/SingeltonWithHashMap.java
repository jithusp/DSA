package org.griddynamics.visainterviewcoding;

import java.util.HashMap;

public class SingeltonWithHashMap {

        private SingeltonWithHashMap instance;
        private HashMap<Integer,Integer> test;

        private SingeltonWithHashMap() {
            this.test = new HashMap<>();
        }
        public SingeltonWithHashMap getInstance(){
            if(instance==null){
                synchronized (this){
                    if(instance==null){
                        instance=new SingeltonWithHashMap();
                    }
                                    }
            }
            return instance;
        }
        public void put(Integer key, Integer value){
            synchronized (test){
                test.put(key,value);
            }
        }
        public Integer get(Integer key){
            synchronized (test){
                return test.get(key);
            }
        }



    }

