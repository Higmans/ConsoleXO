import java.util.Scanner;

public class MainClass {
    private static final Field field = new Field();
    private static final String[] arrayXorO = {"X", "O"};
    private static int counter = 0;
    public static String currentXorO;

    public static void main(String[] args) {
        boolean gameIsRunning = true;

        startTheGame();

        while (gameIsRunning){
            currentXorO = arrayXorO[counter % 2];
            System.out.println("Ваш ход, " + currentXorO + "\nВведите ряд:");
            int x = new Scanner(System.in).nextInt();
            System.out.println("Введите столбец:");
            int y = new Scanner(System.in).nextInt();

            if (field.checkBeforeMove(x, y))
                continue;

            field.move(x, y);
            System.out.println(field);
            if (counter > 3){
                if (field.checkWinner(x, y)){
                    System.out.println("ИГРОК " + currentXorO + " ПОБЕДИЛ! ПОЗДРАВЛЯЮ!");
                    gameIsRunning = newGamePrompt();
                    continue;
                }
            }
            counter++;
            if (counter == 9){
                System.out.println("Ничья!");
                gameIsRunning = newGamePrompt();
            }
        }
    }

    private static void startTheGame() {
        System.out.println("Консольные крестики-нолики");
        System.out.println("Разработка, дизайн и саундтрек: Илья Серебряков (aka Lungo)");
        System.out.println("Все права защищены");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Загрузка");
        System.out.print("0%");
        for (int i = 0; i < 50; i++){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("|");
        }
        System.out.println("100%");
        System.out.println("Ходить по полю нужно, выбирая ряд и столбец, вводя числа от 0 до 2");
        System.out.println("Победит игрок, поставивший три крестика или три нолика в ряд или по диагонали");
        System.out.println("  0 1 2");
        System.out.println("0 " + RowA.cell0 + RowA.cell1 + RowA.cell2);
        System.out.println("1 " + RowB.cell0 + RowB.cell1 + RowB.cell2);
        System.out.println("2 " + RowC.cell0 + RowC.cell1 + RowC.cell2);
    }

    private static boolean newGamePrompt() {
        boolean output;
        System.out.println("Начать новую игру? (Y/N)");
        char yesNo = new Scanner(System.in).next().charAt(0);
        if (output = Character.toLowerCase(yesNo) == 'y'){
            counter = 0;
            field.resetField();
            System.out.println(field);
        }
        return output;
    }
}