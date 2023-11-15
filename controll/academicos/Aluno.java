package academicos;

public class Aluno extends MembroUniversitario {
    private String matricula;

    public Aluno(String nome, String matricula) {
        super(nome, matricula);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

}

