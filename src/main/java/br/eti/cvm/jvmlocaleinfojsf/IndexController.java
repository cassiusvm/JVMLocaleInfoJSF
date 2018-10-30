package br.eti.cvm.jvmlocaleinfojsf;

import java.time.ZonedDateTime;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lombok.Getter;

@Named
@RequestScoped
@Getter
public class IndexController {
	private String defaultLocale;
	private String countryLocale;
	private String languageLocale;
	private String nameLocale;
	private String languageTagLocale;
	private String timeZone;
	private String offSet;

	@PostConstruct
	public void init() {
		Locale localeDef = Locale.getDefault();

		defaultLocale = localeDef.toString();

		countryLocale = localeDef.getDisplayCountry() + ", " + localeDef.getCountry() + ", "
				+ localeDef.getISO3Country();

		languageLocale = localeDef.getDisplayLanguage() + ", " + localeDef.getLanguage() + ", "
				+ localeDef.getISO3Language();

		nameLocale = localeDef.getDisplayName();

		languageTagLocale = localeDef.toLanguageTag();

		ZonedDateTime now = ZonedDateTime.now();

		timeZone = now.getZone().toString();

		offSet = now.getOffset().toString();
	}
}
