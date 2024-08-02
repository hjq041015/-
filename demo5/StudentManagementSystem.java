package com.google.demo5;
import java.util.*;


public class StudentManagementSystem {
    private static HashMap<Integer, Student> hashMap = new HashMap<>();
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        initializeStudents();
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("欢迎来的简易版学生管理系统");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:查询学生");
            System.out.println("4:查询所有学生");
            System.out.println("5:查看90分以上学生");
            System.out.println("6:退出");
            System.out.println("请选择你的需求:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    findStudent();
                    break;
                case 4:
                    allStudent();
                    break;
                case 5:
                    selectStudent();
                    break;
                case 6:
                    System.out.println("退出系统");
                    return;
                default:
                    System.out.println("无效选项，请重新输入");

            }

        if (keepRunning) {
            System.out.println("是否继续进行操作:  (y/n)");
            String continueChoice = scanner.next();
            if ( !continueChoice.equalsIgnoreCase("y")) {
                keepRunning = false;
                System.out.println("退出程序");
            }
        }
        }


    }


    private static void addStudent() {
        System.out.println("请输入学生的学号:");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("请输入学生的姓名:");
        String name = scanner.nextLine();

        System.out.println("请输入学生的年龄:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("请输入学生的分数:");
        int source = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(studentId, name, age, source);
        studentList.add(student);
        hashMap.put(studentId, student);
        System.out.println("学生添加成功" + student);

    }

    private static void removeStudent() {
        System.out.println("请选择要删除学生的学号:");
        int id = scanner.nextInt();
        Student student = hashMap.remove(id);
        if (student != null) {
            studentList.remove(student);
            System.out.println("学生删除成功" + student);
        } else {
            System.out.println("未找到该学生");
        }


    }

    private static void findStudent() {
        System.out.println("请选择要查询学生的学号:");
        int id = scanner.nextInt();
        Student student = hashMap.get(id);
        if (student != null) {
            System.out.println("找到学生" + student);
        } else {
            System.out.println("未找到该学生");
        }
    }


    private static void allStudent() {
        if (studentList.isEmpty()) {
            System.out.println("系统里没有学生的信息");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    private static void selectStudent() {
        System.out.println("分数大于90分的学生列表:");
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getSource() > 90) {
                System.out.println(student);
            }
        }
    }

    private static void initializeStudents() {
        Student student1 = new Student(1, "Frank", 20, 95);
        Student student2 = new Student(2, "Jerry", 22, 92);
        Student student3 = new Student(3, "Tom", 19, 20);
        Student student4 = new Student(4, "Jack", 16, 46);
        Student student5 = new Student(5, "Fuck", 50, 98);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        hashMap.put(student1.getStudentId(), student1);
        hashMap.put(student2.getStudentId(), student2);
        hashMap.put(student3.getStudentId(), student3);
        hashMap.put(student4.getStudentId(), student4);
        hashMap.put(student5.getStudentId(), student5);

    }
}
