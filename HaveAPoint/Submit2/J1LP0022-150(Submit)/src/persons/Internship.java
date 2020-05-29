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
public class Internship extends Candidate {

    private String major;
    private String semester;
    private String unviversity;

    public Internship() {
        super();
    }

    public Internship(String major, String semester, String unviversity, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.major = major;
        this.semester = semester;
        this.unviversity = unviversity;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUnviversity() {
        return unviversity;
    }

    public void setUnviversity(String unviversity) {
        this.unviversity = unviversity;
    }
    
}
