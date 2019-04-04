public class FizzBuzz {
    public static void main(String[] args) {
        // Write a program that prints the numbers from 1 to 100.
// But for multiples of three print “Fizz” instead of the number
// and for the multiples of five print “Buzz”.
// For numbers which are multiples of both three and five print “FizzBuzz”.

        for (int i = 0; i < 100; i++) {
            int j = i + 1;

            if ((j%3 == 0) && (j % 5 == 0)) {
                System.out.println("FizzBuzz");
            }
            else if (j % 3 == 0){
                    System.out.println("Fizz");
                }
                else if (j % 5 == 0){
                    System.out.println("Buzz");
                }
                else{
                    System.out.println(j);
                }



            }
        }
    }