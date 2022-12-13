import java.io.*;

class ConvertBinary {
  public static void main(String[] args) throws IOException {
    System.out.print("Please Enter a decimal number to convert to Binary: ");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    new ConvertBinary().printBinary(Integer.parseInt(br.readLine()));
  }

  public void printBinary(int number) {
    if (number < 2) {
      System.out.print(number);
    } else {
      printBinary(number / 2);
      System.out.print(number % 2);
    }
  }

  public void printBinaryReverse(int number) {
    if (number < 2) {
      System.out.print(number);
    } else {
      System.out.print(number % 2);
      printBinary(number / 2);
    }
  }
}