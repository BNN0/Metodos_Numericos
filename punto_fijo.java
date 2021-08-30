package punto_fijo;

/**
 *
 * @author BNN0
 */
public class puntofijo {
    static int iteracion = 0;
    static double 
            Xi = 1,
            XAnterior = 0,
            Ear = 999;
    
    public static void main(String[] args) {
        
        while (iteracion < 10) {            
            XAnterior = Xi;
            
            System.out.println(Xi);
            
            Xi = F(Xi);
            
            if(iteracion != 0)
                Ear(Xi, XAnterior);
            
            iteracion++;
        }
    }
    
    static double F(double x){
        return Math.cbrt((2*x)+2);
    }
    
    static double Ear(double Xi, double XAnterior){
        return Math.abs((Xi - XAnterior) / Xi);
    }
}
