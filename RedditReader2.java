import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RedditReader2 
{
	String fileToAnalyze; 
	String line;
	String line2;
	int index;
	int counter;
	int max;
	int min;
	String[] negative = {"fuck","shit","disgrace","destroy","fake","lies","crap","wtf","faggot","ass","stupid"};
	
	//CONSTRUCTORS//
	RedditReader2()
	{
		fileToAnalyze = "";		
	}
	RedditReader2(String file)
	{
		fileToAnalyze = file;		
	}
	//METHOD THAT RETURNS THE NUMBER OF TIMES A POST REFERS TO A DEMOCRAT//
	void getNumberOfDem()
	{
		int hCount = 0;
		int bCount = 0;
		int oCount = 0;
		int hCount_n = 0;
		int bCount_n = 0;
		int oCount_n = 0;
		line = null;
		ArrayList<String> posts = new ArrayList<String>();
		try
		{
			FileReader myFileReader = new FileReader("redditPosts.txt");
			BufferedReader myBufferReader = new BufferedReader(myFileReader);
			while((line=myBufferReader.readLine())!=null)
			{
				String line2 = line.toLowerCase();
				posts.add(line2);
			} 
			String reading;
			for(int j=0;j<posts.size();j++)
			{
				reading = posts.get(j);
				if(reading.contains("bernie") || reading.contains("sanders"))
				{
					for(int k=0;k<negative.length-1;k++)
					{
						if(reading.contains(negative[k]))
							bCount_n++;
					}
					bCount++;
				}
				else if(reading.contains("hillary") || reading.contains("clinton"))
				{
					for(int k=0;k<negative.length-1;k++)
					{
						if(reading.contains(negative[k]))
							hCount_n++;
					}
					hCount++;
				}
				else if(reading.contains("obama"))
				{
					for(int k=0;k<negative.length-1;k++)
					{
						if(reading.contains(negative[k]))
							oCount_n++;
					}
					oCount++;
				}
			}
			int sum = bCount + hCount + oCount;
			int sum_n = bCount_n + hCount_n + oCount_n;
			double percentd_n = ((double)sum_n/(double)sum)*100;
			System.out.println("Recognizable democrat references were noticed " + sum + " number of times.");
			System.out.println("      Total number of negative posts with democrats mentioned: " + sum_n);
			System.out.println("      Percent of negative posts: " + percentd_n);
			System.out.println("Hillary Clinton count: " + hCount);
			System.out.println("      Negative posts with Clinton mentioned: " + hCount_n);
			System.out.println("Bernie Sanders count: " + bCount);
			System.out.println("      Negative posts with Sanders mentioned: " + bCount_n);
			System.out.println("Obama count: " + oCount);
			System.out.println("      Negative posts with Obama mentioned: " + oCount_n);
		}
		catch (Exception ex)
		{
			System.out.println("Could not open the file");
		}
	}
	//METHOD THAT RETURNS THE NUMBER OF TIMES A POST REFERS TO A REPUBLICAN//
	void getNumberOfRep()
	{
		int tCount = 0;
		int pCount = 0;
		int pCount_n = 0;
		int tCount_n = 0;
		line = null;
		ArrayList<String> posts = new ArrayList<String>();
		try
		{
			FileReader myFileReader = new FileReader("redditPosts.txt");
			BufferedReader myBufferReader = new BufferedReader(myFileReader);
			while((line=myBufferReader.readLine())!=null)
			{
				
				String line2 = line.toLowerCase();
				posts.add(line2);
			} 
			String reading;
			for(int j=0;j<posts.size();j++)
			{
				reading = posts.get(j);
				if(reading.contains("trump") || reading.contains("donald") || reading.contains("president") || reading.contains("prez"))
				{
					for(int k=0;k<negative.length-1;k++)
					{
						if(reading.contains(negative[k]))
							tCount_n++;
					}
					tCount++;
				}
				else if(reading.contains("pence"))
				{
					for(int k=0;k<negative.length-1;k++)
					{
						if(reading.contains(negative[k]))
							pCount_n++;
					}
					pCount++;
				}
			}
			int sum = pCount + tCount;
			int sum_n = pCount_n + tCount_n;
			double percentr_n = ((double)sum_n/(double)sum)*100;
			System.out.println("Recognizable republican references were noticed " + sum + " number of times.");
			System.out.println("      Total number of negative posts with republicans mentioned: " + sum_n);
			System.out.println("      Percent of negative posts: " + percentr_n);
			System.out.println("Trump count: " + tCount);
			System.out.println("      Negative posts with Trump/President mentioned: " + tCount_n);
			System.out.println("Pence count: " + pCount);
			System.out.println("      Negative posts with Pence mentioned: " + pCount_n);
		}
		catch (Exception ex)
		{
			System.out.println("Could not open the file");
		}
	}
	
	//CREATING ARRAYLIST FOR AUTHORS//
	void getAuthor()
	{
		line = null;
		ArrayList<String> author = new ArrayList<String>();
		try
		{
			FileReader myFileReader = new FileReader("authors.txt");
			BufferedReader myBufferReader = new BufferedReader(myFileReader);
			while((line=myBufferReader.readLine())!=null)
			{
				author.add(line);
			} 
			System.out.println(author.get(0));
		}
		catch (Exception ex)
		{
			System.out.println("Could not open the file");
		}
	}
	//CREATING ARRAYLIST FOR NUMCOMMENTS//
	void getNumComm()
	{
		line = null;
		line2 = null;
		max = Integer.MIN_VALUE;
		index = 0;
		ArrayList<String> posts = new ArrayList<String>();
		try
		{
			FileReader myFileReader = new FileReader("redditPosts.txt");
			BufferedReader myBufferReader = new BufferedReader(myFileReader);
			while((line=myBufferReader.readLine())!=null)
			{
				posts.add(line);
			} 
		}
		catch (Exception ex)
		{
			System.out.println("Could not open the file");
		}
		ArrayList<String> author = new ArrayList<String>();
		try
		{
			FileReader myFileReader = new FileReader("authors.txt");
			BufferedReader myBufferReader = new BufferedReader(myFileReader);
			while((line=myBufferReader.readLine())!=null)
			{
				author.add(line);
			} 
		}
		catch (Exception ex)
		{
			System.out.println("Could not open the file");
		}
		ArrayList<Integer> comment = new ArrayList<Integer>();
		try
		{
			FileReader myFileReader = new FileReader("numComments.txt");
			BufferedReader myBufferReader = new BufferedReader(myFileReader);
			while((line2=myBufferReader.readLine())!=null)
			{
				String l_line = line2.toLowerCase();
				int currentComment = Integer.parseInt(l_line);
				comment.add(currentComment);
				for(int i=0; i<comment.size();i++)
				{
					if(comment.get(i) > max)
					{
						max = comment.get(i);
						index = i;
					}
				}
			} 
			System.out.println(posts.get(index) + "\nThis post had " + comment.get(index) + " number of comments and was written by " + author.get(index)+".");
		}
		catch (Exception ex)
		{
			System.out.println("Could not open the file");
		}
	}
	//METHOD THAT RETURNS THE MOST UPVOTED POST//
	void getTopScore()
	{
		index = 0;
		max = 0;
		line = null;
		line2 = null;
		ArrayList<String> posts = new ArrayList<String>();
		try
		{
			FileReader myFileReader = new FileReader("redditPosts.txt");
			BufferedReader myBufferReader = new BufferedReader(myFileReader);
			while((line=myBufferReader.readLine())!=null)
			{
				posts.add(line);
			} 
		}
		catch (Exception ex)
		{
			System.out.println("Could not open the file");
		}
		ArrayList<String> author = new ArrayList<String>();
		try
		{
			FileReader myFileReader = new FileReader("authors.txt");
			BufferedReader myBufferReader = new BufferedReader(myFileReader);
			while((line=myBufferReader.readLine())!=null)
			{
				author.add(line);
			} 
		}
		catch (Exception ex)
		{
			System.out.println("Could not open the file");
		}
		ArrayList<Integer> score = new ArrayList<Integer>();
		try
		{
			FileReader myFileReader = new FileReader("Score.txt");
			BufferedReader myBufferReader = new BufferedReader(myFileReader);
			while((line2=myBufferReader.readLine())!=null)
			{
				String l_line = line2.toLowerCase();
				int currentScore = Integer.parseInt(l_line);
				score.add(currentScore);
				for(int i=0; i<score.size();i++)
				{
					if(score.get(i) > max)
					{
						max = score.get(i);
						index = i;
					}
				}
			} 
			int numPost = index+1;
			System.out.println(posts.get(index));
			System.out.println("This is post number " + numPost + " in the redditPosts file and the author is " + author.get(index) + ".");
		}
		catch (Exception ex)
		{
			System.out.println("Could not open the file");
		}
	}
	
}# RedditReader
