package com.sleep;

public class CalculoIRPF {

    public double CalcularImposto(Double salario) {    
        double aliquota = 0.0;
        double parcelaDeduzir = 0.0;
        double imposto = 0.0;    
        if (salario < 0) {
            salario = 0.0;
        }
        if(!(salario instanceof Double)) {
            salario = 0.0;
        }
        if (salario <= 2259.20) {
            aliquota = 0.0;
            parcelaDeduzir = 0.0;
        } else if (salario <= 2826.65) {
            aliquota = 7.5;
            parcelaDeduzir = 169.44;
        } else if (salario <= 3751.05) {
            aliquota = 15.0;
            parcelaDeduzir = 381.44;
        } else if (salario <= 4664.68) {
            aliquota = 22.5;
            parcelaDeduzir = 662.77;
        } else {
            aliquota = 27.5;
            parcelaDeduzir = 896.0;
        }
        imposto = (salario * (aliquota / 100.0)) - parcelaDeduzir;
        return imposto;
    }

}
