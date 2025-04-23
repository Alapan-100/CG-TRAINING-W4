import java.util.*;
abstract class JobRole {
    public abstract String getRoleName();
}
class SoftwareEngineer extends JobRole {
    public String getRoleName() {
        return "Software Engineer";
    }
}
class DataScientist extends JobRole {
    public String getRoleName() {
        return "Data Scientist";
    }
}
class ProductManager extends JobRole {
    public String getRoleName() {
        return "Product Manager";
    }
}
class Resume<T extends JobRole> {
    private String candidateName;
    private T role;
    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public T getRole() {
        return role;
    }
    public void display() {
        System.out.println("Candidate: " + candidateName + ", Role: " + role.getRoleName());
    }
}
class ScreeningSystem {
    public static void screenResumes(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("Screening Resumes:");
        for (Resume<? extends JobRole> r : resumes) {
            r.display();
        }
    }
}
public class ResumeScreeningApp {
    public static void main(String[] args) {
        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        resumes.add(new Resume<>( "Alice", new SoftwareEngineer()));
        resumes.add(new Resume<>( "Bob", new DataScientist()));
        resumes.add(new Resume<>( "Carol", new ProductManager()));
        ScreeningSystem.screenResumes(resumes);
    }
}
