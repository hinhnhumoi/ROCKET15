package com.company.backend;

import com.company.entity.CPU;
import com.company.entity.Car;

import java.util.Calendar;


public class Exercise3 {
    public static void Q1 (){
        CPU cpu =new CPU(100);
        CPU.Processor processor = cpu.new Processor();
        CPU.Ram ram = cpu.new Ram();
        System.out.println(processor.getCache());
        System.out.println(ram.getClockSpeed());
    }
    public static void Q2 () {
        Car car = new Car("Mazda","8WD");
        Car.Engine engine = car.new Engine();
        engine.setEngineType("Crysler");
        System.out.println("Xe: "+ car.getName()+ " " + car.getType());
        System.out.println("Loại động cơ: "+engine.getEngineType());
    }
}
