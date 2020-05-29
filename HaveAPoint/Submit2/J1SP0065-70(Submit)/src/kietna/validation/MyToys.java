package kietna.validation;

import java.util.Scanner;

/**
 *
 * @author giao-lang | fb/giao.lang.bis | fb/bmag.vn version 18.03
 */
//class chứa các hàm đồ chơi, dùng cho việc nhập xuất dữ liệu
public class MyToys {

    private static Scanner sc = new Scanner(System.in);

    //hàm nhập vào số nguyên đích thực
    //- mọi sự nhập cà chớn bị chửi, ví dụ nhập chuỗi thay vì nhập số
    //- chống trôi lệnh, tức là ko để lại rác Enter hay kí tự nào đó
    //trong buffer cho thằng sau hốt 
    //- có thể kiểm tra số nguyên trong 1 range/khoảng cho trước
    //- có câu thông báo động, tùy ngữ cảnh 
    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //nhập vào 1 số thực, chặn hết các trường hợp cà chớn 
    public static double getADouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //nhập vào một chuỗi kí tự, theo định dạng đc đưa vào
    //định dạng xài Regular Expression
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    //nhập vào một chuỗi kí tự, khác rỗng
    public static String getString(String inputMsg, String errorMsg) {
        String result;
        while (true) {
            System.out.print(inputMsg);
            result = sc.nextLine().trim();
            if (result.length() == 0 || result.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return result;
            }
        }
    }
    
    public static String getString(String inputMsg, String errorMsg, String format) {
        String result;
        while (true) {
            System.out.print(inputMsg);
            result = sc.nextLine().trim();
            if (result.length() == 0 || result.isEmpty()) {
                System.out.println(errorMsg);
            } else if (!result.matches(format)) {
                System.out.println("Wrong format");
            }  else {
                return result;
            }
        }
    }

    public static boolean checkYN() {
        while (true) {
            String result = getString("Do you want add new student? (Y or N): ", "Not Empty");
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.out.println("Re-input: ");
        }
    }


    public static double checkInputMark(String nameSubject) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < 0) {
                    System.err.println(nameSubject + " is greater than equal zero");
                    System.out.print(nameSubject + ":");
                    continue;
                }
                if (result > 10) {
                    System.err.println(nameSubject + " is less than equal ten");
                    System.out.print(nameSubject + ":");
                    continue;
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println(nameSubject + " is digit");
                System.out.print(nameSubject + ":");
            }
        }
    }
}
