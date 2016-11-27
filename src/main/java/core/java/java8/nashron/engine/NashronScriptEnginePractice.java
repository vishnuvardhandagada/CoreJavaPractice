package core.java.java8.nashron.engine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

/**
 * 
 * @author Donthu Avinash Babu
 *
 */
public class NashronScriptEnginePractice {

    //    @Ignore
    @Test
    public void method1() throws ScriptException {
	ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");

	System.out.println("scriptEngine.getClass().getName() - " + scriptEngine.getClass().getName());
	System.out.println("Result: " + scriptEngine.eval("function fun(){return 10;}"));
    }
}
