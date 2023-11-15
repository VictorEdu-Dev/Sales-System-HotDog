package roulle;

import academicos.Aluno;
import academicos.MembroUniversitario;
import academicos.Professor;
import academicos.Servidor;

public enum UniversityMemberType {
	PROFESSOR {
		public MembroUniversitario gerarMembroUniversitario(String nome,  String identificacao) {
			return new Professor(nome, identificacao);
		}
	},
	
	SERVIDOR {
		public MembroUniversitario gerarMembroUniversitario(String nome,  String identificacao) {
			return new Servidor(nome, identificacao);
		}	
	},
	
	ALUNO {
		public MembroUniversitario gerarMembroUniversitario(String nome,  String identificacao) {
			return new Aluno(nome, identificacao);
		}
	};

	
	public abstract MembroUniversitario gerarMembroUniversitario(String nome, String identificacao);
}
