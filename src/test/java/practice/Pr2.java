package practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(practice.pr1.class)
public class Pr2 {

	@Test
	public void create() {
		System.out.println("task created");
	}
	@Test
	public void modify() {
		System.out.println("task modified");
	}
	@Test
	public void remove() {
		System.out.println("task removed");
	}
}
