package a.b.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import cppParser.*;
import cppMetrics.*;

public class SampleTest {

	private String file = "";
	private Extractor e;
	
	@Test
	public void test() {
		fail("Not yet implemented");		
	}

	public SampleTest() {
		super();
		// TODO Auto-generated constructor stub
		this.file = new String("E:\\Study Files\\STUDY\\COU\\programming\\OOP\\resitTran\\CardPayment.cpp");
		this.e = new Extractor(file);		
	}
	
	@Test
	public void testEqual(){
		try {
			LOCMetrics locme =  new LOCMetrics(file);
			e.process();
			assertEquals(locme.getLoc(), e.getLoc());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
