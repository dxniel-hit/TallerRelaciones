package empresa;


public class Cliente extends Persona {

    private String numeroDeTelefono;


    public Cliente(String nombre, Integer edad, String numeroDeTelefono) {
        super(nombre, edad);
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    @Override
    public String toString() {
        return "Cliente [numeroDeTelefono=" + numeroDeTelefono + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((numeroDeTelefono == null) ? 0 : numeroDeTelefono.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (numeroDeTelefono == null) {
            if (other.numeroDeTelefono != null)
                return false;
        } else if (!numeroDeTelefono.equals(other.numeroDeTelefono))
            return false;
        return true;
    }

}
