package dictionaryviewer;

/**
 *
 * @author
 * @source http://code.hammerpig.com/
 * @since 15 May 2010.
 */
import java.util.*;
import java.io.*;

public class BigFile implements Iterable<String>
{
    private BufferedReader _reader;

    public BigFile(String filePath) throws Exception
    {
	try {
            _reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException fileNotFoundException) {
            //System.out.print("Khong tim thay file " + filePath);
            _reader = null;
        }
    }

    public boolean isExist() {
        return (_reader != null);
    }
    public void Close()
    {
	try
	{
	    _reader.close();
	}
	catch (Exception ex) {}
    }

    public Iterator<String> iterator()
    {
	return new FileIterator();
    }

    private class FileIterator implements Iterator<String>
    {
	private String _currentLine;

	public boolean hasNext()
	{
            if (_reader == null) return false;
	    try
	    {
		_currentLine = _reader.readLine();
	    }
	    catch (Exception ex)
	    {
		_currentLine = null;
		ex.printStackTrace();
	    }

	    return _currentLine != null;
	}

	public String next()
	{
	    return _currentLine;
	}

	public void remove()
	{
	}
    }
}