package Usuarios.Paciente.Domain.Exceptions;

public class EdadPacienteNoValida extends RuntimeException {
    public EdadPacienteNoValida(String s) {
        super(s);
    }
}
