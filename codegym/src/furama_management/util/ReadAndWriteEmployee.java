package furama_management.util;

import furama_management.model.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployee {
    public static List<Employee> readFile(String fileUse) {
        List<Employee> employees = new ArrayList<>();
        File file = new File(fileUse);

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String temp = "";
            while ((temp = bufferedReader.readLine()) != null&&!temp.equals("")) {
                String[] arr = temp.split(",");
                employees.add(new Employee(arr[0], arr[1], arr[2], arr[3], arr[4],
                        arr[5], arr[6], arr[7], arr[8], Double.parseDouble(arr[9])));
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return employees;
    }

    public static void writeList(String fileUse,List<Employee>str, boolean a) {

        File file = new File(fileUse);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, a);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Employee e: str) {
                bufferedWriter.write(e.luuFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
