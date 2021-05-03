import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StudentService {
    static Student[] getAllStudentsInfo(String path) throws IOException {
        String[] arr = Files.readAllLines(Paths.get(path)).toArray(new String[0]);

        Student[] info = new Student[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            info[i] = new Student();
        }
        for (int i = 0; i < arr.length; ++i) {
            String[] tmp = arr[i].split(",");
            info[i].setFirstName(tmp[0]);
            info[i].setLastName(tmp[1]);
            info[i].setGender(tmp[3]);
            info[i].setAge(Integer.parseInt(tmp[2]));
            info[i].setMark((Double.parseDouble(tmp[4])));
        }
        return info;
    }

    static void studentName(Student a) {
        System.out.println(a.getFirstName() + " " + a.getLastName());
    }

    static void studentInfo(Student a) {
        System.out.println(a.getFirstName() + " " + a.getLastName() + " " + a.getAge() + " " + a.getGender() + " " + a.getMark());
    }

    static void maleStudents(Student[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].getGender().charAt(0) == 'm') {
                studentName(arr[i]);
            }
        }
    }

    static void allStudentsInfo(Student[] a) {
        for (int i = 0; i < a.length; ++i) {
            studentName(a[i]);
        }
    }

    static void femaleStudentsHighMark(Student[] a) {
        for (int i = 0; i < a.length; ++i) {
            if (a[i].getGender().charAt(0) == 'f' && a[i].getMark() > 50.4) {
                studentName(a[i]);
            }
        }
    }

    static void studentWithMinMark(Student[] a) {
        Student b = a[0];
        for (int i = 1; i < a.length; ++i) {
            if (b.getMark() > a[i].getMark()) {
                b = a[i];
            }
        }

        studentInfo(b);
    }

    static void oldestMaleStudent(Student[] a) {
        Student b = new Student();
        int count=0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i].getGender().charAt(0) == 'm') {
               count++;
            }
        }

        Student[] arr=new Student[count];
        for(int i=0,j=0;i<a.length;++i) {
                if (a[i].getGender().charAt(0)=='m') {
                    arr[j] = a[i];
                    j++;
                }
        }
        b=arr[0];
        for(int i=1;i<count;++i)
        {
            if(arr[i].getMark()>b.getMark())
            {
                b=arr[i];
            }
        }
        studentInfo(b);
    }

    static void sortByMark(Student[] arr)
    {
        for(int i=0;i<arr.length;++i)
        {
            for(int j=i+1;j<arr.length;++j)
            {
                if(arr[i].getMark()>arr[j].getMark())
                {
                    Student k=new Student();
                    k=arr[i];
                    arr[i]=arr[j];
                    arr[j]=k;
                }
            }
            studentInfo(arr[i]);
        }
    }

    static void sortfemaleByYear(Student [] arr)
    {
    int count =0;
        for(int r=0;r<arr.length;++r)
        {
            if(arr[r].getGender().charAt(0)=='f')
            {
                count++;
            }
        }
        Student[] females=new Student[count];

        for(int i=0,j=0; i<arr.length;++i)
        {
            if(arr[i].getGender().charAt(0)=='f')
            {
                females[j]=arr[i];
                j++;
            }
        }
        
                    Student k=new Student();
        for(int i=0;i<females.length;++i)
        {
            for(int j=i+1;j<females.length;++j)
            {
                if(arr[i].getAge()>females[j].getAge())
                {
                    k=females[i];
                    females[i]=females[j];
                    females[j]=k;
                }
            }
            studentInfo(females[i]);
        }
    }

}
