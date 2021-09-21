package Usuarios.Paciente.Domain.Exceptions;

public class ValoracionCaracteresNoValidos extends RuntimeException {
    public ValoracionCaracteresNoValidos(String s) {
        super(s);
    }
}
