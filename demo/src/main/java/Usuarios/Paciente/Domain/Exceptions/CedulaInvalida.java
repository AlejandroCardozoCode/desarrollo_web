package Usuarios.Paciente.Domain.Exceptions;


public class CedulaInvalida extends RuntimeException {
    public CedulaInvalida(String s) {
        super(s);
    }
}
