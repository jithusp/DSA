package org.griddynamics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromEmployeeIDAndMaintainOrder {
    class Employee{
        int id;
        String name;
        String designation;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public Employee(int id, String name, String designation) {
            this.id = id;
            this.name = name;
            this.designation = designation;
        }
    }
     List<Employee> removeDuplicates(List<Employee>test){
        Set<Integer> seenIds=new HashSet<>();
        List<Employee>ans=new ArrayList<>();
        for(Employee e:test){
            if(!seenIds.contains(e.getId())){
                seenIds.add(e.getId());
                ans.add(e);
            }
        }
        return ans;
     }

}
