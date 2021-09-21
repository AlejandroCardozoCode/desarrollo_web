package Usuarios.Doctor.Domain.Exceptions;

public class NombreNoValido extends RuntimeException {
    public NombreNoValido(String s) {
        super(s);
    }
}
