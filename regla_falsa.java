package regla_falsa;

/**
 *
 * @author BNN0
 */
public class reglafalsa { 
    static int iteracion = 0;
    public static double Xa = 0,
            Xb = 1,
            Fxa = 0,
            Fxb = 0,
            Xm = 0,
            Fxm = 0,
            Ear = 999,
            XmAnterior = 0;

    public static void main(String[] args) {
        
        while(Ear > 0.03){//Puede ser cambiada la condicion a: Ear || iteracion Ejem. (Ear > num) ó (iteracion == num)
            XmAnterior = Xm;
            
            Fxa = F(Xa);
            Fxb = F(Xb);
            Xm = Xr(Xb, Fxb, Fxa, Xa);
            Fxm = F(Xm);
            if(iteracion != 0)
            Ear = EarR(Xm, XmAnterior);
            
            System.out.println("Iteracion \t Xa \t Xb \t Fxa "
                    + "\t Fxb \t Xm \t Fxm \t Ear");
            System.out.println(iteracion + "\t" + Xa + "\t" + Xb + 
                    "\t" + Fxa + "\t" + Fxb + "\t" + Xm + "\t" 
                    + Fxm + "\t" + Ear);
            if(Fxm < 0){
                Xa = Xm;
                Fxa = Fxm;
            }else if(Fxm >= 0){
                Xb = Xm;
                Fxb = Fxm;
            }
            iteracion++;
        }  
    }
    
    public static double F(double x){ //Esta funcion es editable, aquí escribe la función de tu ejercicio.
        return (-2 + (7 * x) - (5 * Math.pow(x, 2)) + (6 * Math.pow(x, 3)));
    }
    
    //Formula para calcular Xr ó Xm
    public static double Xr(double Xb, double Fxb, double Fxa, double Xa){
        return Xb - ((Fxb*(Xa-Xb))/(Fxa-Fxb));
    }
    
    //Formula para calcular el Error actual
    public static double EarR(double Xm, double XmAnterior){
        return Math.abs((Xm-XmAnterior)/Xm);
    }
}
