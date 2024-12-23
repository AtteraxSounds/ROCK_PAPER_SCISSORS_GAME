import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        public class Main {
            public static void main(String[] args) {
                int userScore = 0;
                int aiScore = 0;
                Random rng = new Random();
                int rngManip = rng.nextInt(2+ 1);
                String[] aiInputs = { "paper", "rock", "scissors" };
                String ai = "";
                String userInput = "";
                Scanner input = new Scanner(System.in);
                System.out.println("Welcome to the game ROCK PAPER SCISSORS");
                System.out.println("***************************************");
                System.out.println("You will play against an ai which will choose their selection randomly");
                System.out.println("To play, please write the word play!");
                System.out.println("Or if You don't know how to play, please write the word help");
                System.out.println("If you want to close the game at any time, write close!");
                userInput = input.nextLine();
                while (gameRunner(userInput.toLowerCase())) {
                    if (userInput.toLowerCase().equals("play")) {
                        System.out.println("!You chose to play! HURRAY!");
                        System.out.println("***************************************");
                        System.out.println("Please select one of the following:");
                        System.out.println("ROCK");
                        System.out.println("PAPER");
                        System.out.println("SCISSORS");
                        userInput = input.nextLine();
                        if (userInput.toLowerCase().equals("rock") || userInput.toLowerCase().equals("paper")
                                || userInput.toLowerCase().equals("scissors")) {
                            rngManip = rng.nextInt(2 - 0 + 1) + 0;
                            ai = aiInputs[rngManip];
                            if (gameConditionAIWin(userInput.toLowerCase(), ai)) {
                                aiScore++;
                                userScore += 0;
                            }
                            if (gameConditionDraw(userInput.toLowerCase(), ai)) {
                                aiScore += 0;
                                userScore += 0;
                            }
                            if (gameConditionUserWin(userInput.toLowerCase(), ai)) {
                                aiScore += 0;
                                userScore++;
                            }
                            System.out.println("***************************************");
                            System.out.println("You chose: " + userInput.toLowerCase());
                            System.out.println("The ai chose: " + ai);
                            scoreKeeper(userScore, aiScore, userInput.toLowerCase(), ai);

                            userInput = input.nextLine();

                        }
                    }
//Help Menu
                    else if (userInput.toLowerCase().equals("help")) {
                        System.out.println("***************************************");
                        System.out.println("HELP I DON'T KNOW HOW TO PLAY");
                        System.out.println("***************************************");
                        System.out.println("Rock Beats Scissors");
                        System.out.println("Paper Beats Rock");
                        System.out.println("Scissors Beats Paper");
                        System.out.println("Equal inputs result in a draw");
                        System.out.println("Whoever beats, gets a point!");
                        System.out.println("!Game will not end if you don't write the word close!");
                        System.out.println("***************************************");
                        System.out.println("To play, please write the word play!");
                        System.out.println("If you want to close the game at any time, write close!");
                        userInput = input.nextLine();
                    } else {
                        System.out.println("Please write one of the commands!!");
                        userInput = input.nextLine();
                    }
                }
                System.out.println("You closed the game, bye bye!");
                input.close();
                return;

            }

            //Decides if AI or user won the game or if the game is at a draw.
//Strings represent the objects rock ,paper , and scissors.
            public static boolean gameConditionAIWin(String user, String ai) {
                if ((ai.equals("scissors") && user.equals("paper")) || (ai.equals("rock") && user.equals("scissors"))
                        || (ai.equals("paper") && user.equals("rock"))) {
                    return true;
                } else
                    return false;
            }

            public static boolean gameConditionUserWin(String user, String ai) {
                if ((user.equals("scissors") && ai.equals("paper")) || (user.equals("rock") && ai.equals("scissors"))
                        || (user.equals("paper") && ai.equals("rock"))) {
                    return true;
                } else
                    return false;
            }
//draw condition is true when there is a draw.

            public static boolean gameConditionDraw(String user, String ai) {
                if (user.equals(ai)) {
                    return true;
                }
                return false;
            }

            //Keeps the users and ai's scores
            public static void scoreKeeper(int user, int ai, String userInput, String aiInput) {
                if (gameConditionDraw(userInput, aiInput)) {
                    user += 0;
                    ai += 0;
                    System.out.println("The Game Result Is A DRAW!!");
                    System.out.println("User's score: " + user);
                    System.out.println("AI's score: " + ai);
                    System.out.println("***************************************");
                    System.out.println("To play, please write play");
                    System.out.println("To close, please write close");
                    System.out.println("***************************************");

                }
                if (gameConditionUserWin(userInput, aiInput)) {

                    System.out.println("User Won!!");
                    System.out.println("User's score: " + user);
                    System.out.println("AI's score: " + ai);
                    System.out.println("***************************************");
                    System.out.println("To play, please write play");
                    System.out.println("To close, please write close");
                    System.out.println("***************************************");

                }
                if (gameConditionAIWin(userInput, aiInput)) {

                    System.out.println("AI Won!!");
                    System.out.println("User's score: " + user);
                    System.out.println("AI's score: " + ai);
                    System.out.println("***************************************");
                    System.out.println("To play, please write play");
                    System.out.println("To close, please write close");
                    System.out.println("***************************************");
                }
            }

            // While this is true, game runs
            public static boolean gameRunner(String close) {
                boolean gameRunning = true;
                if (close.equals("close")) {
                    gameRunning = false;
                } else
                    gameRunning = true;

                return gameRunning;

            }

        }

