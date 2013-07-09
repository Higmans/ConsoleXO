public class Field {
    public Field(){
    }

    public void move(int row, int column){
        switch(row){
            case 0:
                RowA.move(column);
                break;
            case 1:
                RowB.move(column);
                break;
            case 2:
                RowC.move(column);
                break;
        }
    }

    public String toString(){
        return RowA.cell0 + RowA.cell1 + RowA.cell2 + "\n" + RowB.cell0 + RowB.cell1 + RowB.cell2 + "\n" + RowC.cell0 + RowC.cell1 + RowC.cell2;
    }

    public boolean checkBeforeMove(int x, int y) {
        String checkArray[][] = {{RowA.cell0, RowA.cell1, RowA.cell2},{RowB.cell0, RowB.cell1, RowB.cell2},{RowC.cell0, RowC.cell1, RowC.cell2}};
        boolean output;
        if (output = x < 0 || x > 3 || y < 0 || y > 2)
            System.out.println("Неверный ход. Номера рядов и столбцов - от 0 до 2");
        else if (output = checkArray[x][y].contains("X") || checkArray[x][y].contains("O"))
            System.out.println("Ячейка занята, ходите в другую");
        return output;
    }

    public void resetField() {
        RowA.cell0 = "_|";
        RowA.cell1 = "_";
        RowA.cell2 = "|_";
        RowB.cell0 = "_|";
        RowB.cell1 = "_";
        RowB.cell2 = "|_";
        RowC.cell0 = " |";
        RowC.cell1 = " ";
        RowC.cell2 = "| ";
    }

    public boolean checkWinner(int x, int y) {
        String checkArray[][] = {{RowA.cell0, RowA.cell1, RowA.cell2},{RowB.cell0, RowB.cell1, RowB.cell2},{RowC.cell0, RowC.cell1, RowC.cell2}};
        boolean output = false;
        switch (x){
            case 0:
                switch (y){
                    case 0:
                        if (checkArray[0][1].contains(MainClass.currentXorO) && checkArray[0][2].contains(MainClass.currentXorO) ||
                            checkArray[1][1].contains(MainClass.currentXorO) && checkArray[2][2].contains(MainClass.currentXorO) ||
                            checkArray[1][0].contains(MainClass.currentXorO) && checkArray[2][0].contains(MainClass.currentXorO)){
                            output = true;
                        }
                        break;
                    case 1:
                        if (checkArray[0][0].contains(MainClass.currentXorO) && checkArray[0][2].contains(MainClass.currentXorO) ||
                            checkArray[1][1].contains(MainClass.currentXorO) && checkArray[2][1].contains(MainClass.currentXorO)){
                            output = true;
                        }
                        break;
                    case 2:
                        if (checkArray[0][0].contains(MainClass.currentXorO) && checkArray[0][1].contains(MainClass.currentXorO) ||
                            checkArray[1][1].contains(MainClass.currentXorO) && checkArray[2][0].contains(MainClass.currentXorO) ||
                            checkArray[1][2].contains(MainClass.currentXorO) && checkArray[2][2].contains(MainClass.currentXorO)){
                            output = true;
                        }
                        break;
                }
                break;
            case 1:
                switch (y){
                    case 0:
                        if (checkArray[1][1].contains(MainClass.currentXorO) && checkArray[1][2].contains(MainClass.currentXorO) ||
                            checkArray[0][0].contains(MainClass.currentXorO) && checkArray[2][0].contains(MainClass.currentXorO)){
                            output = true;
                        }
                        break;
                    case 1:
                        if (checkArray[0][0].contains(MainClass.currentXorO) && checkArray[2][2].contains(MainClass.currentXorO) ||
                            checkArray[0][1].contains(MainClass.currentXorO) && checkArray[2][1].contains(MainClass.currentXorO) ||
                            checkArray[0][2].contains(MainClass.currentXorO) && checkArray[2][0].contains(MainClass.currentXorO) ||
                            checkArray[1][0].contains(MainClass.currentXorO) && checkArray[1][2].contains(MainClass.currentXorO)){
                            output = true;
                        }
                        break;
                    case 2:
                        if (checkArray[0][2].contains(MainClass.currentXorO) && checkArray[2][2].contains(MainClass.currentXorO) ||
                            checkArray[1][0].contains(MainClass.currentXorO) && checkArray[1][1].contains(MainClass.currentXorO)){
                            output = true;
                        }
                        break;
                }
                break;
            case 2:
                switch (y){
                    case 0:
                        if (checkArray[0][0].contains(MainClass.currentXorO) && checkArray[1][0].contains(MainClass.currentXorO) ||
                            checkArray[2][1].contains(MainClass.currentXorO) && checkArray[2][2].contains(MainClass.currentXorO) ||
                            checkArray[1][1].contains(MainClass.currentXorO) && checkArray[0][2].contains(MainClass.currentXorO)){
                            output = true;
                        }
                        break;
                    case 1:
                        if (checkArray[2][0].contains(MainClass.currentXorO) && checkArray[2][2].contains(MainClass.currentXorO) ||
                            checkArray[0][1].contains(MainClass.currentXorO) && checkArray[1][1].contains(MainClass.currentXorO)){
                            output = true;
                        }
                        break;
                    case 2:
                        if (checkArray[0][0].contains(MainClass.currentXorO) && checkArray[1][1].contains(MainClass.currentXorO) ||
                            checkArray[0][2].contains(MainClass.currentXorO) && checkArray[1][2].contains(MainClass.currentXorO) ||
                            checkArray[2][0].contains(MainClass.currentXorO) && checkArray[2][1].contains(MainClass.currentXorO)){
                            output = true;
                        }
                        break;
                }
                break;
        }
        return output;
    }
}