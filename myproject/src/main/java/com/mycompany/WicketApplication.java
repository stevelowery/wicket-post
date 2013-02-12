package com.mycompany;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.pages.SignInPage;
import org.apache.wicket.markup.html.WebPage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see com.mycompany.Start#main(String[])
 */
public class WicketApplication extends AuthenticatedWebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return MyAuthSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return SignInPage.class;
	}
}
