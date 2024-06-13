package exceptions.logging;

public class Exceptions {
    public static class StudentException extends Exception{
        public StudentException(String message){
            super(message);
        }
    }
    public static class InvalidNameException extends StudentException{
        public InvalidNameException(String message){
            super(message);
        }
    }
    public static class InvalidDateOfBirthException extends StudentException{
        public InvalidDateOfBirthException(String message){
            super(message);
        }
    }
    public static class InvalidGenderException extends Exception{
        public InvalidGenderException(String message){
            super(message);
        }
    }
    public class StudentNotFoundException extends Exception{
        public StudentNotFoundException(String message){
            super(message);
        }
    }
    public static class CNPException extends Exception{
        public CNPException(String message){
            super(message);
        }
    }
    public class AgeException extends Exception{
        public AgeException(String message){
            super(message);
        }
    }
}
