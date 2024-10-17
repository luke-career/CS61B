public class TriangleDrawer {
    public static void main(String[] args){
        for(int row = 0; row < 50; row++){
            for(int colum = 0; colum < row; colum++){
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
}
