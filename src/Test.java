import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {

        try {
            Student[] array=StudentService.getAllStudentsInfo("D:\\Text.txt");

            //Task1  Print full names of students
                StudentService.allStudentsInfo(array);
            System.out.println();

            //Task2 Print all male students
            StudentService.maleStudents(array);
            System.out.println();

            //Task3 Print all female students who has mark greater then 50.4
            StudentService.femaleStudentsHighMark(array);
            System.out.println();

            //Task4 Print student information having the minimal mark
            StudentService.studentWithMinMark(array);
            System.out.println();

            //Task5 Print biggest male student information
            StudentService.oldestMaleStudent(array);
            System.out.println();

            //Task6 Print students sorted by mark
            StudentService.sortByMark(array);
            System.out.println();

            //Task7 Print female students sorted by year
            StudentService.sortfemaleByYear(array);
            System.out.println();

        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }


    }


}
