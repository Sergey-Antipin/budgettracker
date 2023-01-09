package com.example.budgettracker.model;

import java.util.Set;

public class Family {

    private Set<User> familyMembers;
    public Family() {}

    public Family(Set<User> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public Set<User> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Set<User> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public boolean addFamilyMember(User familyMember) {
        return familyMembers.add(familyMember);
    }

    public boolean removeFamilyMember(User familyMember) {
        return familyMembers.remove(familyMember);
    }

}
