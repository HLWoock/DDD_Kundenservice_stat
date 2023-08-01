package de.woock.domain;

import lombok.ToString;

@ToString
public class Kunde {
	
	String regx_name = "^[A-Z][a-zA-Z0-9_\\-!@#$%^&*()+=\\[\\]{}|\\\\:;\"'<>,.?/~]{2,15}$\r\n";
	String regx_mail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	private String name;
	private String mail;
	
	public Kunde(String name, String mail) {
		if (name.matches(regx_name) ) {
	        this.name = name;
	    } else {
	        throw new IllegalArgumentException("Kundenname entspricht nicht der Konvention");
	    }
		if (mail.matches(regx_mail)) {
			this.mail = mail;
		} else {
			throw new IllegalArgumentException("Mailadresse entspricht nicht der Konvention");
		}
	}

}
