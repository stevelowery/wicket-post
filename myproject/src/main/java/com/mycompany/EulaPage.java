package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class EulaPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public EulaPage(PageParameters parameters) {
		super(parameters);
		
		Form<?> form = new Form<Void>("form") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				
				MyAuthSession.get().setHasAcceptedEULA(true);
				continueToOriginalDestination();
			}
		};
		add(form);
		
		form.add(new CheckBox("accept", Model.of(Boolean.FALSE)).setRequired(true));
		form.add(new SubmitLink("submit"));
	}
}