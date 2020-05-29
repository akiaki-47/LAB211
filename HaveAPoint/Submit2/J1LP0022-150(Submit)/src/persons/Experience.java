/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

/**
 *
 * @author Admin
 */
public class Experience extends Candidate {

    private int yearExperience;
    private String professionSkill;

    public Experience() {
        super();
    }

    public Experience(int yearExperience, String professionSkill, String id, String firstName, String lastName, 
            int birthDate, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.yearExperience = yearExperience;
        this.professionSkill = professionSkill;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getProfessionSkill() {
        return professionSkill;
    }

    public void setProfessionSkill(String professionSkill) {
        this.professionSkill = professionSkill;
    }

}
