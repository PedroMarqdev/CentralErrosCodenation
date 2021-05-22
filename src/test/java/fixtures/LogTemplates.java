package fixtures
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.Squad.Interestellar.Central.Erros.entity.EventLog;

import java.util.logging.Logger;

public class LogTemplates implements TemplateLoader {

 @Override
 public void load() {
	Fixture.of(EventLog.class).addTemplate("log-valid", new Rule() {{
	 add("level", "ERROR");
	 add("description", "ERROR 503 GATEWAY");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("source", "Feign CLIENT API");
	 add("quantity", "2");
	 add("date", "10-03-2021 14:12");
	}});
	Fixture.of(EventLog.class).addTemplate("log-valid-without-level", new Rule() {{
	 add("description", "ERROR 503 GATEWAY");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("source", "Feign CLIENT API");
	 add("quantity", "2");
	 add("date", "10-03-2021 14:12");
	}});
	Fixture.of(EventLog.class).addTemplate("log-valid-without-description", new Rule() {{
	 add("level", "ERROR");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("source", "Feign CLIENT API");
	 add("quantity", "2");
	 add("date", "10-03-2021 14:12");
	}});
	Fixture.of(EventLog.class).addTemplate("log-valid-without-eventLog", new Rule() {{
	 add("level", "ERROR");
	 add("description", "ERROR 503 GATEWAY");
	 add("source", "Feign CLIENT API");
	 add("quantity", "2");
	 add("date", "10-03-2021 14:12");
	}});
	Fixture.of(EventLog.class).addTemplate("log-valid-without-source", new Rule() {{
	 add("level", "ERROR");
	 add("description", "ERROR 503 GATEWAY");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("quantity", "2");
	 add("date", "10-03-2021 14:12");
	}});
	Fixture.of(EventLog.class).addTemplate("log-valid-without-quantity", new Rule() {{
	 add("level", "ERROR");
	 add("description", "ERROR 503 GATEWAY");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("source", "Feign CLIENT API");
	 add("date", "10-03-2021 14:12");
	}});
	Fixture.of(EventLog.class).addTemplate("log-valid-without-date", new Rule() {{
	 add("level", "ERROR");
	 add("description", "ERROR 503 GATEWAY");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("source", "Feign CLIENT API");
	 add("quantity", "2");
	}});
 }
}