package Banco.ws_Banco;

public class Restriccion {

    private Double rangoInferior;
    private Double rangoSuperior;

    public Restriccion() {
    }

    public Restriccion(Double rangoInferior, Double rangoSuperior) {
        this.rangoInferior = rangoInferior;
        this.rangoSuperior = rangoSuperior;
    }

    public Double getRangoInferior() {
        return rangoInferior;
    }

    public void setRangoInferior(Double rangoInferior) {
        this.rangoInferior = rangoInferior;
    }

    public Double getRangoSuperior() {
        return rangoSuperior;
    }

    public void setRangoSuperior(Double rangoSuperior) {
        this.rangoSuperior = rangoSuperior;
    }

}
