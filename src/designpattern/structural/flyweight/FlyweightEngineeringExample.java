package designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Random;

interface Employee {
    public void assignSkill(String skill);
    public void task();
}

class Developer implements Employee {

    private final String JOB; // intrinsic property
    private String skill; // extrinsic property

    public Developer() {
        JOB = "Fix the issue"; // intrinsic property will be same for all
    }

    @Override
    public void assignSkill(String skill) { // extrinsic property will get assigned everytime to object.
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
    }

}

class Tester implements Employee {

    private final String JOB; // intrinsic property

    private String skill; // extrinsic property

    public Tester() {
        JOB = "Test the issue"; // intrinsic property
    }

    @Override
    public void assignSkill(String skill) { // extrinsic property
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
    }

}

/**
 * Not creating different developer and tester object.
 * Instead, creating it once and using it for different cases where intrinsic property will be same.
 * And we will just change extrinsic property through a method.
 * */
class EmployeeFactory {
    private static HashMap<String, Employee> m = new HashMap<String, Employee>();

    public static Employee getEmployee(String type) {
        Employee p = null;
        if(m.get(type) != null) {
            p = m.get(type);
        } else {
            switch(type) {
                case "Developer":
                    System.out.println("Developer Created");
                    p = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    p = new Tester();
                    break;
                default:
                    System.out.println("No Such Employee");
            }

            m.put(type, p);
        }
        return p;
    }
}

public class FlyweightEngineeringExample {

    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", ".Net", "Python"};

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            Employee e = EmployeeFactory.getEmployee(getRandEmployee());

            e.assignSkill(getRandSkill());

            e.task();
        }
    }

    public static String getRandEmployee() {
        Random r = new Random();
        int randInt = r.nextInt(employeeType.length);

        return employeeType[randInt];
    }

    public static String getRandSkill() {
        Random r = new Random();
        int randInt = r.nextInt(skills.length);

        return skills[randInt];
    }

}
