public class ErrorCheck
{
	static boolean checkValue(String value)
	{
		try {
			float integer = Float.parseFloat(value);
			if(integer <= 0) return false;
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
}