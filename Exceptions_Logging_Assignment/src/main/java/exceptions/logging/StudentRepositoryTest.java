package exceptions.logging;
import exceptions.logging.Exceptions.StudentException;
import exceptions.logging.Exceptions.InvalidDateOfBirthException;
import java.time.LocalDate;
import java.util.List;

public class StudentRepositoryTest {
    public static void main(String[] args) {
        StudentRepository studentRepository=new StudentRepository();
        Student student1 = new Student("John", "Doe", LocalDate.of(2000, 5, 15), "m", "12345");
        Student student2 = new Student("Jane", "Smith", LocalDate.of(2002, 8, 20), "f", "67890");
        Student student3 = new Student("Marco", "Reus", LocalDate.of(2001, 9, 21), "m", "65890");

        try {
            studentRepository.addStudent(student1);
            studentRepository.addStudent(student2);
            studentRepository.addStudent(student3);
        } catch (StudentException e) {
            throw new RuntimeException(e);
        }

        try{
            System.out.println(studentRepository.retrieveByAge(21));
        }
        catch (StudentException e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println(studentRepository.listBy("birthday"));
        }
        catch (StudentException e){
            System.out.println(e.getMessage());
        }
        try{
            studentRepository.deleteStudent("00000");
        }
        catch (StudentException e){
            e.getMessage();
        }
        try {
            student1.setDateOfBirth(LocalDate.of(1899,1,1));

        } catch (InvalidDateOfBirthException e) {
            System.out.println(e.getMessage());
        }

    }
}
