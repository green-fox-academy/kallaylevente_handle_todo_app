import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListItemTest {
  static ListItem listitem;

  @Before
  public void doItBeforeEachTest() throws Exception {
   listitem = new ListItem("walk the dog", "");
  }

  @Test
  public void testConstruction () throws Exception {
    assertEquals("",listitem.getStatus());
  }

  @Test
  public void testSetStatus () throws Exception {
    listitem.setStatus("x");
    assertEquals("x",listitem.getStatus());
  }

  @Test
  public void testToString () throws Exception {
    assertEquals("1 - [] walk the dog",listitem.toString());
  }

  @Test
  public void testToFile () throws Exception {
    assertEquals("walk the dog;",listitem.toFile());
  }


  @Test
  public void testCounter () throws Exception {
    ListItem listitem2 = new ListItem("cook lunch","");
    ListItem listitem3 = new ListItem("cook dinner","");
    assertEquals(3,listitem3.getCounter());
  }


}