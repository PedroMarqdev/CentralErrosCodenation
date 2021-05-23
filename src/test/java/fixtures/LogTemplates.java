package fixtures;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.Squad.Interestellar.Central.Erros.entity.EventLog;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LogTemplates implements TemplateLoader {
 LocalDateTime data = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/Sao_Paulo"));
 @Override
 public void load() {
	Fixture.of(EventLog.class).addTemplate("log-valid", new Rule() {{
	 add("level", EventLog.levelType.ERROR);
	 add("description", "ERROR 503 GATEWAY");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("source", "Feign CLIENT API");
	 add("quantity", "2");
	}});
	Fixture.of(EventLog.class).addTemplate("log-without-level", new Rule() {{
	 add("description", "ERROR 503 GATEWAY");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("source", "Feign CLIENT API");
	 add("quantity", "2");
	}});
	Fixture.of(EventLog.class).addTemplate("log-without-description", new Rule() {{
	 add("level", EventLog.levelType.ERROR);
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("source", "Feign CLIENT API");
	 add("quantity", "2");
	}});
	Fixture.of(EventLog.class).addTemplate("log-without-eventLog", new Rule() {{
	 add("level", EventLog.levelType.ERROR);
	 add("description", "ERROR 503 GATEWAY");
	 add("source", "Feign CLIENT API");
	 add("quantity", "2");
	}});
	Fixture.of(EventLog.class).addTemplate("log-without-source", new Rule() {{
	 add("level", EventLog.levelType.ERROR);
	 add("description", "ERROR 503 GATEWAY");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("quantity", "2");
	}});
	Fixture.of(EventLog.class).addTemplate("log-without-quantity", new Rule() {{
	 add("level", EventLog.levelType.ERROR);
	 add("description", "ERROR 503 GATEWAY");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("source", "Feign CLIENT API");
	}});
	Fixture.of(EventLog.class).addTemplate("log-without-date", new Rule() {{
	 add("level", EventLog.levelType.ERROR);
	 add("description", "ERROR 503 GATEWAY");
	 add("eventLog", "PORT BAD FUNCTION REPORT");
	 add("source", "Feign CLIENT API");
	 add("quantity", "2");
	 add("date", "");
	}});
 }
}