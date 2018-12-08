package Example;

public class TestProxy {
ProxyPerson persona;

public TestProxy() {
	persona = new ProxyPerson();
	persona.saludar();
	persona.decirEstado();
	persona.despedirse();
	
}

public static void main(String[] args) {
	TestProxy pp = new TestProxy();
}
}
