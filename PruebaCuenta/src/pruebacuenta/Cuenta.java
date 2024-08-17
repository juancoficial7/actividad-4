
package pruebacuenta;


public class Cuenta {
    
    protected float saldo;
    /* Atributo que define el número de consignaciones realizadas en
    una cuenta bancaria */
    
    protected int numeroConsignaciones = 0;
    // Atributo que define el número de retiros de una cuenta bancaria
    
    protected int numeroRetiros = 0;
    // Atributo que define la tasa anual de intereses de una cuenta bancaria
    
    protected float tasaAnual;
    /* Atributo que define la comisión mensual que se cobra a una
    cuenta bancaria */
    
    protected float comisionMensual = 0;
    
    
    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }
    
    
    public void consignar(float cantidad) {
        saldo = saldo + cantidad; 
        /* Se actualiza el saldo con la cantidad
        consignada */
        // Se actualiza el número de consignaciones realizadas en la cuenta
        numeroConsignaciones = numeroConsignaciones + 1;
    }
    
    public void retirar(float cantidad) {
        float nuevoSaldo = saldo - cantidad;
        /* Si la cantidad a retirar no supera el saldo, el retiro no se puede
        realizar */
        if (nuevoSaldo >= 0) {
            saldo -= cantidad;
            numeroRetiros = numeroRetiros + 1;
        } else {
            System.out.println("La cantida a retirar excede el saldo actual.");
        }
    }
    
    public void calcularInterés() {
        float tasaMensual = tasaAnual / 12; /* Convierte la tasa anual en
        mensual */
        float interesMensual = saldo * tasaMensual;
        saldo += interesMensual; /* Actualiza el saldo aplicando el interés
        mensual */
    }
    
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInterés();
    }
    
}
