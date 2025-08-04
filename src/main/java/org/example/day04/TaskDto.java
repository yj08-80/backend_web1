package org.example.day04;

public class TaskDto { // class start
    // 멤버변수 수정
    private String name;
    private int age;


    // 생성자
    public TaskDto(String name, int age) {
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

    // toString
    @Override
    public String toString() {
        return "TaskDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
} // class end
