package example.codeclan.com.composition_starter;

import org.junit.Before;
import org.junit.Test;

import behaviours.Protector;

import static org.junit.Assert.assertEquals;

public class WizardTest {

  Wizard wizard;
  Broomstick broomstick;
  Dragon dragon;

  @Before
  public void before(){
    broomstick = new Broomstick("Nimbus", 10);
    dragon = new Dragon("Puff");
    wizard = new Wizard("Toby", broomstick, dragon);
  }

  @Test
  public void hasName(){
    assertEquals("Toby", wizard.getName());
  }

  @Test
  public void hasBroomstick(){
    Broomstick ride = (Broomstick) wizard.getRide();
    assertEquals("Nimbus", ride.getBrand());
  }

  @Test
  public void canFly(){
    assertEquals(wizard.fly(),"mounting broom, running, skipping, flying!");
  }

  @Test
  public void canFlyDragon(){
    Dragon dragon = new Dragon("Smaug");
    wizard = new Wizard("Barry", dragon, dragon);
    assertEquals("Standing up tall, beating wings, lift off!", wizard.fly());
  }

  @Test
  public void canFlyMagicCarpet(){
    MagicCarpet carpet = new MagicCarpet("Hot pink");
    Ogre ogre = new Ogre("Shrek");
    wizard = new Wizard("Neil", carpet, ogre);
    assertEquals("Hovering up, straightening out, flying off!", wizard.fly());
  }

  @Test
  public void canSetRide(){
    Dragon dragon = new Dragon("Norbet");
    wizard.setRide(dragon);
    assertEquals("Standing up tall, beating wings, lift off!", wizard.fly());
  }

  @Test
  public void canDragonProtect(){
    assertEquals("Fire!!", wizard.protect());
  }

  @Test
  public void canOgreProtect(){
    MagicCarpet carpet = new MagicCarpet("Hot pink");
    Ogre ogre = new Ogre("Shrek");
    wizard = new Wizard("Neil", carpet, ogre);
    assertEquals("Spit",wizard.protect());
  }
}