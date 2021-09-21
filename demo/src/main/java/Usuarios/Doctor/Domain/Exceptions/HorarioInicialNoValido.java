package Usuarios.Doctor.Domain.Exceptions;

public class HorarioInicialNoValido extends RuntimeException {
    public HorarioInicialNoValido(String s) {
        super(s);
    }
}
