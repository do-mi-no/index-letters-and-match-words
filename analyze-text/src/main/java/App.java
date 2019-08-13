import controllers.LWController;
import enums.State;
import models.SampleText;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        State state = State.INIT;

        LWController controller = new LWController();

        Scanner scanner = new Scanner(System.in);

        while (state != State.EXIT) {
            switch (state) {
                case INIT:
                    controller.displayInit();
                    String answer = scanner.nextLine();

                    switch (answer) {
                        case "1":
                            doControllerTasks(controller, SampleText.kot);
                            state = State.RESULT;
                            break;
                        case "2":
                            doControllerTasks(controller, SampleText.zolw);
                            state = State.RESULT;
                            break;
                        case "3":
                            doControllerTasks(controller, SampleText.telegram);
                            state = State.RESULT;
                            break;
                        case "4":
                            doControllerTasks(controller, SampleText.inwokacja);
                            state = State.RESULT;
                            break;
                        case "0":
                            state = State.EXIT;
                            break;
                        default:
                            doControllerTasks(controller, answer);
                            state = State.RESULT;
                            break;
                    }
                    break;
                case RESULT:
                    printResult(controller);
                    state = State.INIT;
                    break;
                case EXIT:
                    break;
            }
        }

    }

    private static void doControllerTasks(LWController controller, String userTxt) {
        controller.deleteAllLetterAndWordsFromRegistry();
        controller.setSentence(userTxt);
        controller.setUniqueLetters();
        controller.setUniqueWords();
        controller.addAllLetterAndWordsToRegistry();
    }

    private static void printResult(LWController controller) {
        controller.displayResult();
    }


}
