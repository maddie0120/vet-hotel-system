package hva.employee;

import java.io.Serializable;

import hva.seasons.Season;


public abstract class Employee implements Serializable {
    
    private String _id;
    private String _name;   


    public Employee(String id, String name) {
        _id = id;
        _name = name;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public abstract double getEmployeeSatisfaction(Season s);
    
}