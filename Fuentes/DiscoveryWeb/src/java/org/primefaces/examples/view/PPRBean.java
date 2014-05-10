package org.primefaces.examples.view;
 
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 

@ManagedBean(name = "pprBean")
public class PPRBean implements Serializable { 

    private int sumando1 , sumando2 , resultado = 0;
     
    public String getSumando2() {
        return String.valueOf(sumando2);
    }
    
     public void setSumando2(String sum) {
        this.sumando2 = Integer.parseInt(sum);
    }    
    
    public String getSumando1() {
        return String.valueOf(sumando1);
    }   
    
    public void setSumando1(String sum) {
        this.sumando1 = Integer.parseInt(sum);
    }
    
    
     public String getResultado() {
         
         resultado = sumando1 + sumando2;
         if(resultado <= 0) return ""; 
       return String.valueOf(resultado);
    }
     
    public void setResultado() {
        //this.resultado = Integer.parseInt(res);
    }
}