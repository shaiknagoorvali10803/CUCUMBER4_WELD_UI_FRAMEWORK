package Utils;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import io.cucumber.core.api.Scenario;

/*
 * Idea behind this class is to store any information across scenario step definitions.
 * 
 * Set context information in contextData in any step definition and use it in any other step definition.
 */
@Singleton
public class ScenarioContext {
	private Scenario scenario;
	private Map<String, Object> contextData;
	
	public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

	public Map<String, Object> getContextData() {
		return contextData;
	}

	public void setContextData(Map<String, Object> contextData) {
		this.contextData = contextData;
	}

    public void clearContextData() {
    	this.contextData = new HashMap<>();
    }
}
