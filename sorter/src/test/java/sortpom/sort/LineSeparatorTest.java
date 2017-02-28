package sortpom.sort;

import org.junit.Test;
import sortpom.XmlOutputGenerator;
import sortpom.parameter.PluginParametersBuilder;

import static org.junit.Assert.assertEquals;
import static sortpom.sort.ExpandEmptyElementTest.createXmlFragment;

public class LineSeparatorTest {
    @Test
    public void formattingXmlWithNewlineShouldResultInOneLineBreakAtEnd() throws Exception {
        XmlOutputGenerator xmlOutputGenerator = new XmlOutputGenerator();
        xmlOutputGenerator.setup(new PluginParametersBuilder()
                .setEncoding("UTF-8")
                .setFormatting("\n", false, false)
                .setIndent(2, false)
                .createPluginParameters());

        String actual = xmlOutputGenerator.getSortedXml(createXmlFragment()).toString("UTF-8");
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<Gurka />\n", actual);
    }

    @Test
    public void formattingXmlWithCRShouldResultInOneLineBreakAtEnd() throws Exception {
        XmlOutputGenerator xmlOutputGenerator = new XmlOutputGenerator();
        xmlOutputGenerator.setup(new PluginParametersBuilder()
                .setEncoding("UTF-8")
                .setFormatting("\r", false, false)
                .setIndent(2, false)
                .createPluginParameters());

        String actual = xmlOutputGenerator.getSortedXml(createXmlFragment()).toString("UTF-8");
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r<Gurka />\r", actual);
    }

    @Test
    public void formattingXmlWithCRNLShouldResultInOneLineBreakAtEnd() throws Exception {
        XmlOutputGenerator xmlOutputGenerator = new XmlOutputGenerator();
        xmlOutputGenerator.setup(new PluginParametersBuilder()
                .setEncoding("UTF-8")
                .setFormatting("\r\n", false, false)
                .setIndent(2, false)
                .createPluginParameters());

        String actual = xmlOutputGenerator.getSortedXml(createXmlFragment()).toString("UTF-8");
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<Gurka />\r\n", actual);
    }

}
