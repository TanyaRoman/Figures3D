package math;

public class Matrix4 {

    private  double[] matrix;

    public Matrix4(double[][] m){ // сделать проверку на дурака
        matrix = new  double[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i*4 + j] = m[i][j];
            }
        }
    }

    private Matrix4(double[] arr){
        matrix = arr;
    }

    public double getAl(int r, int c){
        return matrix[ r*4+c];
    }

    public void setAl(int r, int c, double v){
        matrix[r*4+c] =v;
    }

    public static Matrix4 zero(){ //нуливая матрица, для нее создан private Matrix4
        return new Matrix4(new double[16]);
    }

    public static Matrix4 one(){
        Matrix4 m = zero();
        for (int i = 0; i < 4; i++) {
            m.setAl(i, i, 1);
        }
        return m;
    }

    public Matrix4 mul(double num){  //умножение матрицы на число
        double[] arr = new  double[16];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[i] * num;
        }
        return new Matrix4(arr);
    }

    public Vector4 mul(Vector4 v){ //умножение матрицы на вектор
        double[] arr = new  double[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i] += this.getAl(i, j) * v.at(j);
            }
        }
        return new Vector4(arr[0], arr[1], arr[2], arr[3]);
    }

    public Matrix4 mul(Matrix4 other){ //умнжение матрицы на матрицу
        Matrix4 r = Matrix4.zero();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    r.setAl(i, j, r.getAl(i, j) + this.getAl(i, k) * other.getAl(k, j));
                }
            }
        }
        return r;
    }

    public static Matrix4 rotate (double argle, int axis){
        Matrix4 m = Matrix4.one();
        int a1 =  (axis + 1) % 3;
        int a2 =  (axis + 2) % 3;

        m.setAl(a1, a1, Math.cos(argle));
        m.setAl(a1, a2, Math.sin(argle));
        m.setAl(a2, a1, -Math.sin(argle));
        m.setAl(a2, a2, Math.cos(argle));

        return  m;
    }

}
