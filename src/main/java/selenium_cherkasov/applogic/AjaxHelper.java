package selenium_cherkasov.applogic;

import selenium_cherkasov.pages.AjaxTestPage;

public interface AjaxHelper {

	void SumOK();

	void SumNOTOK();

	void ensureIncorrectResult();

	void ensureCorrectResult();

}
