package com.mycompany;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class MyAuthSession extends AuthenticatedWebSession {

	private static final long serialVersionUID = 1L;
	private boolean hasAcceptedEULA;
	private Roles roles;
	
	
	public MyAuthSession(Request request) {
		super(request);
		hasAcceptedEULA = false;
		roles = new Roles();
	}

	public static MyAuthSession get() {
		return (MyAuthSession) AuthenticatedWebSession.get();
	}
	
	@Override
	public boolean authenticate(String username, String password) {
		//normally, we would first call out to actually check the user's credentials, but for the purpose of simplicity for a demo app, any user/pass will do and we simply check if they've accepted the eula
		if(hasAcceptedEULA) {
			roles.add("authenticated");
			return true;
		}
		//user entered correct credentials, but user needs to first sign EULA in order to be authenticated...
		throw new RestartResponseAtInterceptPageException(EulaPage.class);
	}
	
	public void setHasAcceptedEULA(boolean hasAcceptedEULA) {
		this.hasAcceptedEULA = hasAcceptedEULA;
	}

	@Override
	public Roles getRoles() {
		return roles;
	}
}
