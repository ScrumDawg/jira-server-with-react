package ut.de.mola.jira.spielwiese;

import org.junit.Test;
import de.mola.jira.spielwiese.api.MyPluginComponent;
import de.mola.jira.spielwiese.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}