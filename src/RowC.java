class RowC extends Field {
    static String cell0 = " |";
    static String cell1 = " ";
    static String cell2 = "| ";

    public static void move(int column) {
        switch(column){
            case 0:
                cell0 = MainClass.currentXorO + "|";
                break;
            case 1:
                cell1 = MainClass.currentXorO;
                break;
            case 2:
                cell2 =  "|" + MainClass.currentXorO;
                break;
        }
    }
}
