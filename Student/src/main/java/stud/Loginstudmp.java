package stud;

import com.demo.dao.Logindao;

public class Loginstudmp implements LoginStud{

	private Logindao ldao; 
	
	public Loginstudmp() {
		ldao=(Logindao) new Loginstudmp();
	}
	
	@Override
	public boolean validateUser(String Uname, String Pass) {
		
		return ldao.doAuthentication(Uname, Pass);
	}

}
