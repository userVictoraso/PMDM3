package com.example.pareja_ramirez_victor_datos.Ejercicio2.Alarm;

public class Alarm {
    int time;
    String desc;
    String sound;

    public Alarm(int time, String desc, String sound) {
        this.time = time;
        this.desc = desc;
        this.sound = sound;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
