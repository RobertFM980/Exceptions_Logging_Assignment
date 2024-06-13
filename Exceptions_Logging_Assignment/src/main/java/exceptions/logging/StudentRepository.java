package exceptions.logging;
import exceptions.logging.Exceptions.StudentException;

import java.util.*;
import java.util.logging.Logger;

public class StudentRepository {
    private static final Logger logger = Logger.getLogger(StudentRepository.class.getName());
    private Map<String,Student> students=new HashMap<>();

    public void addStudent(Student student) throws StudentException{
        if(student.getCNP()==null){
            logger.info("Cannot add null student");
            throw new StudentException("Cannot add null student");
        }
        if(students.containsKey(student.getCNP())){
            logger.info("Cannot add an student that already exist");
            throw new StudentException("Cannot add an student that already exist");
        }

        students.put(student.getCNP(),student);


    }
    public void deleteStudent(String CNP) throws StudentException{
        if(CNP==null){
            logger.info("Cannot delete null student");
            throw new StudentException("Cannot delete null student");
        }
        if(!students.containsKey(CNP)){
            logger.info("Student doesn't exist");
            throw new StudentException("Student doesn't exist");
        }
        students.remove(CNP);
        logger.info("Student deleted"+CNP);

    }

    public List<Student> retrieveByAge (int age) throws StudentException{
        if(age<0)
        {
            throw new StudentException("Age cannot be negative");
        }
        List<Student> studentList=new ArrayList<>(students.values());
        List<Student> studentsByAge=new ArrayList<>();
        for(Student s:studentList){
            if(s.getAge()==age)
                studentsByAge.add(s);
        }
        return studentsByAge;
    }
    public List<Student> listBy(String rule) throws StudentException{

        List<Student> list = new ArrayList<>(students.values());

        if(rule==null){
            throw new StudentException("The rule should not be null");
        }
        switch (rule) {
            case "last":
                list.sort(Comparator.comparing(Student::getLastName));
                break;
            case "birthday":
                list.sort(Comparator.comparing(Student::getDateOfBirth));
                break;
            default:
                throw new StudentException("The rule should be first/age");

        }
        return list;
    }


}
