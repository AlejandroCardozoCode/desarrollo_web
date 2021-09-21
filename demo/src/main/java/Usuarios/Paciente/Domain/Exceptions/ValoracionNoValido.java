package Usuarios.Paciente.Domain.Exceptions;

public class ValoracionNoValido extends RuntimeException {
    public ValoracionNoValido(String s) {
        super((s));
    }
}
