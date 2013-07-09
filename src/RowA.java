class RowA extends Field {
    static String cell0 = "_|";
    static String cell1 = "_";
    static String cell2 = "|_";

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
