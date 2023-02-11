import java.util.Arrays;
import java.util.Scanner;

public class Bai7 {
    //Bài 7: Nhập mảng a gồm N phần tử bao gồm các số nguyên dương.
    // Kiểm tra xem a có phải là mảng đối xứng hay không (ví dụ: [15 2 1 2 15] là mảng đối xứng).
    public static void main(String[] args) {
        int[] newArr = Nhapmang();
        System.out.println(Arrays.toString(newArr));
        if(checkArray(newArr)){
            System.out.println("Đây là mảng đối xứng");
        }else {
            System.out.println("Đây không phải mảng đối xứng");
        }
    }
    public static int[] Nhapmang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] ", i);
            arr[i] = sc.nextInt();
            if(arr[i]<=0){
                System.out.println("Mảng phải là số nguyên dương. Mời điền lại: ");
                System.out.printf("a[%d] ", i);
                arr[i] = sc.nextInt();
            }
        }
        return arr;
    }
    public static boolean checkArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != arr[arr.length - i - 1]){
                return false;
            }
        }
        return true;
    }
}
