package Usuarios.Paciente.Domain.Exceptions;

public class RazaCaracteresNoValidos extends RuntimeException {
    public RazaCaracteresNoValidos(String s) {
        super(s);
    }
}
