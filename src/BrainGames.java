import java.util.Scanner;
import java.util.Random;

    public class BrainGames {
        private static Scanner scanner = new Scanner(System.in);
        private static Random random = new Random();
        private static String name;

        public static void main(String[] args) {
            while (true) {
                System.out.println("\nPlease enter the game number and press Enter.");
                System.out.println("1 - Greet");
                System.out.println("2 - Even");
                System.out.println("3 - Calc");
                System.out.println("4 - GCD");
                System.out.println("5 - Progression");
                System.out.println("6 - Prime");
                System.out.println("0 - Exit");
                System.out.print("Your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        greet();
                        break;
                    case 2:
                        evenGame();
                        break;
                    case 3:
                        calcGame();
                        break;
                    case 4:
                        gcdGame();
                        break;
                    case 5:
                        progressionGame();
                        break;
                    case 6:
                        primeGame();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 0 to 6.");
                        break;
                }
            }
        }

        private static void greet() {
            System.out.println("Welcome to the Brain Games!");
            System.out.print("May I have your name? ");
            name = scanner.nextLine();
            System.out.println("Hello, " + name + "!");
        }

        private static void evenGame() {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            int correctAnswers = 0;

            while (correctAnswers < 3) {
                int number = random.nextInt(100) + 1;
                System.out.println("Question: " + number);
                System.out.print("Your answer: ");
                String answer = scanner.nextLine().trim().toLowerCase();
                String correct = (number % 2 == 0) ? "yes" : "no";

                if (answer.equals(correct)) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correct + "'.");
                    return;
                }
            }
            System.out.println("Congratulations, " + name + "!");
        }

        private static void calcGame() {
            System.out.println("What is the result of the expression?");
            int correctAnswers = 0;
            char[] operations = {'+', '-', '*'};

            while (correctAnswers < 3) {
                int num1 = random.nextInt(10) + 1;
                int num2 = random.nextInt(10) + 1;
                char operation = operations[random.nextInt(operations.length)];
                String question = num1 + " " + operation + " " + num2;
                System.out.println("Question: " + question);
                System.out.print("Your answer: ");
                int answer = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                int correct = eval(num1, num2, operation);

                if (answer == correct) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correct + "'.");
                    return;
                }
            }
            System.out.println("Congratulations, " + name + "!");
        }

        private static int eval(int num1, int num2, char operation) {
            switch (operation) {
                case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '*':
                    return num1 * num2;
                default:
                    throw new IllegalArgumentException("Unknown operation: " + operation);
            }
        }

        private static void gcdGame() {
            System.out.println("Find the greatest common divisor of given numbers.");
            int correctAnswers = 0;

            while (correctAnswers < 3) {
                int num1 = random.nextInt(100) + 1;
                int num2 = random.nextInt(100) + 1;
                System.out.println("Question: " + num1 + " " + num2);
                System.out.print("Your answer: ");
                int answer = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                int correct = gcd(num1, num2);

                if (answer == correct) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correct + "'.");
                    return;
                }
            }
            System.out.println("Congratulations, " + name + "!");
        }

        private static int gcd(int a, int b) {
            while (b != 0) {
                int t = b;
                b = a % b;
                a = t;
            }
            return a;
        }

        private static void progressionGame() {
            System.out.println("What number is missing in this progression?");
            int correctAnswers = 0;

            while (correctAnswers < 3) {
                int start = random.nextInt(10) + 1;
                int step = random.nextInt(10) + 1;
                int length = 10;
                int[] progression = new int[length];
                for (int i = 0; i < length; i++) {
                    progression[i] = start + i * step;
                }
                int missingIndex = random.nextInt(length);
                int correct = progression[missingIndex];
                progression[missingIndex] = -1;

                System.out.print("Question: ");
                for (int i = 0; i < length; i++) {
                    if (progression[i] == -1) {
                        System.out.print(".. ");
                    } else {
                        System.out.print(progression[i] + " ");
                    }
                }
                System.out.println();
                System.out.print("Your answer: ");
                int answer = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (answer == correct) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correct + "'.");
                    return;
                }
            }
            System.out.println("Congratulations, " + name + "!");
        }

        private static void primeGame() {
            System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
            int correctAnswers = 0;

            while (correctAnswers < 3) {
                int number = random.nextInt(100) + 1;
                System.out.println("Question: " + number);
                System.out.print("Your answer: ");
                String answer = scanner.nextLine().trim().toLowerCase();
                String correct = isPrime(number) ? "yes" : "no";

                if (answer.equals(correct)) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correct + "'.");
                    return;
                }
            }
            System.out.println("Congratulations, " + name + "!");
        }

        private static boolean isPrime(int number) {
            if (number <= 1) return false;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }
            return true;
        }
    }


