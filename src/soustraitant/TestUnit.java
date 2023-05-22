package soustraitant;

import junit.framework.TestCase;

public class TestUnit extends TestCase{
	
	SousTraitant a = new SousTraitant("A");
	SousTraitant b = new SousTraitant("B");

	SousTraitant c = new SousTraitant("C");
	SousTraitant d = new SousTraitant("D");
	
	// CAS 1 : a-->b et a-->b, Impossible ajout a
	public void testCas1() throws Exception {
		a.addSousTraitant(b);  
		b.addSousTraitant(a);
	}
	
	
	// CAS 2 : a-->b b-->c, et c-->a Impossible ajoute a
	public void testCas2() throws Exception {
		a.addSousTraitant(b);  
		b.addSousTraitant(c);
		c.addSousTraitant(a);
	}

	// CAS 3 : a-->b b-->c, a-->d et d--> c possible ajout c
	public void testCas3() throws Exception {
		a.addSousTraitant(b);  
		b.addSousTraitant(c);
		a.addSousTraitant(d);
		d.addSousTraitant(c);

	}

	// CAS 4 : a-->b b-->c, a-->c impossible ajout c
	public void testCas4() throws Exception {
		a.addSousTraitant(b);  
		b.addSousTraitant(c);
		a.addSousTraitant(c);

	}

	// CAS 5 : a-->b b-->c, a-->d et d--> c impossible ajout d
	public void testCas5() throws Exception {
		a.addSousTraitant(b);  
		b.addSousTraitant(c);
		c.addSousTraitant(d);
		a.addSousTraitant(d);
	}
	
	// CAS 6 : a-->b c-->d, b-->c et a-->c impossible ajout d
	public void testCas6() throws Exception {
		a.addSousTraitant(b); 
		c.addSousTraitant(d);
		b.addSousTraitant(c);
		a.addSousTraitant(d);

	}

	// ce test doit donner le même résultat que testCas6
	// CAS 7 : a-->b b-->c, a-->d et d--> c impossible ajout d
	public void testCas7() throws Exception {
		a.addSousTraitant(b);
		b.addSousTraitant(c);
		a.addSousTraitant(d);
		c.addSousTraitant(d);
	}
}
