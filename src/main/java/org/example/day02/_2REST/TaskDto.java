package org.example.day02._2REST;

public class TaskDto {
    private String name;
    private int age;

    public TaskDto() { }

    public TaskDto( String name, int age ) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
} // class end
