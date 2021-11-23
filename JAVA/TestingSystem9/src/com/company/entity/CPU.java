package com.company.entity;

public class CPU {
    private int price;

    public CPU(int price) {
        this.price = price;
    }

    public class Processor {
        public int coreAmount;
        public String manufacture;
        public double getCache() {
            return 4.3;
        }
    }

    public class Ram {
        public int memory;
        public String manufacture;
        public double getClockSpeed() {
            return 5.5;
        }
    }
}