public class TriangleDrawer {

    public static void drawTrianlge(int N){
        for(int row = 0; row < N; row++){
            for(int colum = 0; colum < row; colum++){
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
    public static void main(String[] args){
        drawTrianlge(5);
    }
}
