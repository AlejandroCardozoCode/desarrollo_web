package Usuarios.Paciente.Domain.Exceptions;

public class NombreCaracteresNoValidos extends RuntimeException {
    public NombreCaracteresNoValidos(String s) {
        super(s);
    }
}
