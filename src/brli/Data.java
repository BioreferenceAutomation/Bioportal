package brli;

import java.util.Random;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Data {
public static String url = "https://qa.insightdx.com/doctors/framepage.asp";
public static String username = "ULNAME1";
public static String password = "opko123";
public static Random randomGnerator;
public static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
public static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
public static final String NUM = "0123456789";
public static final String SPL_CHARS = "@$-";


//Reusable Method for Generating Random fname 

public static String generatefname()
{
String fname=null;
char[] name = generateRandomData(3, 5, 0, 0, 0);

fname=new String(name);

return fname;
}

//Reusable Method for Generating Random lname 

public static String generatelname()
{
String lname=null;
char[] name = generateRandomData(3, 5, 0, 0, 0);

lname=new String(name);

return lname;
}

//Reusable Method for Generating Random String

public static char[] generateRandomData(int minLen, int maxLen, int noOfCAPSAlpha, int noOfDigits,int noOfSplChars)
{

if(minLen > maxLen)
throw new IllegalArgumentException("Min. Length > Max. Length!");
if( (noOfCAPSAlpha + noOfDigits +noOfSplChars) > minLen )
throw new IllegalArgumentException
("Min. Length should be atleast sum of (CAPS, DIGITS, SPL CHARS) Length!");
Random rnd = new Random();
int len = rnd.nextInt(maxLen - minLen + 1) + minLen;
char[] pswd = new char[len];
int index = 0;
for (int i = 0; i < noOfCAPSAlpha; i++)
{
index = getNextIndex(rnd, len, pswd);
pswd[index] = ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length()));
}
for (int i = 0; i < noOfDigits; i++)
{
index = getNextIndex(rnd, len, pswd);
pswd[index] = NUM.charAt(rnd.nextInt(NUM.length()));
}
for (int i = 0; i < noOfSplChars; i++)
{
index = getNextIndex(rnd, len, pswd);
pswd[index] = SPL_CHARS.charAt(rnd.nextInt(SPL_CHARS.length()));
}
for(int i = 0; i < len; i++)
{
if(pswd[i] == 0)
{
pswd[i] = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
}
}
return pswd;
}

public static int getNextIndex(Random rnd, int len, char[] pswd) {
int index = rnd.nextInt(len);
while(pswd[index = rnd.nextInt(len)] != 0);
return index;
}

//Usage

public static void main(String args[]) throws ParseException {


System.out.println(Data.generatefname());
System.out.println(Data.generatelname());
System.out.println(Data.generateRandomData(10, 11, 1, 1, 1));

}

}