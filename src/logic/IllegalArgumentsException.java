/**
 * 
 */
package logic;


public class IllegalArgumentsException extends Exception {

}
/*
public GateAnd(LogicVariable w1, LogicVariable x1, LogicVariable x2) throws ColisionException, CycleException	 {
	
	if(w1.getCalculatedBy() != null ) //se o valor de w2 ja tem um valor definido
		throw new ColisionException();
	
	if(x1.getCalculatedBy() != null) {
		if(x1.getCalculatedBy().getInputs()[0] == w1)
			throw new CycleException();
		if(x1.getCalculatedBy().getInputs()[1] == w1)
			throw new CycleException();
	}
	if(x2.getCalculatedBy() != null) {
		if(x2.getCalculatedBy().getInputs()[0] == w1)
			throw new CycleException();
		if(x2.getCalculatedBy().getInputs()[1] == w1)
			throw new CycleException();
	}
	
	this.output = w1;
	this.inputs = new LogicVariable[2];
	this.inputs[0] = x1;
	this.inputs[1] = x2;
	setFormula();
	setValue();
	
	this.output.setGate(this);
}



public SimpleIngredient(String name) {
	if(name ==  null) throw IllegalArgumentsException();
	this.name = name	
}

public Ingredient() throws IllegalArgumentsException {
	if(name == null)
	throw new IllegalArgumentsException();
}


public RecipeStep(String string, String string2) //throws IllegalArgumentsException
{
	if(string == null || string2 == null) throw new IllegalArgumentException();
	this.name = string;
	this.action = string2;
	this.ingLista = new ArrayList<SimpleIngredient>();
}

@Test
public void testStep() {
    RecipeStep slice = new RecipeStep("mixed fruits", "slice");
    assertEquals("mixed fruits", slice.getName());
    assertEquals("slice", slice.getAction());
    
    try {
    	new RecipeStep(null, "slice");
    	fail("Constructor has null argument");
    } catch (IllegalArgumentException e) {
    	// exception thrown!
    }
    
    try {
    	new RecipeStep("mixed fruits", null);
    	fail("Constructor has null argument");
    } catch (IllegalArgumentException e) {
    	// exception thrown!
    } 
    
    fieldsArentPublic(RecipeStep.class);
}

@Test
public void testCalculatedBy() throws Exception {
	LogicVariable x1 = new LogicVariable("x1", false);
	LogicVariable x2 = new LogicVariable("x2", false);
	LogicVariable y1 = new LogicVariable("y1");

	LogicGate p1 = new GateAnd(y1, x1, x2);

	assertSame(p1, y1.getCalculatedBy());
	assertSame(null, x1.getCalculatedBy());
	assertSame(null, x2.getCalculatedBy());
}

// A variable cannot be calculated by multiple gates
@Test(expected = ColisionException.class)
public void testColision() throws Exception {
	LogicVariable x1 = new LogicVariable("x1", false);
	LogicVariable x2 = new LogicVariable("x2", false);
	LogicVariable x3 = new LogicVariable("x3", false);
	LogicVariable x4 = new LogicVariable("x4", false);
	LogicVariable y1 = new LogicVariable("y1");

	LogicGate p1 = new GateAnd(y1, x1, x2);
	LogicGate p2 = new GateOr(y1, x3, x4);
}
	
@Test
public void testFormulas() throws Exception {
	LogicVariable x1 = new LogicVariable("x1", false);
	LogicVariable x2 = new LogicVariable("x2", false);
	LogicVariable x3 = new LogicVariable("x3", false);
	LogicVariable w1 = new LogicVariable("w1");
	LogicVariable w2 = new LogicVariable("w2");
	LogicVariable y1 = new LogicVariable("y1");
	
	LogicGate p1 = new GateAnd(w1, x1, x2);
	LogicGate p2 = new GateOr(w2, w1, x3);
	LogicGate p3 = new GateNot(y1, w2);
	
	assertEquals("x1", x1.getFormula());
	assertEquals("NOT(OR(AND(x1,x2),x3))", y1.getFormula());
	assertEquals("NOT(OR(AND(x1,x2),x3))", p3.getFormula());
}

@Test
public void testValues() throws Exception {
	LogicVariable x1 = new LogicVariable("x1", false);
	LogicVariable x2 = new LogicVariable("x2", true);
	LogicVariable x3 = new LogicVariable("x3", true);
	LogicVariable w1 = new LogicVariable("w1");
	LogicVariable w2 = new LogicVariable("w2");
	LogicVariable y1 = new LogicVariable("y1");
	
	LogicGate p1 = new GateAnd(w1, x1, x2);
	LogicGate p2 = new GateOr(w2, w1, x3);
	LogicGate p3 = new GateNot(y1, w2);
	
	assertEquals(false, x1.getValue());
	assertEquals(true, x2.getValue());
	assertEquals(true, x3.getValue());
	assertEquals(false, w1.getValue());
	assertEquals(true, w2.getValue());
	assertEquals(false, y1.getValue());
	
//	x3.setValue(false);
//	assertEquals(true, y1.getValue());
}

// Circular dependencies are not allowed
@Test(expected = CycleException.class)
public void testCycles() throws Exception {
	LogicVariable w1 = new LogicVariable("w1");
	LogicVariable w2 = new LogicVariable("w2");
	LogicVariable w3 = new LogicVariable("w3");
	
	LogicGate p1 = new GateAnd(w3, w2, w1);
	LogicGate p2 = new GateNot(w2, w3);		
}

*/